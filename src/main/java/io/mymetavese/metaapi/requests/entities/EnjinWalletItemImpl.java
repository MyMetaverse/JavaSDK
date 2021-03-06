package io.mymetavese.metaapi.requests.entities;

import com.google.gson.annotations.SerializedName;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.entities.EnjinWalletItem;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
public class EnjinWalletItemImpl implements EnjinWalletItem  {

    @Getter
    private final MetaAPI metaAPI;

    @Getter
    private final String tokenId;

    @Getter
    private final List<ItemIndex> tokenIndexes;

    @Getter
    private final boolean NFT;

    @Getter
    private final int amount;

    @Getter
    private final String name;

    @Getter
    @SerializedName("ItemURI")
    private final String itemURI;

    @Override
    public String toString() {
        return "EnjinWalletItemImpl{" +
                "tokenId='" + tokenId + '\'' +
                ", tokenIndexes=" + tokenIndexes +
                ", NFT=" + NFT +
                ", amount=" + amount +
                ", name='" + name + '\'' +
                ", itemURI='" + itemURI + '\'' +
                '}';
    }
}
