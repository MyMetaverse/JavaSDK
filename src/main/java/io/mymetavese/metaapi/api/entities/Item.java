package io.mymetavese.metaapi.api.entities;

import io.mymetavese.metaapi.requests.entities.ItemIndex;

import java.util.List;

public interface Item {

    String getTokenId();

    boolean isNFT();

    List<ItemIndex> getTokenIndexes();

    int getAmount();

}