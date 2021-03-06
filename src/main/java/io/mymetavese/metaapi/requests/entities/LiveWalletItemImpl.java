package io.mymetavese.metaapi.requests.entities;

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
