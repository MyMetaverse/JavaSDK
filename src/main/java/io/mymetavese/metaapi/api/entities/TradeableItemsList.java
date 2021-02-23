package io.mymetavese.metaapi.api.entities;

import java.util.List;

public interface TradeableItemsList {

    List<? extends LiveWalletItem> getInitiatorItems();

    List<? extends LiveWalletItem> getReceiverItems();

}
