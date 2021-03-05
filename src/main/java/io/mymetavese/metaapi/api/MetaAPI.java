package io.mymetavese.metaapi.api;

import io.mymetavese.metaapi.MetaAPIImpl;
import io.mymetavese.metaapi.api.entities.Player;
import io.mymetavese.metaapi.api.entities.Token;

public interface MetaAPI {

    Player buildPlayer(String playerID);

    Token buildToken(String id, String index);

    final class Builder {
        private String token;

        private Builder() {
        }

        public static Builder createBuilder() {
            return new Builder();
        }

        public MetaAPIImpl.Builder withToken(String token) {
            this.token = token;
            return this;
        }

        public MetaAPIImpl build() {
            return new MetaAPIImpl(token);
        }
    }

}
