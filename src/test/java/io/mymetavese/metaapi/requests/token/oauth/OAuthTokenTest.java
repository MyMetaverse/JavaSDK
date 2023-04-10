package io.mymetavese.metaapi.requests.token.oauth;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OAuthTokenTest {

    @Test
    @DisplayName("Test OAuthTokenBuilder")
    void testOAuthTokenBuilder() {

        String clientID = "dummyClientID";
        String clientSecret = "dummyClientSecret";
        String authenticationAddress = "dummyAuthenticationAddress";
        String[] scopes = new String[] {"dummyScope1", "dummyScope2"};

        OAuthToken oAuthToken = OAuthToken.Builder.createBuilder()
                .withClientID(clientID)
                .withClientSecret(clientSecret)
                .withAuthenticationAddress(authenticationAddress)
                .useScopes(scopes)
                .build();

        assertThat(oAuthToken)
                .isNotNull()
                .isInstanceOf(OAuthTokenImpl.class)
                .hasFieldOrPropertyWithValue("clientId", clientID)
                .hasFieldOrPropertyWithValue("clientSecret", clientSecret)
                .hasFieldOrPropertyWithValue("baseAuthUrl", authenticationAddress);

        assertThat(oAuthToken.getOAuthScopes())
                .hasSize(2)
                .containsExactly(scopes);

    }

}