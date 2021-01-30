package io.mymetavese.metaapi;

import io.mymetavese.metaapi.api.entities.Player;
import io.mymetavese.metaapi.requests.RequestGenerator;
import io.mymetavese.metaapi.requests.entities.PlayerImpl;
import lombok.Getter;
import okhttp3.OkHttpClient;

public class MetaAPI {

    @Getter
    private final String token;

    @Getter
    private final RequestGenerator requestGenerator;

    @Getter
    private final OkHttpClient client;

    private MetaAPI(String token) {
        this.token = token;

        client = new OkHttpClient();
        this.requestGenerator = new RequestGenerator(this, client);
    }

    public Player buildPlayer(String playerID) {
        return new PlayerImpl(this, playerID);
    }

    public static final class Builder {
        private String token;

        private Builder() {
        }

        public static Builder aMetaAPI() {
            return new Builder();
        }

        public Builder withToken(String token) {
            this.token = token;
            return this;
        }

        public MetaAPI build() {
            return new MetaAPI(token);
        }
    }
}
