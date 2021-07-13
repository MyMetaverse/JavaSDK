package io.mymetavese.metaapi.requests.token;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import okhttp3.*;

import java.io.IOException;
import java.util.Objects;

public class OAuthToken implements TokenHandler {

    private final static MediaType JSON_MEDIA_TYPE = MediaType.get("application/json; charset=utf-8");
    // Data to generate token
    private final OkHttpClient httpClient;
    private final Gson gson;

    private final String clientId;
    private final String clientSecret;

    private OAuthToken(final String clientId, final String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;

        this.httpClient = new OkHttpClient();
        this.gson = new Gson();

    }

    // Token Hybrid
    private long tokenExpireTime = 0;
    private String accessToken;
    private String refreshToken;

    private boolean shouldUpdateToken() {
        long currentTime = System.currentTimeMillis();

        return this.tokenExpireTime - currentTime <= 0;
    }

    private void requestToken(boolean withCredentials) {
        Request.Builder builder = new Request.Builder();
        String baseUrl = "devcloud.mymetaverse.io";

        HttpUrl.Builder urlBuilder = new HttpUrl.Builder();

        urlBuilder
                .scheme("https")
                .host(baseUrl)
                .addPathSegment("oauth2")
                .addPathSegment("token");

        if (withCredentials) {
            urlBuilder.addQueryParameter("grant_type", "client_credentials");
            urlBuilder.addQueryParameter("client_id", this.clientId);
            urlBuilder.addQueryParameter("client_secret", this.clientSecret);
        } else {
            if (this.refreshToken == null)
                throw new NullPointerException("Refresh token is not available, try first with credentials.");

            urlBuilder.addQueryParameter("grant_type", "refresh_token");
            urlBuilder.addQueryParameter("refresh_token", this.refreshToken);
        }

        builder.url(urlBuilder.build());

        builder.get();

        try (Response response = httpClient.newCall(builder.build()).execute()) {
            if (response.code() != 200) {
                throw new IOException("Internal server error: " + Objects.requireNonNull(response.body()).string());
            }

            TokenResponse tokenResponse = this.gson.fromJson(Objects.requireNonNull(response.body()).charStream(), TokenResponse.class);

            this.accessToken = tokenResponse.accessToken;
            this.refreshToken = tokenResponse.refreshToken;
            this.tokenExpireTime = System.currentTimeMillis() + tokenResponse.expiresIn;

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static OAuthToken create(final String clientId, final String clientSecret) {
        OAuthToken tokenHandler = new OAuthToken(clientId, clientSecret);
        tokenHandler.requestToken(true);
        return tokenHandler;
    }

    @Override
    public String getToken() {
        if (shouldUpdateToken())
            this.requestToken(false);
        return accessToken;
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
