package io.mymetavese.metaapi;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.entities.GameEntity;
import io.mymetavese.metaapi.api.entities.Token;
import io.mymetavese.metaapi.requests.RequestGenerator;
import io.mymetavese.metaapi.requests.entities.GameEntityImpl;
import io.mymetavese.metaapi.requests.entities.TokenImpl;
import lombok.Getter;
import okhttp3.OkHttpClient;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class MetaAPIImpl implements MetaAPI {

    @Getter
    private final String token;

    @Getter
    private final RequestGenerator requestGenerator;

    @Getter
    private final ExecutorService executorService;

    @Getter
    private final ScheduledExecutorService scheduledExecutorService;

    @Getter
    private final OkHttpClient client;

    public MetaAPIImpl(String token) {
        this.token = token;

        client = new OkHttpClient();
        this.requestGenerator = new RequestGenerator(this, client);
        this.executorService = Executors.newCachedThreadPool();
        this.scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    }

    public GameEntity buildPlayer(String playerID) {
        return new GameEntityImpl(this, playerID);
    }

    @Override
    public Token buildToken(String id, String index) {
        return new TokenImpl(this, id, index, 0);
    }

}
