package io.mymetavese.metaapi.requests.custom_deserializers;

import com.google.gson.*;
import io.mymetavese.metaapi.api.entities.drops.requirements.DropEntryRequirement;
import io.mymetavese.metaapi.requests.entities.drops.requirements.ReusableCodeDropEntryRequirementImpl;
import io.mymetavese.metaapi.requests.entities.drops.requirements.SingleCodeDropEntryRequirementImpl;

import java.lang.reflect.Type;

public class DropEntryRequirementDeserializer implements JsonDeserializer<Object> {

    @Override
    public DropEntryRequirement deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {

        if (!json.isJsonObject())
            throw new JsonParseException("Expecting a JsonObject, but it wasn't...");

        JsonObject jsonObject = json.getAsJsonObject();

        if (jsonObject.has("reusableCode")) {

            if (jsonObject.get("reusableCode").isJsonPrimitive())
                return new ReusableCodeDropEntryRequirementImpl(jsonObject.get("reusableCode").getAsString());
            return new ReusableCodeDropEntryRequirementImpl(null);

        } else if (jsonObject.has("code")) {

            if (jsonObject.get("code").isJsonPrimitive() && jsonObject.get("code").getAsJsonPrimitive().isString())
                return new SingleCodeDropEntryRequirementImpl(jsonObject.get("code").getAsString());
            return new SingleCodeDropEntryRequirementImpl(null);

        }

        return null;

    }

}
