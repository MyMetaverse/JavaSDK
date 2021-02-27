package io.mymetavese.metaapi.requests.entities;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.entities.TradeRequest;
import io.mymetavese.metaapi.requests.ApiImplementation;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class TradeRequestImpl implements TradeRequest, ApiImplementation {

    @Getter @Setter
    private MetaAPI metaAPI;

    @Getter
    private String initiatorPlayerID;

    @Getter
    private String receiverPlayerID;

    @Getter
    private List<LiveWalletItemImpl> itemsToOffer;

    @Getter
    private List<LiveWalletItemImpl> itemsToAsk;

    @Override
    public String toString() {
        return "TradeRequestImpl{" +
                "initiatorPlayerID='" + initiatorPlayerID + '\'' +
                ", receiverPlayerID='" + receiverPlayerID + '\'' +
                ", itemsToOffer=" + itemsToOffer +
                ", itemsToAsk=" + itemsToAsk +
                '}';
    }
}
