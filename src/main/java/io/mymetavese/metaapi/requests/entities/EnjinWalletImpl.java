package io.mymetavese.metaapi.requests.entities;

import com.google.gson.annotations.JsonAdapter;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.entities.EnjinWallet;
import io.mymetavese.metaapi.requests.CustomDeserializers.EnjinWalletDeserializer;
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
    @JsonAdapter(EnjinWalletDeserializer.class)
    private final List<EnjinWalletItemImpl> items;

    @Override
    public String toString() {
        return "EnjinWalletImpl{" +
                "address='" + address + '\'' +
                ", items=" + items +
                '}';
    }
}
