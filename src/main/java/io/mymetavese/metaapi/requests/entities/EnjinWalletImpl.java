package io.mymetavese.metaapi.requests.entities;

import io.mymetavese.metaapi.api.entities.EnjinWallet;
import lombok.Getter;

import java.util.List;

public class EnjinWalletImpl implements EnjinWallet {

    @Getter
    private String address;

    @Getter
    private List<EnjinWalletItemImpl> items;

    @Override
    public String toString() {
        return "EnjinWalletImpl{" +
                "address='" + address + '\'' +
                ", items=" + items +
                '}';
    }
}
