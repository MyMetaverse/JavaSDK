package io.mymetavese.metaapi.requests.entities;

import com.google.gson.annotations.SerializedName;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.entities.LiveWalletItem;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class LiveWalletItemImpl implements LiveWalletItem {

    @Getter
    private final MetaAPI metaAPI;

    @Getter
    private final String tokenId;

    @Getter
    @SerializedName("tokenIndexesList")
    private final List<ItemIndex> tokenIndexes;

    @Getter
    @SerializedName("nft")
    private final boolean NFT;

    @Getter
    private final int amount;

    @Getter
    @SerializedName("itemuri")
    private final String itemURI;


    @Override
    public String toString() {
        return "LiveWalletItemImpl{" +
                "tokenId='" + tokenId + '\'' +
                ", tokenIndexes=" + tokenIndexes +
                ", NFT=" + NFT +
                ", amount=" + amount +
                '}';
    }
}
