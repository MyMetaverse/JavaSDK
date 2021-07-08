package io.mymetavese.metaapi.requests.entities;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.entities.EnjinWallet;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class EnjinWalletImpl implements EnjinWallet {

    @Getter
    private final MetaAPI metaAPI;

    @Getter
    private final String address;

    @Getter
    private final List<LiveWalletItemImpl> items;

    @Override
    public String toString() {
        return "EnjinWalletImpl{" +
                "address='" + address + '\'' +
                ", items=" + items +
                '}';
    }
}
