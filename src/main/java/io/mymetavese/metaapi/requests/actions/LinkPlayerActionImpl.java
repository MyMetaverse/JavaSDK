package io.mymetavese.metaapi.requests.actions;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.LinkPlayerAction;
import io.mymetavese.metaapi.api.entities.GameEntity;
import io.mymetavese.metaapi.api.entities.Message;
import io.mymetavese.metaapi.requests.JsonObject;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.Route;

public class LinkPlayerActionImpl extends RestActionImpl<Message> implements LinkPlayerAction {

    private final GameEntity gameEntity;

    private final String linkingCode;

    public LinkPlayerActionImpl(MetaAPI api, GameEntity gameEntity, String linkingCode) {
        super(api, Route.LiveWallet.LINK_PLAYER);

        this.gameEntity = gameEntity;
        this.linkingCode = linkingCode;
    }

    @Override
    protected JsonObject buildBody(JsonObject body) {
        body.append("PlayerID", gameEntity.getPlayerID());
        body.append("LinkingCode", linkingCode);
        return body;
    }

}
