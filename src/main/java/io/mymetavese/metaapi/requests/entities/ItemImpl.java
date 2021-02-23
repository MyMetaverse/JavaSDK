package io.mymetavese.metaapi.requests.entities;

import io.mymetavese.metaapi.API;
import io.mymetavese.metaapi.EnjinXAPI;
import io.mymetavese.metaapi.MetaAPI;
import io.mymetavese.metaapi.api.actions.GetItemURIAction;
import io.mymetavese.metaapi.api.entities.Item;
import io.mymetavese.metaapi.api.entities.ItemMetadata;
import io.mymetavese.metaapi.api.entities.ItemURI;
import io.mymetavese.metaapi.requests.Route;
import io.mymetavese.metaapi.requests.actions.GetItemURIActionImpl;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

public class ItemImpl implements Item {

    private final API api;

    @Getter
    private String tokenId;

    @Getter
    private boolean isNFT;

    @Getter
    private List<String> tokenIndexes;

    @Getter
    private int amount;

    public ItemImpl(API api, String tokenId, boolean isNFT, List<String> tokenIndexes, int amount) {
        this.api = api;
        this.tokenId = tokenId;
        this.isNFT = isNFT;
        this.tokenIndexes = tokenIndexes;
        this.amount = amount;
    }

    public ItemImpl(API api, String tokenId, String tokenIndex) {
        this(api, tokenId, false, Collections.singletonList(tokenIndex), 0);
    }

    @Override
    public GetItemURIAction getItemURI() {
        return new GetItemURIActionImpl(api, this);
    }

    @Override
    public String toString() {
        return "ItemImpl{" +
                "tokenId='" + tokenId + '\'' +
                ", isNFT=" + isNFT +
                ", tokenIndexes=" + tokenIndexes +
                ", amount=" + amount +
                '}';
    }
}
