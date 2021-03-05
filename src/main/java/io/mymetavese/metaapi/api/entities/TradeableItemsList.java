package io.mymetavese.metaapi.api.entities;

import java.util.List;

public interface TradeableItemsList {

    /**
     * Items that are tradeable by the initiator of the trade.
     * @return A List filled with {@link LiveWalletItem}s
     */
    List<? extends LiveWalletItem> getInitiatorItems();

    /**
     * Items that are tradeable by the receiver of the trade.
     * @return A List filled with {@link LiveWalletItem}s
     */
    List<? extends LiveWalletItem> getReceiverItems();

}
