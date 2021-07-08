package io.mymetavese.metaapi.requests.actions;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.DepositAction;
import io.mymetavese.metaapi.api.entities.GameEntity;
import io.mymetavese.metaapi.api.entities.Message;
import io.mymetavese.metaapi.api.entities.Token;
import io.mymetavese.metaapi.requests.JsonObject;
import io.mymetavese.metaapi.requests.RestActionImpl;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

public class DepositActionImpl extends RestActionImpl<Message> implements DepositAction {

    private final GameEntity gameEntity;

    private final List<Token> tokens;

    public DepositActionImpl(MetaAPI api, GameEntity gameEntity, List<Token> tokens) {
        super(api, null);
        this.gameEntity = gameEntity;
        this.tokens = tokens;
    }

    @Override
    protected JsonObject buildBody() {
        JsonObject body = JsonObject.JsonObjectBuilder.newBuilder().create();
        body.append("PlayerID", gameEntity.getPlayerID());

        // We convert the tokens to a format that can be used by the remote API.
        List<TransferableToken> tokensToDeposit = tokens.stream()
                .map(TransferableToken::convertToken)
                .collect(Collectors.toList());

        body.append("Items", tokensToDeposit);
        return body;
    }

    @SuppressWarnings("unused") // All the variables here will be used by GSON.
    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    private static class TransferableToken {

        private final String token_id;
        private final String token_index;
        private final String value;


        private static TransferableToken convertToken(Token token) {
            String index = token.getIndex();
            index = index != null && index.isEmpty() ? null : index;
            return new TransferableToken(token.getID(), index, String.valueOf(token.getAmount()));
        }

    }

}
