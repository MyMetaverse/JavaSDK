package io.mymetavese.metaapi.requests.CustomDeserializers;

import com.google.gson.*;
import io.mymetavese.metaapi.requests.entities.EnjinWalletItemImpl;
import io.mymetavese.metaapi.requests.entities.ItemIndex;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EnjinWalletDeserializer implements JsonDeserializer<List<EnjinWalletItemImpl>> {

    @Override
    public List<EnjinWalletItemImpl> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonArray jsn = jsonElement.getAsJsonArray();
        List<EnjinWalletItemImpl> enjinWalletItems = new ArrayList<>();

        for (JsonElement jsonEl : jsn) {
            JsonObject jsonObject = jsonEl.getAsJsonObject();

            List<ItemIndex> itemIndices = new ArrayList<>();

            if(jsonObject.has("token_indexes"))
                for (JsonElement token_indexes : jsonObject.getAsJsonArray("token_indexes"))
                    itemIndices.add(new ItemIndex(token_indexes.getAsString()));

            EnjinWalletItemImpl enjinWalletItem = new EnjinWalletItemImpl(
                    jsonObject.get("token_id").getAsString(),
                    itemIndices,
                    jsonObject.get("NFT").getAsBoolean(),
                    jsonObject.get("amount").getAsInt(),
                    jsonObject.get("name").getAsString(),
                    jsonObject.get("name").getAsString()
            );

            enjinWalletItems.add(enjinWalletItem);
        }

        return enjinWalletItems;
    }

}

