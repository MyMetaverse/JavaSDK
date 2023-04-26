package io.mymetavese.metaapi.requests.entities;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.*;
import io.mymetavese.metaapi.api.actions.drops.ConsumeDropAction;
import io.mymetavese.metaapi.api.actions.p2e.AddP2EPointsAction;
import io.mymetavese.metaapi.api.actions.p2e.GetP2EPointsAction;
import io.mymetavese.metaapi.api.actions.v2.GetTransferableItems;
import io.mymetavese.metaapi.api.entities.Item;
import io.mymetavese.metaapi.api.entities.drops.requirements.DropEntryRequirement;
import io.mymetavese.metaapi.api.entities.v2.GameEntity;
import io.mymetavese.metaapi.requests.actions.*;
import io.mymetavese.metaapi.requests.actions.drops.ConsumeDropActionImpl;
import io.mymetavese.metaapi.requests.actions.p2e.AddP2EPointsActionImpl;
import io.mymetavese.metaapi.requests.actions.p2e.GetP2EPointsActionImpl;
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
    public GetLinkingLinkAction getLinkingLink() {
        return new GetLinkingLinkActionImpl(metaAPI, this);
    }

    @Override
    public GetMetaCitizenAction getActiveMetaCitizen() {
        return new GetMetaCitizenActionImpl(metaAPI, this);
    }

    @Override
    public GetP2EPointsAction getP2EPoints() {
        return new GetP2EPointsActionImpl(metaAPI, this);
    }

    @Override
    public AddP2EPointsAction addP2EPoints(int points) {
        return new AddP2EPointsActionImpl(metaAPI, this, points);
    }

    @Override
    public AddP2EPointsAction addP2EPoints(int points, String idempotencyKey) {
        return new AddP2EPointsActionImpl(metaAPI, this, points, idempotencyKey);
    }

    public ConsumeDropAction consumeDrop(String dropId, List<DropEntryRequirement> dropEntryRequirements) {
        return new ConsumeDropActionImpl(metaAPI, dropId, this, dropEntryRequirements);
    }
    
}
