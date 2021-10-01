package io.mymetavese.metaapi.requests.actions;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.LinkPlayerAction;
import io.mymetavese.metaapi.api.entities.v2.GameEntity;
import io.mymetavese.metaapi.api.entities.Message;
import io.mymetavese.metaapi.requests.JsonObject;
import io.mymetavese.metaapi.requests.RestActionImpl;

public class LinkPlayerActionImpl extends RestActionImpl<Message> implements LinkPlayerAction {

    private final GameEntity gameEntity;

    private final String linkingCode;

    public LinkPlayerActionImpl(MetaAPI api, GameEntity gameEntity, String linkingCode) {
        super(api, null);

        this.gameEntity = gameEntity;
        this.linkingCode = linkingCode;
    }

    @Override
    protected JsonObject buildBody() {
        JsonObject body = JsonObject.JsonObjectBuilder.newBuilder().create();
        body.append("PlayerID", gameEntity.getPlayerID());
        body.append("LinkingCode", linkingCode);
        return body;
    }

}
