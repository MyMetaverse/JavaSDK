package io.mymetavese.metaapi.api.entities.v2;

import io.mymetavese.metaapi.api.entities.LiveWalletItem;

import java.util.List;

public interface TransferableItemsList {

    /**
     * Items that are tradeable by the initiator of the trade.
     * @return A List filled with {@link LiveWalletItem}s
     */
    List<? extends WalletItem> getInitiatorWallet();

    /**
     * Items that are tradeable by the receiver of the trade.
     * @return A List filled with {@link LiveWalletItem}s
     */
    List<? extends WalletItem> getReceiverWallet();

}
