package io.mymetavese.metaapi.api.entities;

import java.util.List;

public interface TradeRequest {

    String getInitiatorPlayerID();

    String getReceiverPlayerID();

    List<? extends LiveWalletItem> getItemsToOffer();

    List<? extends LiveWalletItem> getItemsToAsk();

}
