package io.mymetavese.metaapi;

import io.mymetavese.metaapi.api.entities.Item;
import io.mymetavese.metaapi.requests.RequestGenerator;
import io.mymetavese.metaapi.requests.entities.ItemImpl;
import lombok.Getter;
import okhttp3.OkHttpClient;

import java.util.Collections;

public class EnjinXAPI implements API{

    @Getter
    private final String token;

    @Getter
    private final RequestGenerator requestGenerator;

    @Getter
    private final OkHttpClient client;

    private EnjinXAPI(String token) {
        this.token = token;
        client = new OkHttpClient();
        this.requestGenerator = new RequestGenerator(this, client);
    }

    public Item buildItem(String tokenId, String tokenIndex) {
        return new ItemImpl(this, tokenId, false, Collections.singletonList(tokenIndex), 0);
    }

    public static final class Builder {

        private String token;

        public static Builder aEnjinXAPI() {
            return new Builder();
        }

        public Builder withToken(String token) {
            this.token = token;
            return this;
        }

        public EnjinXAPI build() {
            return new EnjinXAPI(token);
        }

    }

}
