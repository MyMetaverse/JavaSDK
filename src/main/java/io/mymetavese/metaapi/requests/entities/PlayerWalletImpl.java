package io.mymetavese.metaapi.requests.entities;

import io.mymetavese.metaapi.api.entities.LiveWalletItem;
import io.mymetavese.metaapi.api.entities.PlayerWallet;

import java.util.List;

public class PlayerWalletImpl implements PlayerWallet {

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
