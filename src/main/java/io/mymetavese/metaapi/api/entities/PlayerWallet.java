package io.mymetavese.metaapi.api.entities;

import io.mymetavese.metaapi.api.entities.v2.WalletItem;

import java.util.ArrayList;
import java.util.List;

public interface PlayerWallet {

    /**
     * Retrieve the representation of an Enjin Wallet.
     * <br />
     *
     * @return A representation of the Enjin Wallet owned by this player.
     */
    List<? extends WalletItem> getEnjinWallet();

    List<? extends WalletItem> getMyMetaverseWallet();

    /**
     * This will return all the items owned by this player, including {@link EnjinWallet} and all {@link LiveWalletItem}
     *
     * @return A list filled with the {@link Item}s owned by this player.
     */
    default List<WalletItem> getAllItems() {
        List<WalletItem> items = new ArrayList<>(getMyMetaverseWallet());
        items.addAll(getEnjinWallet());

        return items;
    }

}
