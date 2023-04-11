package io.mymetavese.metaapi.requests.custom_deserializers;

import com.google.gson.*;
import io.mymetavese.metaapi.api.entities.drops.constraints.DropConstraint;
import io.mymetavese.metaapi.requests.entities.drops.constraints.LimitedConsumptionDropConstraintImpl;

import java.lang.reflect.Type;

public class DropConstraintDeserializer implements JsonDeserializer<Object> {

    @Override
    public DropConstraint deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {

        if (!json.isJsonObject())
            throw new JsonParseException("Expecting a JsonObject, but it wasn't...");

        JsonObject jsonObject = json.getAsJsonObject();

        if (jsonObject.has("limitedUserConsumption")) {

            if (!jsonObject.get("limitedUserConsumption").isJsonObject())
                throw new JsonParseException(String.format("Expecting 'limitedUserConsumption' value to be a JsonObject, but it was %s", jsonObject.get("limitedUserConsumption")));

            JsonObject limitedUserConsumptionJsonObj = jsonObject.get("limitedUserConsumption").getAsJsonObject();

            if (!limitedUserConsumptionJsonObj.has("maximumConsumptionsPerUser"))
                throw new JsonParseException("Expecting 'maximumConsumptionsPerUser' to be present, but it wasn't...");

            if (limitedUserConsumptionJsonObj.get("maximumConsumptionsPerUser").isJsonPrimitive() && limitedUserConsumptionJsonObj.get("maximumConsumptionsPerUser").getAsJsonPrimitive().isNumber())
                return new LimitedConsumptionDropConstraintImpl(limitedUserConsumptionJsonObj.get("maximumConsumptionsPerUser").getAsInt());
            throw new JsonParseException(String.format("Expecting 'maximumConsumptionsPerUser' value to be an Integer, but it was %s", limitedUserConsumptionJsonObj.get("maximumConsumptionsPerUser")));

        }

        return null;

    }

}
