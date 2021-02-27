package io.mymetavese.metaapi.requests.entities;

import com.google.gson.annotations.JsonAdapter;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.entities.EnjinWallet;
import io.mymetavese.metaapi.requests.ApiImplementation;
import io.mymetavese.metaapi.requests.CustomDeserializers.EnjinWalletDeserializer;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class EnjinWalletImpl implements EnjinWallet, ApiImplementation {

    @Getter @Setter
    private MetaAPI metaAPI;

    @Getter
    private String address;

    @Getter
    @JsonAdapter(EnjinWalletDeserializer.class)
    private List<EnjinWalletItemImpl> items;

    @Override
    public String toString() {
        return "EnjinWalletImpl{" +
                "address='" + address + '\'' +
                ", items=" + items +
                '}';
    }
}
