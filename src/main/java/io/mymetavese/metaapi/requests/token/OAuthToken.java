package io.mymetavese.metaapi.requests.token;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import okhttp3.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class OAuthToken implements TokenHandler {

    private final static MediaType JSON_MEDIA_TYPE = MediaType.get("application/x-www-form-urlencoded; charset=utf-8");
    private static final RequestBody EMPTY_BODY = RequestBody.create(new byte[0], JSON_MEDIA_TYPE);
    // Data to generate token
    private final OkHttpClient httpClient;
    private final Gson gson;

    private final String clientId;
    private final String clientSecret;
    private final String[] oAuthScopes;

    private final String baseAuthUrl;

    private OAuthToken(final String clientId, final String clientSecret, final String baseAuthUrl) {

        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.baseAuthUrl = baseAuthUrl;
        this.oAuthScopes = new String[] {"wallet.read", "p2e.read", "p2e.add", "linkinglink.create", "linkinglink.read", "linkinglink.implicit"};

        this.httpClient = new OkHttpClient();
        this.gson = new Gson();

    }

    // WalletIndex Hybrid
    private long tokenExpireTime = 0;
    private String accessToken;
    private String refreshToken;

    private boolean shouldUpdateToken() {
        long currentTime = System.currentTimeMillis();

        return this.tokenExpireTime - currentTime <= 0;
    }

    private void requestToken(boolean withCredentials) {
        Request.Builder builder = new Request.Builder();

        HttpUrl.Builder urlBuilder = new HttpUrl.Builder();

        urlBuilder
                .scheme("https")
                .host(baseAuthUrl)
                .addPathSegment("oauth2")
                .addPathSegment("token");

        final FormBody.Builder formBody = new FormBody.Builder();

        if (withCredentials) {

            formBody.add("grant_type", "client_credentials");
            formBody.add("client_id", this.clientId);
            formBody.add("client_secret", this.clientSecret);
            formBody.add("scope", this.getOAuthScopesAsString());

        } else {

            if (this.refreshToken == null)
                throw new NullPointerException("Refresh token is not available, try first with credentials.");

            formBody.add("grant_type", "refresh_token");
            formBody.add("refresh_token", this.refreshToken);

        }

        builder.url(urlBuilder.build());

        builder.post(formBody.build());

        try (Response response = httpClient.newCall(builder.build()).execute()) {
            if (response.code() != 200) {
                throw new IOException("Internal server error: " + Objects.requireNonNull(response.body()).string());
            }

            TokenResponse tokenResponse = this.gson.fromJson(Objects.requireNonNull(response.body()).charStream(), TokenResponse.class);

            this.accessToken = tokenResponse.accessToken;
            this.refreshToken = tokenResponse.refreshToken;
            this.tokenExpireTime = System.currentTimeMillis() + (tokenResponse.expiresIn * 1000L);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static OAuthToken create(final String clientId, final String clientSecret) {
        OAuthToken tokenHandler = new OAuthToken(clientId, clientSecret, "cloud.mymetaverse.io");
        tokenHandler.requestToken(true);
        return tokenHandler;
    }

    public static OAuthToken create(final String clientId, final String clientSecret, final String baseAuthUrl) {
        OAuthToken tokenHandler = new OAuthToken(clientId, clientSecret, baseAuthUrl);
        tokenHandler.requestToken(true);
        return tokenHandler;
    }

    @Override
    public String getToken() {
        if (shouldUpdateToken())
            this.requestToken(false);
        return accessToken;
    }

    public String getOAuthScopesAsString() {

        StringBuilder oAuthScopesStringBuilder = new StringBuilder();

        Arrays.stream(this.oAuthScopes).forEach(scope -> {
            oAuthScopesStringBuilder.append(scope);
            oAuthScopesStringBuilder.append(" ");
        });

        return oAuthScopesStringBuilder.toString();

    }

    @Override
    public void reauthenticate() {
        this.requestToken(true);
    }

    private static class TokenResponse {
        @SerializedName("access_token")
        private String accessToken;
        @SerializedName("token_type")
        private String tokenType;
        @SerializedName("expires_in")
        private int expiresIn;
        @SerializedName("refresh_token")
        private String refreshToken;
    }

}
