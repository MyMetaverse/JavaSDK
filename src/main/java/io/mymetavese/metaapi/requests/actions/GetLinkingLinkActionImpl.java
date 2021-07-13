package io.mymetavese.metaapi.requests.actions;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.GetLinkingLink;
import io.mymetavese.metaapi.api.entities.GameEntity;
import io.mymetavese.metaapi.api.entities.LinkingLink;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.entities.LinkingLinkImpl;
import io.mymetavese.metaapi.requests.routes.Routes;

public class GetLinkingLinkActionImpl extends RestActionImpl<LinkingLink> implements GetLinkingLink {

    private final GameEntity gameEntity;

    public GetLinkingLinkActionImpl(MetaAPI api, GameEntity gameEntity) {
        super(api, Routes.GET_LINKING_LINK, LinkingLinkImpl.class);
        this.gameEntity = gameEntity;
    }

    @Override
    protected String compileRoute() {
        return route.compileRoute(gameEntity.getPlayerID());
    }
}
