package io.mymetavese.metaapi.requests.actions.v2;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.v2.DeleteTokenIndexProperty;
import io.mymetavese.metaapi.api.entities.v2.IndexProperty;
import io.mymetavese.metaapi.api.entities.v2.WalletIndex;
import io.mymetavese.metaapi.requests.routes.Routes;

public class DeleteTokenIndexPropertyImpl extends TokenIndexAbstractImpl implements DeleteTokenIndexProperty {

    public DeleteTokenIndexPropertyImpl(MetaAPI api, WalletIndex walletIndex, String property, boolean hidden) {
        super(api, Routes.DELETE_TOKEN_INDEX_PROPERTY, walletIndex, property, hidden);
    }

    public DeleteTokenIndexPropertyImpl(MetaAPI api, WalletIndex walletIndex, IndexProperty property) {
        this(api, walletIndex, property.getName(), property.isHidden());
    }

}
