package io.mymetavese.metaapi.requests.entities.drops.constraints;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LimitedConsumptionDropConstraintImplTest {

    LimitedConsumptionDropConstraintImpl limitedConsumptionDropConstraintStub;

    @BeforeEach
    void setUp() {
        limitedConsumptionDropConstraintStub = new LimitedConsumptionDropConstraintImpl(1);
    }

    @Test
    @DisplayName("toJsonElement() should return a JsonElement with the correct max consumptions per user & structure")
    void toJsonElement() {

        String expectedJson = "{\"limitedUserConsumption\":{\"maximumConsumptionsPerUser\":1}}";
        JsonElement jsonElement = JsonParser.parseString(expectedJson);

        assertThat(limitedConsumptionDropConstraintStub.toJsonElement())
                .isEqualTo(jsonElement);

    }

    @Test
    @DisplayName("getMaxConsumptionPerUser() should return the correct max consumptions per user")
    void getMaxConsumptionPerUser() {

        assertThat(limitedConsumptionDropConstraintStub.getMaxConsumptionPerUser())
                .isEqualTo(1);

    }

}