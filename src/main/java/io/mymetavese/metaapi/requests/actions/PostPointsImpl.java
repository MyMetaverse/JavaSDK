package io.mymetavese.metaapi.requests.actions;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.PostPointsAction;
import io.mymetavese.metaapi.api.entities.v2.GameEntity;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.entities.PointsImpl;
import io.mymetavese.metaapi.requests.routes.Routes;

public class PostPointsImpl extends RestActionImpl<PointsImpl> implements PostPointsAction {

    private final String playerID;

    public PostPointsImpl(MetaAPI api, GameEntity gameEntity) {
        super(api, Routes.POST_POINTS, PointsImpl.class);
        this.playerID = gameEntity.getPlayerID();
    }

    @Override
    protected String compileRoute() {
        return route.compileRoute(playerID);
    }
}
