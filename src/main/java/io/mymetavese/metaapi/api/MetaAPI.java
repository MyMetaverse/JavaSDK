package io.mymetavese.metaapi.api;

import io.mymetavese.metaapi.MetaAPIImpl;
import io.mymetavese.metaapi.api.entities.GameEntity;
import io.mymetavese.metaapi.api.entities.Token;
import io.mymetavese.metaapi.requests.token.TokenHandler;

public interface MetaAPI {

    /**
     * Build a new player ready to execute actions..
     * @param playerID The player ID that the player should use.
     * @return A player with their possible actions.
     */
    GameEntity buildPlayer(String playerID);

    /**
     * Build a new token ready to execute actions.
     * @param id The ID of this token.
     * @param index The index of this token.
     * @return The token ready to execute actions.
     */
    Token buildToken(String id, String index);

    final class Builder {
        private TokenHandler tokenHandler;

        private Builder() {
        }

        public static Builder createBuilder() {
            return new Builder();
        }

        public MetaAPIImpl.Builder withTokenHandler(TokenHandler tokenHandler) {
            return this;
        }

        public MetaAPIImpl build() {
            return new MetaAPIImpl(tokenHandler);
        }

    }

}
