package io.mymetavese.metaapi.requests.entities;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.*;
import io.mymetavese.metaapi.api.actions.v2.GetTransferableItems;
import io.mymetavese.metaapi.api.entities.Item;
import io.mymetavese.metaapi.api.entities.v2.GameEntity;
import io.mymetavese.metaapi.requests.actions.*;
import io.mymetavese.metaapi.requests.actions.v2.GetTransferableItemsImpl;
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
    public GetTransferableItems fetchTrades(GameEntity target) {
        return new GetTransferableItemsImpl(metaAPI, this, target);
    }

    @Override
    public CreateLinkingLinkAction createLinkingLink() {
        return new CreateLinkingLinkActionImpl(metaAPI, this);
    }

    @Override
    public GetLinkingLink getLinkingLink() {
        return new GetLinkingLinkActionImpl(metaAPI, this);
    }

    @Override
    public GetMetaCitizenAction getActiveMetaCitizen() {
        return new GetMetaCitizenActionImpl(metaAPI, this);
    }

    @Override
    public GetPointsAction getPoints() {
        return new GetPointsActionImpl(metaAPI, this);
    }

    @Override
    public AddPointsAction addPoints() {
        return new AddPointsActionImpl(metaAPI, this);
    }
}
