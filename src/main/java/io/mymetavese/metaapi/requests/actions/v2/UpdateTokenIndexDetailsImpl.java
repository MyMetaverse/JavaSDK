package io.mymetavese.metaapi.requests.actions.v2;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.v2.UpdateTokenIndexDetails;
import io.mymetavese.metaapi.api.entities.v2.WalletIndex;
import io.mymetavese.metaapi.api.entities.v2.WalletItem;
import io.mymetavese.metaapi.requests.JsonObject;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.entities.WalletItemImpl;
import io.mymetavese.metaapi.requests.routes.Routes;

public class UpdateTokenIndexDetailsImpl extends RestActionImpl<WalletItem> implements UpdateTokenIndexDetails {

    protected final WalletIndex walletIndex;

    private String name;

    private String description;

    public UpdateTokenIndexDetailsImpl(MetaAPI api, WalletIndex walletIndex) {
        super(api, Routes.UPDATE_TOKEN_INDEX_DETAILS, WalletItemImpl.class);
        this.walletIndex = walletIndex;
    }

    @Override
    protected String compileRoute() {
        return route.compileRoute(walletIndex.getBaseNFT().getTokenId(), walletIndex.getIndex());
    }

    public UpdateTokenIndexDetailsImpl setName(String name) {
        this.name = name;
        return this;
    }

    public UpdateTokenIndexDetailsImpl setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    protected JsonObject buildBody() {
        if(name == null && description == null)
            throw new IllegalArgumentException("Please specify at least name or description");

        JsonObject body  = JsonObject.JsonObjectBuilder.newBuilder().create();

        if(name != null)
            body.append("name", name);

        if(description != null)
            body.append("description", description);

        return body;
    }
}
