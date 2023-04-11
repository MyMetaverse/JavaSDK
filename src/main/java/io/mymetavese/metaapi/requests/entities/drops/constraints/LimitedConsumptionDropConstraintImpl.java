package io.mymetavese.metaapi.requests.entities.drops.constraints;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.mymetavese.metaapi.api.entities.drops.constraints.LimitedConsumptionDropConstraint;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class LimitedConsumptionDropConstraintImpl implements LimitedConsumptionDropConstraint {

    private final int maxConsumptionPerUser;

    @Override
    public JsonElement toJsonElement() {

        JsonObject thisAsJson = new JsonObject();
        JsonObject innerObject = new JsonObject();

        innerObject.addProperty("maximumConsumptionsPerUser", this.maxConsumptionPerUser);
        thisAsJson.add("limitedUserConsumption", innerObject);

        return thisAsJson;

    }

}
