package io.mymetavese.metaapi.api.entities;

import java.util.List;

public interface Item {

    String getTokenId();

    boolean isNFT();

    List<String> getTokenIndexes();

    int getAmount();

}