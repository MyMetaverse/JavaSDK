package io.mymetavese.metaapi.api.actions.Metadata;

import io.mymetavese.metaapi.api.RestAction;
import io.mymetavese.metaapi.api.entities.Message;
import io.mymetavese.metaapi.api.entities.v2.WalletIndex;

public interface UpdateTokenAction extends RestAction<Message> {

    /**
     * Update the ID of this {@link WalletIndex}.
     * @param id The new ID.
     * @return The Action to continue the editing session.
     */
    UpdateTokenAction updateID(String id);

    /**
     * Update the index of this {@link WalletIndex}
     * @param index The new index.
     * @return The Action to continue the editing session.
     */
    UpdateTokenAction updateIndex(String index);

    /**
     * Update the name for this {@link WalletIndex}
     * @param name The new name.
     * @return The Action to continue the editing session.
     */
    UpdateTokenAction updateName(String name);

    /**
     * Update the description for this {@link WalletIndex}
     * @param description The new description for this token.
     * @return The Action to continue the editing session.
     */
    UpdateTokenAction updateDescription(String description);

    /**
     * Update the URL for the image of this {@link WalletIndex}
     * @param image The URL for a new image for this token.
     * @return The Action to continue the editing session.
     */
    UpdateTokenAction updateTokenImage(String image);

}
