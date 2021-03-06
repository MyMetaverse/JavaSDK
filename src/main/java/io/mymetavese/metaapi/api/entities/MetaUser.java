package io.mymetavese.metaapi.api.entities;

import io.mymetavese.metaapi.api.actions.MyMetaverse.CreateLiveWalletAction;

public interface MetaUser {

    /**
     * Create a new LiveWallet for this MetaUserImpl.
     * @return Action ready to deploy this request.
     */
    CreateLiveWalletAction createLiveWallet();

    /**
     * The ID used to identify this user inside the Metaverse.
     * @return A string with the ID;
     */
    String getMyMetaverseID();



}
