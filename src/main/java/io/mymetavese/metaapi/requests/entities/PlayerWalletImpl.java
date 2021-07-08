package io.mymetavese.metaapi.requests.entities;

import io.mymetavese.metaapi.api.entities.PlayerWallet;
import io.mymetavese.metaapi.api.entities.WalletItem;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PlayerWalletImpl implements PlayerWallet {

    private final List<WalletItemImpl> liveWallet;

    private final List<WalletItemImpl> enjinWallet;


    @Override
    public String toString() {
        return "PlayerWalletImpl{" +
                "LiveWallet=" + liveWallet +
                ", EnjinWallet=" + enjinWallet +
                '}';
    }

    @Override
    public List<? extends WalletItem> getEnjinWallet() {
        return enjinWallet;
    }

    @Override
    public List<? extends WalletItem> getMyMetaverseWallet() {
        return liveWallet;
    }

}
