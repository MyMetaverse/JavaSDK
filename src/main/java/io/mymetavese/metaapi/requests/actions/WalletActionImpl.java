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
import java.util.*;
import java.util.function.Function;
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
        Function<JsonObject, WalletItemImpl> mapJsonItemToWalletItem = o -> new WalletItemImpl(this.getMetaAPI(),
                Utils.preventNull(o, "name", JsonElement::getAsString, null),
                Utils.preventNull(o, "tokenId", JsonElement::getAsString, null),
                Utils.preventNull(o, "indexes", el ->
                                StreamSupport.stream(o.get("indexes").getAsJsonArray().spliterator(), false)
                                        .map(JsonElement::getAsString).collect(Collectors.toSet())
                        , null),
                Utils.preventNull(o, "nft", JsonElement::getAsBoolean, null),
                Utils.preventNull(o, "amount", JsonElement::getAsInt, null),
                Utils.preventNull(o, "itemURI", JsonElement::getAsString, null));

        List<WalletItemImpl> centralizedWallet = StreamSupport.stream(json.get("centralizedItems").getAsJsonArray().spliterator(), false)
                .map(JsonElement::getAsJsonObject)
                .map(mapJsonItemToWalletItem)
                .collect(Collectors.toList());

        List<WalletItemImpl> lockedItems = StreamSupport.stream(json.get("lockedItems").getAsJsonArray().spliterator(), false)
                .map(JsonElement::getAsJsonObject)
                .map(mapJsonItemToWalletItem)
                .collect(Collectors.toList());

        JsonObject chainsJsonObject = json.get("chains").getAsJsonObject();

        Map<String, List<WalletItemImpl>> itemsInChains = chainsJsonObject.entrySet()
                .stream().map(chainEntry -> new AbstractMap.SimpleEntry<>(chainEntry.getKey(),
                        StreamSupport.stream(chainsJsonObject.get(chainEntry.getKey()).getAsJsonObject().get("items").getAsJsonArray().spliterator(), false)
                                .map(JsonElement::getAsJsonObject)
                                .map(mapJsonItemToWalletItem)
                                .collect(Collectors.toList())))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (prev, next) -> next, HashMap::new));

        return new PlayerWalletImpl(centralizedWallet, lockedItems, itemsInChains);
    }
}
