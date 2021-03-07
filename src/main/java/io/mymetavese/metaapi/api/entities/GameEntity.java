package io.mymetavese.metaapi.api.entities;

import io.mymetavese.metaapi.api.ApiEntity;
import io.mymetavese.metaapi.api.actions.*;

import java.util.List;

public interface GameEntity extends ApiEntity {

    /**
     * Use this fetch everything related to player's wallet.
     * @return A representation of the action to fetch the player's wallet.
     */
    WalletAction fetchWallet();

    /**
     * Use this to fetch the player's Ethereum Wallet.
     * @return An action ready to fetch the player's Ethereum address.
     */
    EthAddressAction fetchEthAddress();

    /**
     * Use this to start a trade with another player.
     * @param receiver The target player to start the trade.
     * @param itemsToTrade The items that want to trade.
     * @return An action that represents the trade and ready to be executed.
     */
    TradeRequestAction sendTradeRequest(GameEntity receiver, List<Item> itemsToTrade);

    /**
     * use this to review the items that could be traded between the target player and this player.
     * @param target The target player we want to review.
     * @return An action that represents the result of possible trades.
     */
    GetTradeableItems fetchTrades(GameEntity target);

    /**
     * Use this to link the player with a compatible game.
     * @param linkingCode The unique and private link code for this player.
     * @return An action that represents the result of this link.
     */
    LinkPlayerAction linkPlayer(String linkingCode);

    /**
     * Use this to deposit items from LiveWallet to EnjinWallet
     * @param items The items to be deposited into EnjinWallet
     * @return An action that represents the result of this deposit.
     */
    DepositAction deposit(List<Token> items);

    /**
     *
     * @return The used PlayerID for this instance.
     */
    String getPlayerID();

}