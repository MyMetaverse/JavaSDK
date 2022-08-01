package io.mymetavese.metaapi.requests.actions;

import com.google.gson.Gson;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.GetPointsAction;
import io.mymetavese.metaapi.api.entities.v2.GameEntity;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.routes.Routes;
import okhttp3.Response;

import java.io.IOException;
import java.io.Reader;
import java.util.Objects;

public class GetPointsActionImpl extends RestActionImpl<String> implements GetPointsAction {

    private final String playerID;

    public GetPointsActionImpl(MetaAPI api, GameEntity gameEntity) {
        super(api, Routes.GET_POINTS);
        this.playerID = gameEntity.getPlayerID();
    }

    @Override
    protected String compileRoute() {
        return route.compileRoute(playerID);
    }

    @Override
    public String transform(Response response) {

        if (response == null || response.body() == null) {
            throw new NullPointerException("Response cannot be null");
        }

        Gson gson = new Gson();
        try (Reader reader = Objects.requireNonNull(response.body()).charStream()) {
            return gson.fromJson(reader, PointsWrapper.class).balance;
        } catch (IOException ex) {
            // Ignored
        }

        return "0";
    }

    private static class PointsWrapper {
        private String balance;
    }

}
