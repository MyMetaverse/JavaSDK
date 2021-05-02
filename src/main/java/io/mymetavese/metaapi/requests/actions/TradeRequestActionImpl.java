package io.mymetavese.metaapi.requests.actions;

import io.mymetavese.metaapi.MetaAPIImpl;
import io.mymetavese.metaapi.api.actions.TradeRequestAction;
import io.mymetavese.metaapi.api.entities.GameEntity;
import io.mymetavese.metaapi.api.entities.TradeRequest;
import io.mymetavese.metaapi.requests.JsonObject;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.Route;
import io.mymetavese.metaapi.requests.entities.LiveWalletItemImpl;
import io.mymetavese.metaapi.requests.entities.TradeRequestImpl;
import okhttp3.Response;

import java.util.List;

public class TradeRequestActionImpl extends RestActionImpl<TradeRequest> implements TradeRequestAction {

    private final GameEntity gameEntity;
    private final GameEntity targetGameEntity;
    private final List<LiveWalletItemImpl> itemsToOffer;
    private final List<LiveWalletItemImpl> itemsToAsk;

    public TradeRequestActionImpl(MetaAPIImpl api, GameEntity gameEntity, GameEntity targetGameEntity, List<LiveWalletItemImpl> itemsToOffer, List<LiveWalletItemImpl> itemsToAsk) {
        super(api, Route.LiveWallet.SEND_TRADE_REQUEST);
        this.gameEntity = gameEntity;
        this.targetGameEntity = targetGameEntity;
        this.itemsToOffer = itemsToOffer;
        this.itemsToAsk = itemsToAsk;
    }

    @Override
    protected String compileRoute() {
        return route.compileRoute(targetGameEntity.getPlayerID());
    }

    @Override
    protected JsonObject buildBody() {
        JsonObject body  = JsonObject.JsonObjectBuilder.newBuilder().create();

        body.append("InitiatorUserID", gameEntity.getPlayerID());
        body.append("ReceiverUserID", targetGameEntity.getPlayerID());
        body.append("ItemsToOffer", itemsToOffer);
        body.append("ItemsToAsk", itemsToAsk);

        return body;
    }

    @Override
    public TradeRequest transform(Response response) {
        return new TradeRequestImpl();
    }
}
