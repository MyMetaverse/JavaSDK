package io.mymetavese.metaapi.requests.actions.MyMetaverse;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.MyMetaverse.CreateLiveWalletAction;
import io.mymetavese.metaapi.api.entities.MetaUser;
import io.mymetavese.metaapi.api.entities.MyMetaverse.LinkingCode;
import io.mymetavese.metaapi.requests.JsonObject;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.Route;
import io.mymetavese.metaapi.requests.entities.MyMetaverse.LinkingCodeImpl;

public class CreateLiveWalletActionImpl extends RestActionImpl<LinkingCode> implements CreateLiveWalletAction {

    private final MetaUser metaUser;

    public CreateLiveWalletActionImpl(MetaAPI api, MetaUser metaUser) {
        super(api, Route.MyMetaverse.CREATE_LIVEWALLET, LinkingCodeImpl.class);
        this.metaUser = metaUser;
    }

    @Override
    protected JsonObject buildBody() {
        JsonObject body = JsonObject.JsonObjectBuilder.newBuilder().create();
        body.append("MyMetaverseID", metaUser);
        return body;
    }
}
