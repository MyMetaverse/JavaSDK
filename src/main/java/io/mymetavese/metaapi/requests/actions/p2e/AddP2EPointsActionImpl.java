package io.mymetavese.metaapi.requests.actions.p2e;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.p2e.AddP2EPointsAction;
import io.mymetavese.metaapi.api.entities.v2.GameEntity;
import io.mymetavese.metaapi.requests.JsonObject;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.entities.P2EPointsImpl;
import io.mymetavese.metaapi.requests.routes.Routes;

public class AddP2EPointsActionImpl extends RestActionImpl<P2EPointsImpl> implements AddP2EPointsAction {

    private final String playerID;
    private final int points;

    public AddP2EPointsActionImpl(MetaAPI api, GameEntity gameEntity, int points) {
        super(api, Routes.ADD_P2E_POINTS, P2EPointsImpl.class);
        this.playerID = gameEntity.getPlayerID();
        this.points = points;
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
