package io.mymetavese.metaapi.requests.entities;

import com.google.gson.annotations.SerializedName;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.entities.WalletItem;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class WalletItemImpl implements WalletItem {

    @Getter
    private final MetaAPI metaAPI;

    @Getter
    private final String name;

    @Getter
    private final String tokenId;

    @Getter
    @SerializedName("tokenIndexesList")
    private final List<String> tokenIndexes;

    @Getter
    @SerializedName("nft")
    private final boolean NFT;

    @Getter
    private final int amount;

    @Getter
    @SerializedName("itemuri")
    private final String metadata;

    @Override
    public String toString() {
        return "WalletItemImpl{" +
                "metaAPI=" + metaAPI +
                ", name='" + name + '\'' +
                ", tokenId='" + tokenId + '\'' +
                ", tokenIndexes=" + tokenIndexes +
                ", NFT=" + NFT +
                ", amount=" + amount +
                ", metadata='" + metadata + '\'' +
                '}';
    }
}
