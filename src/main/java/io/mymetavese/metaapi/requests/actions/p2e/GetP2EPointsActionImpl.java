package io.mymetavese.metaapi.requests.actions.p2e;

import com.google.gson.Gson;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.p2e.GetP2EPointsAction;
import io.mymetavese.metaapi.api.entities.p2e.P2EResponse;
import io.mymetavese.metaapi.api.entities.v2.GameEntity;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.entities.p2e.P2EResponseImpl;
import io.mymetavese.metaapi.requests.routes.Routes;
import okhttp3.Response;

import java.io.IOException;
import java.io.Reader;
import java.util.Objects;

public class GetP2EPointsActionImpl extends RestActionImpl<P2EResponse> implements GetP2EPointsAction {

    private final String playerID;

    public GetP2EPointsActionImpl(MetaAPI api, GameEntity gameEntity) {
        super(api, Routes.GET_P2E_POINTS);
        this.playerID = gameEntity.getPlayerID();
    }

    @Override
    protected String compileRoute() {
        return route.compileRoute(playerID);
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

}
