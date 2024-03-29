package io.mymetavese.metaapi.requests.actions;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.CreateLinkingLinkAction;
import io.mymetavese.metaapi.api.entities.v2.GameEntity;
import io.mymetavese.metaapi.api.entities.LinkingLink;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.entities.LinkingLinkImpl;
import io.mymetavese.metaapi.requests.routes.Routes;

public class CreateLinkingLinkActionImpl extends RestActionImpl<LinkingLink> implements CreateLinkingLinkAction {

    private final GameEntity gameEntity;

    public CreateLinkingLinkActionImpl(MetaAPI api, GameEntity gameEntity) {
        super(api, Routes.CREATE_LINKING_LINK, LinkingLinkImpl.class);
        this.gameEntity = gameEntity;
    }

    @Override
    protected String compileRoute() {
        return route.compileRoute(gameEntity.getPlayerID());
    }
}
