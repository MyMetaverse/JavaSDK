package io.mymetavese.metaapi.requests.entities;

import io.mymetavese.metaapi.MetaAPI;
import io.mymetavese.metaapi.api.actions.EthAddressAction;
import io.mymetavese.metaapi.api.actions.GetTradeableItems;
import io.mymetavese.metaapi.api.actions.TradeRequestAction;
import io.mymetavese.metaapi.api.actions.WalletAction;
import io.mymetavese.metaapi.api.entities.Item;
import io.mymetavese.metaapi.api.entities.Player;
import io.mymetavese.metaapi.requests.actions.EthAddressActionImpl;
import io.mymetavese.metaapi.requests.actions.GetTradeableItemsImpl;
import io.mymetavese.metaapi.requests.actions.WalletActionImpl;
import lombok.Getter;

import java.util.List;

public class PlayerImpl implements Player {

    @Getter
    private final MetaAPI api;

    @Getter
    private final String playerID;

    public PlayerImpl(MetaAPI api, String playerID) {
        this.api = api;
        this.playerID = playerID;
    }

    public WalletAction fetchWallet() {
        return new WalletActionImpl(api, this);
    }

    @Override
    public EthAddressAction fetchEthAddress() {
        return new EthAddressActionImpl(api, this);
    }

    @Override
    public TradeRequestAction sendTradeRequest(Player receiver, List<Item> itemsToTrade) {
        return null;
    }

    @Override
    public GetTradeableItems fetchTrades(Player target) {
        return new GetTradeableItemsImpl(api, this, target);
    }

}
