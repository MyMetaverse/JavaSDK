package io.mymetavese.metaapi.requests.entities;

import com.google.gson.annotations.SerializedName;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.entities.TradeableItemsList;
import io.mymetavese.metaapi.requests.ApiImplementation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
public class TradeableItemsListImpl implements TradeableItemsList, ApiImplementation {

    @Getter @Setter
    private MetaAPI metaAPI;

    @Getter
    @SerializedName("Initiator")
    private final List<LiveWalletItemImpl> initiatorItems;

    @Getter
    @SerializedName("Receiver")
    private final List<LiveWalletItemImpl> receiverItems;

    @Override
    public String toString() {
        return "TradeableItemsListImpl{" +
                "initiatorItems=" + initiatorItems +
                ", receiverItems=" + receiverItems +
                '}';
    }
}
