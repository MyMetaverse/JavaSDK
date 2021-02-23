package io.mymetavese.metaapi.api.entities;

import io.mymetavese.metaapi.api.actions.GetItemURIAction;

public interface EnjinWalletItem extends Item {

    String getName();

    GetItemURIAction getItemURI();

}
