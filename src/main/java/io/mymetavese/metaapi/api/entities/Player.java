package io.mymetavese.metaapi.api.entities;

import io.mymetavese.metaapi.api.actions.EthAddressAction;
import io.mymetavese.metaapi.api.actions.GetTradeableItems;
import io.mymetavese.metaapi.api.actions.TradeRequestAction;
import io.mymetavese.metaapi.api.actions.WalletAction;

import java.util.List;

public interface Player {

    WalletAction fetchWallet();

    EthAddressAction fetchEthAddress();

    TradeRequestAction sendTradeRequest(Player receiver, List<Item> itemsToTrade);

    GetTradeableItems fetchTrades(Player target);

    String getPlayerID();

}
