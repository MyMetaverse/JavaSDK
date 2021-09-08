package io.mymetavese.metaapi.api.actions.v2;

import io.mymetavese.metaapi.api.RestAction;
import io.mymetavese.metaapi.api.entities.v2.WalletIndex;
import io.mymetavese.metaapi.api.entities.v2.WalletItem;
import io.mymetavese.metaapi.requests.actions.v2.UpdateTokenIndexDetailsImpl;

public interface UpdateTokenIndexDetails extends RestAction<WalletItem> {

    /**
     * Update the name of a {@link WalletIndex}.
     * @param name The new name.
     * @return The Action to continue the editing session.
     */
    UpdateTokenIndexDetailsImpl setName(String name);

    /**
     * Update the description of a {@link WalletIndex}.
     * @param description The new description.
     * @return The Action to continue the editing session.
     */
    UpdateTokenIndexDetailsImpl setDescription(String description);

}
