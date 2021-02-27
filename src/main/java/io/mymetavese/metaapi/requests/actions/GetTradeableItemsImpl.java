package io.mymetavese.metaapi.requests.actions;

import com.google.gson.Gson;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.GetTradeableItems;
import io.mymetavese.metaapi.api.entities.Player;
import io.mymetavese.metaapi.api.entities.TradeableItemsList;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.Route;
import io.mymetavese.metaapi.requests.entities.TradeableItemsListImpl;
import okhttp3.Response;

import java.util.Objects;

public class GetTradeableItemsImpl extends RestActionImpl<TradeableItemsList> implements GetTradeableItems {

    private final Player initiatorPlayer;

    private final Player receiverPlayer;

    public GetTradeableItemsImpl(MetaAPI api, Player initiatorPlayer, Player receiverPlayer) {
        super(api, Route.LiveWallet.GET_TRADEABLE_ITEMS, TradeableItemsListImpl.class);
        this.initiatorPlayer = initiatorPlayer;
        this.receiverPlayer = receiverPlayer;
    }

    @Override
    protected String compileRoute() {
        return route.compileRoute(initiatorPlayer.getPlayerID(), receiverPlayer.getPlayerID());
    }

    @Override
    public TradeableItemsList transform(Response response) {
        if(response == null || response.body() == null) {
            throw new NullPointerException("Response is null.");
        }
        Gson gson = new Gson();

        return gson.fromJson(Objects.requireNonNull(response.body()).charStream(), TradeableItemsListImpl.class);
    }

}
