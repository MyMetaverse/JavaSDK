package io.mymetavese.metaapi.requests.entities;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.*;
import io.mymetavese.metaapi.api.entities.GameEntity;
import io.mymetavese.metaapi.api.entities.Item;
import io.mymetavese.metaapi.api.entities.Token;
import io.mymetavese.metaapi.requests.actions.*;
import lombok.Getter;

import java.util.List;

public class GameEntityImpl implements GameEntity {

    @Getter
    private final MetaAPI metaAPI;

    @Getter
    private final String playerID;

    public GameEntityImpl(MetaAPI metaAPI, String playerID) {
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
    public TradeRequestAction sendTradeRequest(GameEntity receiver, List<Item> itemsToTrade) {
        return null;
    }

    @Override
    public GetTradeableItems fetchTrades(GameEntity target) {
        return new GetTradeableItemsImpl(metaAPI, this, target);
    }

    @Override
    public LinkPlayerAction linkPlayer(String linkingCode) {
        return new LinkPlayerActionImpl(metaAPI, this, linkingCode);
    }

    @Override
    public DepositAction deposit(List<Token> items) {
        return new DepositActionImpl(metaAPI, this, items);
    }

}
