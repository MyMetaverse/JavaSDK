package io.mymetavese.metaapi.api.entities;

import io.mymetavese.metaapi.api.entities.v2.WalletItem;

import java.util.ArrayList;
import java.util.List;

public interface PlayerWallet {

    /**
     * Retrieve items in Enjin Wallet.
     * <br />
     * Deprecated:
     *
     * @return A representation of the Enjin Wallet owned by this player.
     */
    @Deprecated()
    List<? extends WalletItem> getEnjinWallet();

    /**
     * Retrieve Centralized items.
     * <br />
     * Deprecated: Should be replaced by
     *
     * @return A representation of the Enjin Wallet owned by this player.
     */
    @Deprecated
    List<? extends WalletItem> getMyMetaverseWallet();

    /**
     * Retrieve items from chain
     * <p>
     * Get the player's items in the provided chain.
     *
     * @param chain the chain where the items will be obtained from.
     * @return a list containing the player's items in the chain.
     */
    List<? extends WalletItem> getItemsByChain(String chain);

    /**
     * Retrieve Centralized items.
     * <br />
     * Deprecated: Should be replaced by
     *
     * @return a list containing the player's centralized items.
     */
    List<? extends WalletItem> getCentralizedItems();

    /**
     * Retrieve all items
     * <p>
     * Retrieve all player's items in all chains.
     *
     * @return A list filled with all the {@link Item}s owned by this player.
     */
    List<? extends WalletItem> getAllItems();

}
