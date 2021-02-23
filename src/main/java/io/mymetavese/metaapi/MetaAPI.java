package io.mymetavese.metaapi;

import io.mymetavese.metaapi.api.entities.Item;
import io.mymetavese.metaapi.api.entities.ItemMetadata;
import io.mymetavese.metaapi.api.entities.Player;
import io.mymetavese.metaapi.requests.RequestGenerator;
import io.mymetavese.metaapi.requests.entities.ItemImpl;
import io.mymetavese.metaapi.requests.entities.ItemMetadataImpl;
import io.mymetavese.metaapi.requests.entities.PlayerImpl;
import lombok.Getter;
import okhttp3.OkHttpClient;

import java.util.Collections;
import java.util.List;

public class MetaAPI implements API {

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

    public Item buildItem(String tokenId, String tokenIndex) {
        return new ItemImpl(this, tokenId, false, Collections.singletonList(tokenIndex), 0);
    }

    public Item buildItem(String tokenId, boolean isNFT, List<String> tokenIndexes, int amount) {
        return new ItemImpl(this, tokenId, isNFT, tokenIndexes, amount);
    }

    public ItemMetadata buildItemMetadata(String tokenId, String tokenIndex) {
        return new ItemMetadataImpl(this, tokenId, tokenIndex);
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
