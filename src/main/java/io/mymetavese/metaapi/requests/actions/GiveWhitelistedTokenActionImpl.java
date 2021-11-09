package io.mymetavese.metaapi.requests.actions;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.GiveWhitelistedTokenAction;
import io.mymetavese.metaapi.api.entities.v2.GameEntity;
import io.mymetavese.metaapi.api.entities.v2.WalletIndex;
import io.mymetavese.metaapi.requests.JsonObject;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.routes.Routes;
import okhttp3.Response;

public class GiveWhitelistedTokenActionImpl extends RestActionImpl<Boolean> implements GiveWhitelistedTokenAction {

    private final WalletIndex walletIndex;
    private final GameEntity receiverEntity;

    public GiveWhitelistedTokenActionImpl(MetaAPI api, WalletIndex walletIndex, GameEntity receiverEntity) {
        super(api, Routes.GIVE_WHITELISTED_TOKEN);
        this.walletIndex = walletIndex;
        this.receiverEntity = receiverEntity;
    }

    @Override
    protected String compileRoute() {
        return route.compileRoute(walletIndex.getBaseNFT().getTokenId());
    }

    @Override
    protected JsonObject buildBody() {

        JsonObject body  = JsonObject.JsonObjectBuilder.newBuilder().create();

        body.append("to", receiverEntity.getPlayerID());
        body.append("tokenIndex", walletIndex.getIndex());

        return body;

    }

    @Override
    public Boolean transform(Response response) {

        if (response == null || response.body() == null)
            throw new NullPointerException("Response cannot be null");
        return response.code() == 200;

    }

}
