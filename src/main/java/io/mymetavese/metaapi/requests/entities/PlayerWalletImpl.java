package io.mymetavese.metaapi.requests.entities;

import com.google.gson.annotations.JsonAdapter;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.entities.LiveWalletItem;
import io.mymetavese.metaapi.api.entities.PlayerWallet;
import io.mymetavese.metaapi.requests.ApiImplementation;
import io.mymetavese.metaapi.requests.CustomDeserializers.LiveWalletDeserializer;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class PlayerWalletImpl implements PlayerWallet, ApiImplementation {

    @Getter @Setter
    private MetaAPI metaAPI;

    @JsonAdapter(LiveWalletDeserializer.class)
    private List<LiveWalletItemImpl> LiveWallet;

    private EnjinWalletImpl EnjinWallet;

    @Override
    public io.mymetavese.metaapi.api.entities.EnjinWallet getEnjinWallet() {
        return EnjinWallet;
    }

    @Override
    public List<? extends LiveWalletItem> getLiveWallet() {
        return LiveWallet;
    }

    @Override
    public String toString() {
        return "PlayerWalletImpl{" +
                "LiveWallet=" + LiveWallet +
                ", EnjinWallet=" + EnjinWallet +
                '}';
    }
}
