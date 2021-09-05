package io.mymetavese.metaapi.requests.actions;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.WalletAction;
import io.mymetavese.metaapi.api.entities.PlayerWallet;
import io.mymetavese.metaapi.api.entities.v2.GameEntity;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.Utils;
import io.mymetavese.metaapi.requests.entities.PlayerWalletImpl;
import io.mymetavese.metaapi.requests.entities.WalletItemImpl;
import io.mymetavese.metaapi.requests.routes.Routes;
import okhttp3.Response;

import java.io.Reader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class WalletActionImpl extends RestActionImpl<PlayerWallet> implements WalletAction {

    private final String playerID;

    public WalletActionImpl(MetaAPI api, GameEntity gameEntity) {
        super(api, Routes.GET_WALLET);
        this.playerID = gameEntity.getPlayerID();
    }

    @Override
    protected String compileRoute() {
        return route.compileRoute(playerID);
    }

    @Override
    public PlayerWallet transform(Response response) {
        Gson gson = new Gson();

        Reader reader = Objects.requireNonNull(response.body()).charStream();
        JsonObject json = gson.fromJson(reader, JsonObject.class);

        List<WalletItemImpl> enjin =
                StreamSupport.stream(json.get("enjinWallet").getAsJsonArray().spliterator(), false)
                .map(JsonElement::getAsJsonObject)
                .map(o -> new WalletItemImpl(this.getMetaAPI(),
                        Utils.preventNull(o, "name", JsonElement::getAsString, null),
                        Utils.preventNull(o, "tokenId", JsonElement::getAsString, null),
                        Utils.preventNull(o, "indices", el ->
                            StreamSupport.stream(o.get("indices").getAsJsonArray().spliterator(), false)
                                    .map(JsonElement::getAsString).collect(Collectors.toSet())
                        , null),
                        Utils.preventNull(o, "nft", JsonElement::getAsBoolean, null),
                        Utils.preventNull(o, "amount", JsonElement::getAsInt, null),
                        Utils.preventNull(o, "itemURI", JsonElement::getAsString, null))
                ).collect(Collectors.toList());

        List<WalletItemImpl> meta =
                StreamSupport.stream(json.get("liveWallet").getAsJsonArray().spliterator(), false)
                        .map(JsonElement::getAsJsonObject)
                        .map(o -> new WalletItemImpl(this.getMetaAPI(),
                                Utils.preventNull(o, "name", JsonElement::getAsString, null),
                                Utils.preventNull(o, "tokenId", JsonElement::getAsString, null),
                                Utils.preventNull(o, "indices", el ->
                                                StreamSupport.stream(o.get("indices").getAsJsonArray().spliterator(), false)
                                                        .map(JsonElement::getAsString).collect(Collectors.toSet())
                                        , null),
                                Utils.preventNull(o, "nft", JsonElement::getAsBoolean, null),
                                Utils.preventNull(o, "amount", JsonElement::getAsInt, null),
                                Utils.preventNull(o, "itemURI", JsonElement::getAsString, null))
                        ).collect(Collectors.toList());

        return new PlayerWalletImpl(meta, enjin);
    }
}
