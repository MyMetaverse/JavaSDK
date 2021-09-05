package io.mymetavese.metaapi.requests.entities;

import io.mymetavese.metaapi.api.entities.PlayerWallet;
import io.mymetavese.metaapi.api.entities.v2.WalletItem;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
public class PlayerWalletImpl implements PlayerWallet {

    private final List<WalletItemImpl> liveWallet;

    private final List<WalletItemImpl> enjinWallet;

    @Override
    public String toString() {
        return "PlayerWalletImpl{" +
                "liveWallet=" + liveWallet +
                ", enjinWallet=" + enjinWallet +
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
