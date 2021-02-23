package io.mymetavese.metaapi.api.entities;

import io.mymetavese.metaapi.api.actions.GetItemURIAction;

import java.util.List;

public interface Item {

    String getTokenId();

    boolean isNFT();

    List<String> getTokenIndexes();

    int getAmount();

    GetItemURIAction getItemURI();

}