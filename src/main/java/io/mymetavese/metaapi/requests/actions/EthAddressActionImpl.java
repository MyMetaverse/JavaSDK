package io.mymetavese.metaapi.requests.actions;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import io.mymetavese.metaapi.MetaAPIImpl;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.EthAddressAction;
import io.mymetavese.metaapi.api.entities.Player;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.Route;
import okhttp3.Response;

import java.util.Objects;

public class EthAddressActionImpl extends RestActionImpl<String> implements EthAddressAction {

    private final Player player;

    private String ethAddress = null;

    public EthAddressActionImpl(MetaAPI api, Player player) {
        super(api, Route.LiveWallet.GET_ETH_ADDRESS);
        this.player = player;
    }

    @Override
    protected String compileRoute() {
        return route.compileRoute(player.getPlayerID());
    }

    @Override
    public String transform(Response response) {
        if (response == null || response.body() == null) {
            throw new NullPointerException("Response cannot be null");
        }

        Gson gson = new Gson();
        this.ethAddress =  gson.fromJson(Objects.requireNonNull(response.body()).charStream(), EthAddressWrapper.class).address;
        return this.ethAddress;
    }

    @Override
    public boolean isLinked() {
        return !ethAddress.equals("Not Linked");
    }

    private static class EthAddressWrapper {
        @SerializedName("Address")
        private String address;
    }
}
