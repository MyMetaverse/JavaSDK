package io.mymetavese.metaapi.requests.entities;

import com.google.gson.annotations.SerializedName;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.MyMetaverse.CreateLiveWalletAction;
import io.mymetavese.metaapi.api.entities.MetaUser;
import io.mymetavese.metaapi.requests.actions.MyMetaverse.CreateLiveWalletActionImpl;
import lombok.Getter;

public class MetaUserImpl implements MetaUser {

    @Getter
    private final MetaAPI metaAPI;

    @SerializedName("MyMetaverseID")
    @Getter
    private final String myMetaverseID;

    public MetaUserImpl(MetaAPI metaAPI, String myMetaverseID) {
        this.metaAPI = metaAPI;
        this.myMetaverseID = myMetaverseID;
    }

    @Override
    public CreateLiveWalletAction createLiveWallet() {
        return new CreateLiveWalletActionImpl(metaAPI, this);
    }

}
