package io.mymetavese.metaapi.requests.actions;


import com.google.gson.Gson;
import io.mymetavese.metaapi.MetaAPI;
import io.mymetavese.metaapi.api.actions.WalletAction;
import io.mymetavese.metaapi.api.entities.PlayerWallet;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.Route;
import io.mymetavese.metaapi.requests.entities.PlayerWalletImpl;
import lombok.SneakyThrows;
import okhttp3.Response;

import java.util.Objects;

public class WalletActionImpl extends RestActionImpl<PlayerWallet> implements WalletAction {

    private String playerID;

    public WalletActionImpl(MetaAPI api) {
        super(api, Route.LiveWallet.GET_ITEMS);
    }

    @Override
    protected String compileRoute() {
        return route.compileRoute(playerID);
    }

    @SneakyThrows
    @Override
    public PlayerWallet transform(Response response) {
        if(response == null || response.body() == null) {
            throw new NullPointerException("Response is null.");
        }

        Gson gson = new Gson();
        return gson.fromJson(Objects.requireNonNull(response.body()).charStream(), PlayerWalletImpl.class);
    }

    @Override
    public WalletAction playerToken(String playerID) {
        this.playerID = playerID;
        return this;
    }

}
