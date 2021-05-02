package io.mymetavese.metaapi.requests.actions.Metadata;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.Metadata.UpdateTokenAction;
import io.mymetavese.metaapi.api.entities.Message;
import io.mymetavese.metaapi.requests.JsonObject;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.Route;
import io.mymetavese.metaapi.requests.entities.MessageImpl;

public class UpdateTokenActionImpl extends RestActionImpl<Message> implements UpdateTokenAction {

    public UpdateTokenActionImpl(MetaAPI api) {
        super(api, Route.MetaData.EDIT_TOKEN, MessageImpl.class);
        createRequestBody();
    }

    @Override
    protected JsonObject buildBody() {
        return requestBody;
    }

    @Override
    public UpdateTokenAction updateID(String id) {
        if(id != null)
            requestBody.append("id", id);
        return this;
    }

    @Override
    public UpdateTokenAction updateIndex(String index) {
        if(index != null)
            requestBody.append("index", index);
        return this;
    }

    @Override
    public UpdateTokenAction updateName(String name) {
        if(name != null)
            requestBody.append("TokenName", name);
        return this;
    }

    @Override
    public UpdateTokenAction updateDescription(String description) {
        if(description != null)
            requestBody.append("TokenDescription", description);
        return this;
    }

    @Override
    public UpdateTokenAction updateTokenImage(String image) {
        if(image != null)
            requestBody.append("TokenImage", image);
        return this;
    }
}
