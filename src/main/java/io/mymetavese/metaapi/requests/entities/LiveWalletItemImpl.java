package io.mymetavese.metaapi.requests.entities;

import com.google.gson.annotations.SerializedName;
import io.mymetavese.metaapi.api.entities.LiveWalletItem;
import lombok.Getter;

import java.util.List;

public class LiveWalletItemImpl implements LiveWalletItem {

    @Getter
    @SerializedName("token_id")
    private String tokenId;

    @Getter
    @SerializedName("token_indexes")
    private List<String> tokenIndexes;

    @Getter
    private boolean NFT;

    @Getter
    private int amount;

    @Getter
    private Object locked;

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
