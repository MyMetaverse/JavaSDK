package io.mymetavese.metaapi.requests.entities;

import com.google.gson.annotations.JsonAdapter;
import io.mymetavese.metaapi.api.entities.LiveWalletItem;
import io.mymetavese.metaapi.api.entities.PlayerWallet;
import io.mymetavese.metaapi.requests.CustomDeserializers.LiveWalletDeserializer;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PlayerWalletImpl implements PlayerWallet {

    @JsonAdapter(LiveWalletDeserializer.class)
    private final List<LiveWalletItemImpl> LiveWallet;

    private final EnjinWalletImpl EnjinWallet;

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
