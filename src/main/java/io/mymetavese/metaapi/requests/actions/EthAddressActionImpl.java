package io.mymetavese.metaapi.requests.actions;

import com.google.gson.Gson;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.EthAddressAction;
import io.mymetavese.metaapi.api.entities.v2.GameEntity;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.routes.Routes;
import okhttp3.Response;

import java.util.Objects;

public class EthAddressActionImpl extends RestActionImpl<String> implements EthAddressAction {

    private final GameEntity gameEntity;

    private String ethAddress = null;

    public EthAddressActionImpl(MetaAPI api, GameEntity gameEntity) {
        super(api, Routes.GET_ETH_ADDRESS);
        this.gameEntity = gameEntity;
    }

    @Override
    protected String compileRoute() {
        return route.compileRoute(gameEntity.getPlayerID());
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
        private String address;
    }
}
