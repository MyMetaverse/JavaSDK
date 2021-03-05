package io.mymetavese.metaapi.api.entities;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.Metadata.UpdateTokenAchievementsAction;
import io.mymetavese.metaapi.api.actions.Metadata.UpdateTokenAction;

public interface Token {

    /**
     * Representation of the MetaAPI
     * @return The MetaAPI principal object.
     */
    MetaAPI getMetaAPI();

    /**
     * The ID in the blockchain for this Token.
     * @return A String with the ID.
     */
    String getID();

    /**
     * The index of this token.
     * @return A String with the index.
     */
    String getIndex();

    /**
     * Return a builder to fill with edited achievements for this token.
     * @return The builder to edit this token.
     */
    UpdateTokenAchievementsAction createTokenAchievementsEditor();

    /**
     * Return a builder to fill with editable properties for this token.
     * @return A editor to edit this token.
     */
    UpdateTokenAction createTokenEditor();

}
