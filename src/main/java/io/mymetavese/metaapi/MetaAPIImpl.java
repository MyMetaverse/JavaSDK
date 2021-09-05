package io.mymetavese.metaapi;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.entities.v2.GameEntity;
import io.mymetavese.metaapi.requests.RequestGenerator;
import io.mymetavese.metaapi.requests.entities.GameEntityImpl;
import io.mymetavese.metaapi.requests.routes.RouteAdapter;
import io.mymetavese.metaapi.requests.routes.V2;
import io.mymetavese.metaapi.requests.token.TokenHandler;
import lombok.Getter;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class MetaAPIImpl implements MetaAPI {

    @Getter
    private final TokenHandler tokenHandler;

    @Getter
    private final RequestGenerator requestGenerator;

    @Getter
    private final ExecutorService executorService;

    @Getter
    private final ScheduledExecutorService scheduledExecutorService;

    @Getter
    private final OkHttpClient client;

    @Getter
    private final RouteAdapter routeAdapter;

    public MetaAPIImpl(TokenHandler tokenHandler, @Nullable RouteAdapter routeAdapter) {
        this.tokenHandler = tokenHandler;

        client = new OkHttpClient();
        this.requestGenerator = new RequestGenerator(this, client);
        this.executorService = Executors.newCachedThreadPool();
        this.scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        if (routeAdapter == null) {
            this.routeAdapter = new V2();
        } else
            this.routeAdapter = routeAdapter;
    }

    public GameEntity buildPlayer(String playerID) {
        return new GameEntityImpl(this, playerID);
    }

}
