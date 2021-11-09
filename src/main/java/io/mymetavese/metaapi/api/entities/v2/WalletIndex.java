package io.mymetavese.metaapi.api.entities.v2;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.GiveWhitelistedTokenAction;
import io.mymetavese.metaapi.api.actions.Metadata.FetchTokenAction;
import io.mymetavese.metaapi.api.actions.v2.DeleteTokenIndexProperty;
import io.mymetavese.metaapi.api.actions.v2.UpdateTokenIndexDetails;
import io.mymetavese.metaapi.api.actions.v2.UpdateTokenIndexProperty;

import java.util.Map;

public interface WalletIndex {

    /**
     * Representation of the MetaAPI
     * @return The MetaAPI principal object.
     */
    MetaAPI getMetaAPI();

    /**
     * The ID in the blockchain for this WalletIndex.
     * @return A String with the ID.
     */
    WalletItem getBaseNFT();

    /**
     * The index of this token.
     * @return A String with the index.
     */
    String getIndex();

    Map<String, IndexProperty> getProperties();

    Map<String, IndexProperty> getPrivateProperties();

    UpdateTokenIndexProperty updateProperty(String property, boolean hidden, Object value);

    DeleteTokenIndexProperty deleteProperty(String property, boolean hidden);

    UpdateTokenIndexDetails updateDetails();

    FetchTokenAction fill();

    GiveWhitelistedTokenAction give(GameEntity receiverEntity);

}
