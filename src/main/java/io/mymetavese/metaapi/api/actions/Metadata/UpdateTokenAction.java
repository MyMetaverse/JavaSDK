package io.mymetavese.metaapi.api.actions.Metadata;

import io.mymetavese.metaapi.api.RestAction;
import io.mymetavese.metaapi.api.entities.Message;

public interface UpdateTokenAction extends RestAction<Message> {

    UpdateTokenAction updateID(String id);

    UpdateTokenAction updateIndex(String index);

    UpdateTokenAction updateName(String name);

    UpdateTokenAction updateDescription(String description);

    UpdateTokenAction updateTokenImage(String image);

}
