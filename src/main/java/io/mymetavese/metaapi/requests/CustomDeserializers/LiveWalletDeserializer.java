package io.mymetavese.metaapi.requests.CustomDeserializers;

import com.google.gson.*;
import io.mymetavese.metaapi.requests.entities.ItemIndex;
import io.mymetavese.metaapi.requests.entities.LiveWalletItemImpl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LiveWalletDeserializer implements JsonDeserializer<List<LiveWalletItemImpl>> {

    @Override
    public List<LiveWalletItemImpl> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonArray jsn = jsonElement.getAsJsonArray();
        List<LiveWalletItemImpl> liveWalletItems = new ArrayList<>();

        for (JsonElement jsonEl : jsn) {
            JsonObject jsonObject = jsonEl.getAsJsonObject();

            List<ItemIndex> itemIndices = new ArrayList<>();
            List<Object> locked = new ArrayList<>();

            if(jsonObject.has("token_indexes"))
                for (JsonElement token_indexes : jsonObject.getAsJsonArray("token_indexes"))
                    itemIndices.add(new ItemIndex(token_indexes.getAsString()));

            JsonElement lockedAsJson = jsonObject.get("locked");
            if (lockedAsJson.isJsonArray()) {
                for (JsonElement l : jsonObject.get("locked").getAsJsonArray())
                    locked.add(l.getAsJsonPrimitive());
            } else {
                locked.add(lockedAsJson.getAsJsonPrimitive());
            }

            LiveWalletItemImpl liveWalletItem = new LiveWalletItemImpl(
                    jsonObject.get("token_id").getAsString(),
                    itemIndices,
                    jsonObject.get("NFT").getAsBoolean(),
                    jsonObject.get("amount").getAsInt(),
                    locked
            );

            liveWalletItems.add(liveWalletItem);
        }

        return liveWalletItems;
    }

}

