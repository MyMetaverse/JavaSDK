package io.mymetavese.metaapi.requests.token.oauth;

import io.mymetavese.metaapi.requests.token.TokenHandler;
import io.mymetavese.metaapi.requests.token.oauth.scopes.OAuthScope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface OAuthToken extends TokenHandler {

    List<String> getOAuthScopes();

    String getBaseAuthUrl();

    final class Builder {

        private String clientID;
        private String clientSecret;
        private String authenticationAddress = "cloud.mymetaverse.io";
        private final List<String> scopes = new ArrayList<>();

        private Builder() { }

        public static OAuthToken.Builder createBuilder() {
            return new OAuthToken.Builder();
        }

        public OAuthToken.Builder withClientID(String clientID) {
            this.clientID = clientID;
            return this;
        }

        public OAuthToken.Builder withClientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }

        public OAuthToken.Builder withAuthenticationAddress(String authenticationAddress) {
            this.authenticationAddress = authenticationAddress;
            return this;
        }

        public OAuthToken.Builder useScopes(OAuthScope... scopes) {
            Arrays.stream(scopes).forEach(scope -> this.scopes.add(scope.getScope()));
            return this;
        }

        public OAuthToken.Builder useScopes(String... scopes) {
            this.scopes.addAll(Arrays.asList(scopes));
            return this;
        }

        public OAuthTokenImpl build() {
            return new OAuthTokenImpl(clientID, clientSecret, authenticationAddress, scopes);
        }

        public OAuthTokenImpl buildAuthenticated() {
            OAuthTokenImpl oAuthToken = new OAuthTokenImpl(clientID, clientSecret, authenticationAddress, scopes);
            oAuthToken.authenticate();
            return oAuthToken;
        }

    }

}
