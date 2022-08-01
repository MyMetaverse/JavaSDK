package io.mymetavese.metaapi.requests.actions;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.AddPointsAction;
import io.mymetavese.metaapi.api.entities.v2.GameEntity;
import io.mymetavese.metaapi.requests.JsonObject;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.entities.PointsImpl;
import io.mymetavese.metaapi.requests.routes.Routes;

public class AddPointsActionImpl extends RestActionImpl<PointsImpl> implements AddPointsAction {

    private final String playerID;
    private final String points;

    public AddPointsActionImpl(MetaAPI api, GameEntity gameEntity, int points) {
        super(api, Routes.ADD_POINTS, PointsImpl.class);
        this.playerID = gameEntity.getPlayerID();
        this.points = String.valueOf(points);
    }

    @Override
    protected String compileRoute() {
        return route.compileRoute(playerID);
    }

    @Override
    protected JsonObject buildBody() {
        JsonObject body  = JsonObject.JsonObjectBuilder.newBuilder().create();

        body.append("points", points);

        return body;
    }
}
