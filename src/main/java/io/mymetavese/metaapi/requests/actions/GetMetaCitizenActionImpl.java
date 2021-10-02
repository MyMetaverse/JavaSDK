package io.mymetavese.metaapi.requests.actions;

import com.google.gson.Gson;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.GetMetaCitizenAction;
import io.mymetavese.metaapi.api.entities.v2.GameEntity;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.routes.Routes;
import okhttp3.Response;

import java.util.Objects;

public class GetMetaCitizenActionImpl extends RestActionImpl<String> implements GetMetaCitizenAction {

    private final String playerID;

    public GetMetaCitizenActionImpl(MetaAPI api, GameEntity gameEntity) {
        super(api, Routes.GET_ACTIVE_META_CITIZEN);
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
        return gson.fromJson(Objects.requireNonNull(response.body()).charStream(), MetaCitizenWrapper.class).index;

    }

    private static class MetaCitizenWrapper {
        private String index;
    }

}
