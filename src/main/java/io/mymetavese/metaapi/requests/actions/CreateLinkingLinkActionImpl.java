package io.mymetavese.metaapi.requests.actions;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.CreateLinkingLinkAction;
import io.mymetavese.metaapi.api.entities.GameEntity;
import io.mymetavese.metaapi.api.entities.LinkingLink;
import io.mymetavese.metaapi.requests.JsonObject;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.entities.LinkingLinkImpl;

public class CreateLinkingLinkActionImpl extends RestActionImpl<LinkingLink> implements CreateLinkingLinkAction {

    private final GameEntity gameEntity;

    public CreateLinkingLinkActionImpl(MetaAPI api, GameEntity gameEntity) {
        super(api, null, LinkingLinkImpl.class);
        this.gameEntity = gameEntity;
    }

    @Override
    protected JsonObject buildBody() {
        JsonObject body = JsonObject.JsonObjectBuilder.newBuilder().create();
        body.append("playerId", gameEntity.getPlayerID());
        return body;
    }

}
