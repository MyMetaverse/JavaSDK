package io.mymetavese.metaapi.requests.actions;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.WalletAction;
import io.mymetavese.metaapi.api.entities.GameEntity;
import io.mymetavese.metaapi.api.entities.PlayerWallet;
import io.mymetavese.metaapi.requests.EntityBuilder;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.Route;
import io.mymetavese.metaapi.requests.entities.PlayerWalletImpl;
import okhttp3.Response;

import java.util.Objects;

public class WalletActionImpl extends RestActionImpl<PlayerWallet> implements WalletAction {

    private final String playerID;

    public WalletActionImpl(MetaAPI api, GameEntity gameEntity) {
        super(api, Route.LiveWallet.GET_ITEMS, PlayerWalletImpl.class);
        this.playerID = gameEntity.getPlayerID();
    }

    @Override
    protected String compileRoute() {
        return route.compileRoute(playerID);
    }

    @Override
    public PlayerWallet transform(Response response) {
        Gson gson = new Gson();
        JsonObject jsonElement = gson.fromJson(Objects.requireNonNull(response.body()).charStream(), JsonObject.class);
        EntityBuilder entityBuilder = new EntityBuilder(this.getMetaAPI());
        return entityBuilder.createPlayerWallet(jsonElement.getAsJsonObject());
    }
}
