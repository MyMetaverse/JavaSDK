package io.mymetavese.metaapi.requests.entities;

import com.google.gson.annotations.SerializedName;
import io.mymetavese.metaapi.api.entities.LiveWalletItem;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class LiveWalletItemImpl implements LiveWalletItem {

    @Getter
    @SerializedName("token_id")
    private final String tokenId;

    @Getter
    @SerializedName("token_indexes")
    private final List<String> tokenIndexes;

    @Getter
    private final boolean NFT;

    @Getter
    private final int amount;

    @Getter
    private final Object locked;

    @Override
    public String toString() {
        return "LiveWalletItemImpl{" +
                "tokenId='" + tokenId + '\'' +
                ", tokenIndexes=" + tokenIndexes +
                ", NFT=" + NFT +
                ", amount=" + amount +
                ", locked=" + locked +
                '}';
    }
}
