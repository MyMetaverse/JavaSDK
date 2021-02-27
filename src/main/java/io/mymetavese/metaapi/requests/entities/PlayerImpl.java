package io.mymetavese.metaapi.requests.entities;

import io.mymetavese.metaapi.MetaAPIImpl;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.EthAddressAction;
import io.mymetavese.metaapi.api.actions.GetTradeableItems;
import io.mymetavese.metaapi.api.actions.TradeRequestAction;
import io.mymetavese.metaapi.api.actions.WalletAction;
import io.mymetavese.metaapi.api.entities.Item;
import io.mymetavese.metaapi.api.entities.Player;
import io.mymetavese.metaapi.requests.ApiImplementation;
import io.mymetavese.metaapi.requests.actions.EthAddressActionImpl;
import io.mymetavese.metaapi.requests.actions.GetTradeableItemsImpl;
import io.mymetavese.metaapi.requests.actions.WalletActionImpl;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class PlayerImpl implements Player, ApiImplementation {

    @Getter @Setter
    private MetaAPI metaAPI;

    @Getter
    private final String playerID;

    public PlayerImpl(MetaAPI metaAPI, String playerID) {
        this.metaAPI = metaAPI;
        this.playerID = playerID;
    }

    public WalletAction fetchWallet() {
        return new WalletActionImpl(metaAPI, this);
    }

    @Override
    public EthAddressAction fetchEthAddress() {
        return new EthAddressActionImpl(metaAPI, this);
    }

    @Override
    public TradeRequestAction sendTradeRequest(Player receiver, List<Item> itemsToTrade) {
        return null;
    }

    @Override
    public GetTradeableItems fetchTrades(Player target) {
        return new GetTradeableItemsImpl(metaAPI, this, target);
    }

}
