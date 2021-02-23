package io.mymetavese.metaapi.requests.entities;

import io.mymetavese.metaapi.api.entities.TradeRequest;
import lombok.Getter;

import java.util.List;

public class TradeRequestImpl implements TradeRequest {

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
