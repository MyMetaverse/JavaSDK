package io.mymetavese.metaapi.requests.actions;


import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.WalletAction;
import io.mymetavese.metaapi.api.entities.Player;
import io.mymetavese.metaapi.api.entities.PlayerWallet;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.Route;
import io.mymetavese.metaapi.requests.entities.PlayerWalletImpl;

public class WalletActionImpl extends RestActionImpl<PlayerWallet> implements WalletAction {

    private final String playerID;

    public WalletActionImpl(MetaAPI api, Player player) {
        super(api, Route.LiveWallet.GET_ITEMS, PlayerWalletImpl.class);
        this.playerID = player.getPlayerID();
    }

    @Override
    protected String compileRoute() {
        return route.compileRoute(playerID);
    }

}
