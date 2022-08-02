package io.mymetavese.metaapi.api.entities.v2;

import io.mymetavese.metaapi.api.ApiEntity;
import io.mymetavese.metaapi.api.actions.*;
import io.mymetavese.metaapi.api.actions.p2e.AddP2EPointsAction;
import io.mymetavese.metaapi.api.actions.p2e.GetP2EPointsAction;
import io.mymetavese.metaapi.api.actions.v2.GetTransferableItems;
import io.mymetavese.metaapi.api.entities.Item;

import java.util.List;

public interface GameEntity extends ApiEntity {

    /**
     * @return The used PlayerID for this instance.
     */
    String getPlayerID();

    /**
     * Use this fetch everything related to player's wallet.
     *
     * @return A representation of the action to fetch the player's wallet.
     */
    WalletAction fetchWallet();

    /**
     * Use this to fetch the player's Ethereum Wallet.
     *
     * @return An action ready to fetch the player's Ethereum address.
     */
    EthAddressAction fetchEthAddress();

    /**
     * Use this to start a trade with another player.
     *
     * @param receiver     The target player to start the trade.
     * @param itemsToTrade The items that want to trade.
     * @return An action that represents the trade and ready to be executed.
     */
    TradeRequestAction sendTradeRequest(GameEntity receiver, List<Item> itemsToTrade);

    /**
     * use this to review the items that could be traded between the target player and this player.
     *
     * @param target The target player we want to review.
     * @return An action that represents the result of possible trades.
     */
    GetTransferableItems fetchTrades(GameEntity target);

    /**
     * Create linking link for the player.
     *
     * @return An action that represents the result of creating a linking link.
     */
    CreateLinkingLinkAction createLinkingLink();

    /**
     * Get the already created linking link for the player.
     *
     * @return An action that represents the linking link.
     */
    GetLinkingLink getLinkingLink();

    /**
     * Get the currently active metacitizen for this game entity.
     *
     * @return An action representing the index of the active metaCitizen.
     */
    GetMetaCitizenAction getActiveMetaCitizen();
    
    /*
    * Get the P&E points for the player.
    */
    GetP2EPointsAction getP2EPoints();
    
    /*
    * Add P&E points to the player.
    */
    AddP2EPointsAction addP2EPoints(int points);
    
}
