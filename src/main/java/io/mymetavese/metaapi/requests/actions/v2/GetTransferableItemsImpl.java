package io.mymetavese.metaapi.requests.actions.v2;

import com.google.gson.Gson;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.v2.GetTransferableItems;
import io.mymetavese.metaapi.api.entities.v2.GameEntity;
import io.mymetavese.metaapi.api.entities.v2.TransferableItemsList;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.entities.TransferableItemsListImpl;
import okhttp3.Response;

import java.util.Objects;

public class GetTransferableItemsImpl extends RestActionImpl<TransferableItemsList> implements GetTransferableItems {

    private final GameEntity initiatorGameEntity;

    private final GameEntity receiverGameEntity;

    public GetTransferableItemsImpl(MetaAPI api, GameEntity initiatorGameEntity, GameEntity receiverGameEntity) {
        super(api, null, TransferableItemsListImpl.class);
        this.initiatorGameEntity = initiatorGameEntity;
        this.receiverGameEntity = receiverGameEntity;
    }

    @Override
    protected String compileRoute() {
        return route.compileRoute(initiatorGameEntity.getPlayerID(), receiverGameEntity.getPlayerID());
    }

    @Override
    public TransferableItemsList transform(Response response) {
        if(response == null || response.body() == null) {
            throw new NullPointerException("Response is null.");
        }
        Gson gson = new Gson();

        return gson.fromJson(Objects.requireNonNull(response.body()).charStream(), TransferableItemsListImpl.class);
    }

}
