package io.mymetavese.metaapi.requests.actions;

import com.google.gson.Gson;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.GetTradeableItems;
import io.mymetavese.metaapi.api.entities.GameEntity;
import io.mymetavese.metaapi.api.entities.TradeableItemsList;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.entities.TradeableItemsListImpl;
import okhttp3.Response;

import java.util.Objects;

public class GetTradeableItemsImpl extends RestActionImpl<TradeableItemsList> implements GetTradeableItems {

    private final GameEntity initiatorGameEntity;

    private final GameEntity receiverGameEntity;

    public GetTradeableItemsImpl(MetaAPI api, GameEntity initiatorGameEntity, GameEntity receiverGameEntity) {
        super(api, null, TradeableItemsListImpl.class);
        this.initiatorGameEntity = initiatorGameEntity;
        this.receiverGameEntity = receiverGameEntity;
    }

    @Override
    protected String compileRoute() {
        return route.compileRoute(initiatorGameEntity.getPlayerID(), receiverGameEntity.getPlayerID());
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
