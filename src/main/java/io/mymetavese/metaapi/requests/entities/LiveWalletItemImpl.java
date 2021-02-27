package io.mymetavese.metaapi.requests.entities;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.entities.LiveWalletItem;
import io.mymetavese.metaapi.requests.ApiImplementation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
public class LiveWalletItemImpl implements LiveWalletItem, ApiImplementation {

    @Getter @Setter
    private MetaAPI metaAPI;

    @Getter
    private final String tokenId;

    @Getter
    private final List<ItemIndex> tokenIndexes;

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
