package io.mymetavese.metaapi.api.entities;

import java.util.List;

public interface TradeRequest {

    /**
     * A string of the player who started this Trade
     * @return A string of the id of the initiator player.
     */
    String getInitiatorPlayerID();

    /**
     * Returns the ID of the player who will receive the items of this trade request.
     * @return A string of the id of the receiver player.
     */
    String getReceiverPlayerID();

    /**
     * Return a list of {@link LiveWalletItem}s that are offered by the initiator player.
     * @return A list filled with LiveWalletItems that are offered in the trade.
     */
    List<? extends LiveWalletItem> getItemsToOffer();

    /**
     * Return a list of {@link LiveWalletItem}s that are asked by the initiator player.
     * @return A list filled with LiveWalletItems that are asked in the trade.
     */
    List<? extends LiveWalletItem> getItemsToAsk();

}
