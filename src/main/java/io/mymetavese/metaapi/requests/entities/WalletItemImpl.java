package io.mymetavese.metaapi.requests.entities;

import com.google.gson.annotations.SerializedName;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.entities.v2.WalletIndex;
import io.mymetavese.metaapi.api.entities.v2.WalletItem;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
@Data
public class WalletItemImpl implements WalletItem {

    @Getter
    private final MetaAPI metaAPI;

    @Getter
    private final String name;

    @Getter
    private final String tokenId;

    @Getter
    @SerializedName("indices")
    private final Set<String> tokenIndexes;

    @Getter
    @SerializedName("nft")
    private final boolean NFT;

    @Getter
    private final int amount;

    @Getter
    @SerializedName("itemURI")
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

    @Override
    public WalletIndex getIndex(String index) {
        if(!NFT)
            throw new IllegalArgumentException("This method is only usable in Non-Fungible Tokens.");

        if(!tokenIndexes.contains(index))
            throw new NullPointerException("This wallet doesn't contain index " + index);

        return new WalletIndexImpl(
                metaAPI,
                index,
                this);
    }

}
