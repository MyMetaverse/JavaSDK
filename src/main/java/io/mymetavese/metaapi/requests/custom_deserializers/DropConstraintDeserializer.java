package io.mymetavese.metaapi.requests.custom_deserializers;

import com.google.gson.*;
import io.mymetavese.metaapi.requests.entities.drops.constraints.LimitedConsumptionDropConstraintImpl;

import java.lang.reflect.Type;

public class DropConstraintDeserializer implements JsonDeserializer<Object> {

    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {

        if (!json.isJsonObject())
            throw new JsonParseException("Expecting a JsonObject, but it wasn't...");

        JsonObject jsonObject = json.getAsJsonObject();

        if (jsonObject.has("limitedUserConsumption")) {

            if (!jsonObject.get("limitedUserConsumption").isJsonObject())
                throw new JsonParseException("Expecting 'limitedUserConsumption' value to be a JsonObject, but it wasn't...");

            JsonObject limitedUserConsumptionJsonObj = jsonObject.get("limitedUserConsumption").getAsJsonObject();

            if (!limitedUserConsumptionJsonObj.has("maximumConsumptionsPerUser"))
                throw new JsonParseException("Expecting 'maximumConsumptionsPerUser' to be present, but it wasn't...");

            if (limitedUserConsumptionJsonObj.get("maximumConsumptionsPerUser").isJsonPrimitive() && limitedUserConsumptionJsonObj.get("maximumConsumptionsPerUser").getAsJsonPrimitive().isNumber())
                return new LimitedConsumptionDropConstraintImpl(jsonObject.get("maximumConsumptionsPerUser").getAsInt());
            throw new JsonParseException("Expecting 'maximumConsumptionsPerUser' value to be an Integer, but it wasn't...");

        }

        return null;

    }

}
