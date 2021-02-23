package io.mymetavese.metaapi.requests.entities;

import com.google.gson.annotations.SerializedName;
import io.mymetavese.metaapi.api.actions.GetItemURIAction;
import io.mymetavese.metaapi.api.entities.EnjinWalletItem;
import lombok.Getter;

import java.util.List;

public class EnjinWalletItemImpl implements EnjinWalletItem {

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
    private List<Object> locked;

    @Getter
    private String name;

    @Getter
    private GetItemURIAction itemURI;

    @Override
    public String toString() {
        return "EnjinWalletItemImpl{" +
                "tokenId='" + tokenId + '\'' +
                ", tokenIndexes=" + tokenIndexes +
                ", NFT=" + NFT +
                ", amount=" + amount +
                ", locked=" + locked +
                ", name='" + name + '\'' +
                ", itemURI='" + itemURI + '\'' +
                '}';
    }
}
