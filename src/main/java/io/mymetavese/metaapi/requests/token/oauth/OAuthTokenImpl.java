package io.mymetavese.metaapi.requests.token.oauth;

import com.google.gson.Gson;
import lombok.Getter;
import okhttp3.*;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class OAuthTokenImpl implements OAuthToken {

    private final OkHttpClient httpClient;

    private final String clientId;
    private final String clientSecret;

    @Getter private final List<String> oAuthScopes;
    @Getter private final String baseAuthUrl;

    private long tokenExpireTime = 0;
    private String accessToken;
    private String refreshToken;

    OAuthTokenImpl(final String clientId, final String clientSecret, final String baseAuthUrl, final List<String> oAuthScopes) {

        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.baseAuthUrl = baseAuthUrl;
        this.oAuthScopes = oAuthScopes;

        this.httpClient = new OkHttpClient();

    }

    private boolean shouldUpdateToken() {
        long currentTime = System.currentTimeMillis();
        return this.tokenExpireTime - currentTime <= 0;
    }

    private void requestToken(boolean withCredentials) {

        Gson gson = new Gson();
        Request.Builder builder = new Request.Builder();
        HttpUrl.Builder urlBuilder = new HttpUrl.Builder();

        if (this.oAuthScopes == null || this.oAuthScopes.isEmpty())
            throw new RuntimeException("OAuth scopes are not available, please provide at least one OAuth Scope.");

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

            TokenResponse tokenResponse = gson.fromJson(Objects.requireNonNull(response.body()).charStream(), TokenResponse.class);

            this.accessToken = tokenResponse.getAccessToken();
            this.refreshToken = tokenResponse.getRefreshToken();
            this.tokenExpireTime = System.currentTimeMillis() + (tokenResponse.getExpiresIn() * 1000L);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private String getOAuthScopesAsString() {

        StringBuilder oAuthScopesStringBuilder = new StringBuilder();

        this.oAuthScopes.forEach(scope -> {
            oAuthScopesStringBuilder.append(scope);
            oAuthScopesStringBuilder.append(" ");
        });

        return oAuthScopesStringBuilder.toString();

    }

    @Override
    public String getToken() {
        if (shouldUpdateToken())
            this.requestToken(false);
        return accessToken;
    }

    @Override
    public void reauthenticate() {
        this.requestToken(true);
    }

}
