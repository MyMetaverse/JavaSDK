package io.mymetavese.metaapi.requests.actions.v2;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.entities.v2.WalletIndex;
import io.mymetavese.metaapi.api.entities.v2.WalletItem;
import io.mymetavese.metaapi.requests.JsonObject;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.entities.WalletItemImpl;
import io.mymetavese.metaapi.requests.routes.Routes;

public abstract class TokenIndexAbstractImpl extends RestActionImpl<WalletItem> {

    protected final WalletIndex walletIndex;

    private final String property;

    private final boolean hidden;

    public TokenIndexAbstractImpl(MetaAPI api, Routes route, WalletIndex walletIndex, String property, boolean hidden) {
        super(api, route, WalletItemImpl.class);
        this.walletIndex = walletIndex;
        this.property = property;
        this.hidden = hidden;
    }

    @Override
    protected String compileRoute() {
        return route.compileRoute(walletIndex.getBaseNFT().getTokenId(), walletIndex.getIndex(), property);
    }

    @Override
    protected JsonObject buildBody() {
        JsonObject body  = JsonObject.JsonObjectBuilder.newBuilder().create();

        body.append("hiddenProperty", hidden);
        return body;
    }
}
