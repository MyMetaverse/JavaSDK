package io.mymetavese.metaapi.api.entities;

import java.util.List;

public interface EnjinWallet {

    /**
     * The ETH address for this Enjin Wallet.
     * <br />
     * This can return a message saying the wallet is not linked.
     * @return A ETH address.
     */
    String getAddress();

    /**
     * Get all the items included by this EnjinWallet
     * @return A list including all the items owned by this wallet.
     */
    List<? extends EnjinWalletItem> getItems();

    /**
     * This will return if the player already linked his account with Enjin.
     * @return True if the player is linked with any Enjin Wallet.
     */
    default boolean isLinked() {
        return !getAddress().equals("Not Linked");
    }

}
