package io.mymetavese.metaapi.requests.actions;


import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.WalletAction;
import io.mymetavese.metaapi.api.entities.GameEntity;
import io.mymetavese.metaapi.api.entities.PlayerWallet;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.entities.PlayerWalletImpl;
import io.mymetavese.metaapi.requests.routes.Routes;

public class WalletActionImpl extends RestActionImpl<PlayerWallet> implements WalletAction {

    private final String playerID;

    public WalletActionImpl(MetaAPI api, GameEntity gameEntity) {
        super(api, Routes.GET_WALLET, PlayerWalletImpl.class);
        this.playerID = gameEntity.getPlayerID();
    }

    @Override
    protected String compileRoute() {
        return route.compileRoute(playerID);
    }

//    @Override
//    public PlayerWallet transform(Response response) {
//        Gson gson = new Gson();
//        JsonObject jsonElement = gson.fromJson(Objects.requireNonNull(response.body()).charStream(), JsonObject.class);
//        EntityBuilder entityBuilder = new EntityBuilder(this.getMetaAPI());
//        return entityBuilder.createPlayerWallet(jsonElement.getAsJsonObject());
//    }
}
