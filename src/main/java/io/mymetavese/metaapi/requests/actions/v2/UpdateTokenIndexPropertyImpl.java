package io.mymetavese.metaapi.requests.actions.v2;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.v2.UpdateTokenIndexProperty;
import io.mymetavese.metaapi.api.entities.v2.IndexProperty;
import io.mymetavese.metaapi.api.entities.v2.WalletIndex;
import io.mymetavese.metaapi.requests.JsonObject;
import io.mymetavese.metaapi.requests.routes.Routes;

public class UpdateTokenIndexPropertyImpl extends TokenIndexAbstractImpl implements UpdateTokenIndexProperty {

    private final Object value;

    public UpdateTokenIndexPropertyImpl(MetaAPI api, WalletIndex walletIndex, String property, boolean hidden, Object value) {
        super(api, Routes.UPDATE_TOKEN_INDEX_PROPERTY, walletIndex, property, hidden);
        this.value = value;
    }

    public UpdateTokenIndexPropertyImpl(MetaAPI api, WalletIndex walletIndex, IndexProperty property, Object value) {
        this(api, walletIndex, property.getName(), property.isHidden(), value);
    }

    @Override
    protected JsonObject buildBody() {
        JsonObject body = super.buildBody();

        body.append("content", value);

        return body;
    }
}
