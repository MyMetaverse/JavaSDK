package io.mymetavese.metaapi.requests.actions;

import io.mymetavese.metaapi.MetaAPI;
import io.mymetavese.metaapi.api.actions.TradeRequestAction;
import io.mymetavese.metaapi.api.entities.Player;
import io.mymetavese.metaapi.api.entities.TradeRequest;
import io.mymetavese.metaapi.requests.JsonObject;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.Route;
import io.mymetavese.metaapi.requests.entities.LiveWalletItemImpl;
import io.mymetavese.metaapi.requests.entities.TradeRequestImpl;
import okhttp3.Response;

import java.util.List;

public class TradeRequestActionImpl extends RestActionImpl<TradeRequest> implements TradeRequestAction {

    private final Player player;
    private final Player targetPlayer;
    private final List<LiveWalletItemImpl> itemsToOffer;
    private final List<LiveWalletItemImpl> itemsToAsk;

    public TradeRequestActionImpl(MetaAPI api, Player player, Player targetPlayer, List<LiveWalletItemImpl> itemsToOffer, List<LiveWalletItemImpl> itemsToAsk) {
        super(api, Route.LiveWallet.SEND_TRADE_REQUEST);
        this.player = player;
        this.targetPlayer = targetPlayer;
        this.itemsToOffer = itemsToOffer;
        this.itemsToAsk = itemsToAsk;
    }

    @Override
    protected String compileRoute() {
        return route.compileRoute(targetPlayer.getPlayerID());
    }

    @Override
    protected JsonObject buildBody(JsonObject body) {
        body.append("InitiatorPlayerID", player.getPlayerID());
        body.append("ReceiverPlayerID", targetPlayer.getPlayerID());
        body.append("ItemsToOffer", itemsToOffer);
        body.append("ItemsToAsk", itemsToAsk);

        return body;
    }

    @Override
    public TradeRequest transform(Response response) {
        return new TradeRequestImpl();
    }
}
