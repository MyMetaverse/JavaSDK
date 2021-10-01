package io.mymetavese.metaapi.api.entities.v2;

import java.util.Set;

public interface WalletItem {

    /**
     * The token is the ID used to identify this Item in the blockchain.
     *
     * @return A string representing the WalletIndex ID for this Item.
     */
    String getTokenId();

    /**
     * Some items are Non Fungible tokens and some are Fungible Tokens, use this verify that.
     *
     * @return Whether the item is FT or NFT.
     */
    boolean isNFT();

    /**
     * Return a list composited by the available indexes inside this item owned by a player.
     *
     * @return A List with ItemIndices owned by a player.
     */
    Set<String> getTokenIndexes();

    WalletIndex getIndex(String index);

    /**
     * Return a integer that represents how many of this items owns a player.
     *
     * @return An integer with the amount owned.
     */
    int getAmount();

    /**
     * Returns a string representing the name of this item.
     *
     * @return An string with the item's name.
     */
    String getName();

    /**
     * A string representing the URL to find the item metadata;
     * @return A string formatted as URL.
     */
    String getMetadata();

}
