package io.mymetavese.metaapi.api.entities;

import java.util.ArrayList;
import java.util.List;

public interface PlayerWallet {

    /**
     * Retrieve the representation of an Enjin Wallet.
     * <br />
     * @return A representation of the Enjin Wallet owned by this player.
     */
    EnjinWallet getEnjinWallet();

    List<? extends LiveWalletItem> getLiveWallet();

    /**
     * Return if the player has already linked his account with any Enjin Wallet.
     * @return Return true if the account is linked to any Enjin Wallet
     */
    default boolean isEnjinLinked() {
        if(getEnjinWallet() == null)
            return false;
        return getEnjinWallet().isLinked();
    }

    /**
     * This will return all the items owned by this player, including {@link EnjinWallet} and all {@link LiveWalletItem}
     * @return A list filled with the {@link Item}s owned by this player.
     */
    default List<Item> getAllItems() {
        List<Item> items = new ArrayList<>(getLiveWallet());
        items.addAll(getEnjinWallet().getItems());

        return items;
    }

}
