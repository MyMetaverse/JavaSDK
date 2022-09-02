package io.mymetavese.metaapi.requests.actions.p2e;

import com.google.gson.Gson;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.p2e.AddP2EPointsAction;
import io.mymetavese.metaapi.api.entities.p2e.P2EResponse;
import io.mymetavese.metaapi.api.entities.v2.GameEntity;
import io.mymetavese.metaapi.requests.JsonObject;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.entities.p2e.P2EResponseImpl;
import io.mymetavese.metaapi.requests.routes.Routes;
import okhttp3.Response;

import java.io.IOException;
import java.io.Reader;
import java.util.Objects;
import java.util.UUID;

public class AddP2EPointsActionImpl extends RestActionImpl<P2EResponse> implements AddP2EPointsAction {

    private final String playerID;
    private final int points;

    public AddP2EPointsActionImpl(MetaAPI api, GameEntity gameEntity, int points) {

        super(api, Routes.ADD_P2E_POINTS, P2EResponseImpl.class);
        this.playerID = gameEntity.getPlayerID();
        this.points = points;

        addHeader("Idempotency-Key", UUID.randomUUID().toString());

    }

    public AddP2EPointsActionImpl(MetaAPI api, GameEntity gameEntity, int points, String idempotencyKey) {

        super(api, Routes.ADD_P2E_POINTS, P2EResponseImpl.class);
        this.playerID = gameEntity.getPlayerID();
        this.points = points;

        addHeader("Idempotency-Key", idempotencyKey);

    }

    @Override
    public P2EResponse transform(Response response) {

        if (response == null || response.body() == null) {
            throw new NullPointerException("Response cannot be null");
        }

        Gson gson = new Gson();
        try (Reader reader = Objects.requireNonNull(response.body()).charStream()) {
            return gson.fromJson(reader, P2EResponseImpl.class);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;

    }

    @Override
    protected String compileRoute() {
        return route.compileRoute(playerID);
    }

    @Override
    protected JsonObject buildBody() {
        JsonObject body = JsonObject.JsonObjectBuilder.newBuilder().create();
        body.append("amount", points);
        return body;
    }

}
