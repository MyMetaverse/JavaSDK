package io.mymetavese.metaapi.api.actions.Metadata;

import io.mymetavese.metaapi.api.RestAction;
import io.mymetavese.metaapi.api.entities.Message;

public interface UpdateTokenAction extends RestAction<Message> {

    /**
     * Update the ID of this {@link io.mymetavese.metaapi.api.entities.Token}.
     * @param id The new ID.
     * @return The Action to continue the editing session.
     */
    UpdateTokenAction updateID(String id);

    /**
     * Update the index of this {@link io.mymetavese.metaapi.api.entities.Token}
     * @param index The new index.
     * @return The Action to continue the editing session.
     */
    UpdateTokenAction updateIndex(String index);

    /**
     * Update the name for this {@link io.mymetavese.metaapi.api.entities.Token}
     * @param name The new name.
     * @return The Action to continue the editing session.
     */
    UpdateTokenAction updateName(String name);

    /**
     * Update the description for this {@link io.mymetavese.metaapi.api.entities.Token}
     * @param description The new description for this token.
     * @return The Action to continue the editing session.
     */
    UpdateTokenAction updateDescription(String description);

    /**
     * Update the URL for the image of this {@link io.mymetavese.metaapi.api.entities.Token}
     * @param image The URL for a new image for this token.
     * @return The Action to continue the editing session.
     */
    UpdateTokenAction updateTokenImage(String image);

}
