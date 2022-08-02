package io.mymetavese.metaapi.requests.actions.p2e;

import com.google.gson.Gson;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.p2e.GetP2EPointsAction;
import io.mymetavese.metaapi.api.entities.P2EPoints;
import io.mymetavese.metaapi.api.entities.v2.GameEntity;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.entities.P2EPointsImpl;
import io.mymetavese.metaapi.requests.routes.Routes;
import okhttp3.Response;

import java.io.IOException;
import java.io.Reader;
import java.util.Objects;

public class GetP2EPointsActionImpl extends RestActionImpl<P2EPoints> implements GetP2EPointsAction {

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
    public P2EPoints transform(Response response) {

        if (response == null || response.body() == null) {
            throw new NullPointerException("Response cannot be null");
        }

        Gson gson = new Gson();
        try (Reader reader = Objects.requireNonNull(response.body()).charStream()) {
            return new P2EPointsImpl(gson.fromJson(reader, PointsWrapper.class).balance);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;

    }

    private static class PointsWrapper {
        private int profileId;
        private int balance;
    }

}
