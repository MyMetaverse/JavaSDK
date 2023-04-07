package io.mymetavese.metaapi.requests.custom_deserializers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import io.mymetavese.metaapi.api.entities.drops.constraints.DropConstraint;
import io.mymetavese.metaapi.requests.entities.drops.constraints.LimitedConsumptionDropConstraintImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DropConstraintDeserializerTest {

    @Test
    @DisplayName("Deserialize Limited User Consumption Constraint type.")
    void deserialize_limitedUserConsumptionConstraint() {

        String json = "{\"limitedUserConsumption\": {\"maximumConsumptionsPerUser\": 1}}";

        Gson gsonInstance = new GsonBuilder()
                .registerTypeAdapter(DropConstraint.class, new DropConstraintDeserializer())
                .create();

        DropConstraint dropConstraints = gsonInstance.fromJson(json, DropConstraint.class);

        assertThat(dropConstraints)
                .isNotNull()
                .isInstanceOf(LimitedConsumptionDropConstraintImpl.class)
                .hasFieldOrPropertyWithValue("maxConsumptionPerUser", 1);

    }

}