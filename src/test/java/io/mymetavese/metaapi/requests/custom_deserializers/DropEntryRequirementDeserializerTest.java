package io.mymetavese.metaapi.requests.custom_deserializers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.mymetavese.metaapi.api.entities.drops.constraints.DropConstraint;
import io.mymetavese.metaapi.api.entities.drops.requirements.DropEntryRequirement;
import io.mymetavese.metaapi.requests.entities.drops.constraints.LimitedConsumptionDropConstraintImpl;
import io.mymetavese.metaapi.requests.entities.drops.requirements.ReusableCodeDropEntryRequirementImpl;
import io.mymetavese.metaapi.requests.entities.drops.requirements.SingleCodeDropEntryRequirementImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DropEntryRequirementDeserializerTest {

    Gson gsonInstance;

    @BeforeEach
    void setUp() {
        gsonInstance = new GsonBuilder()
                .registerTypeAdapter(DropEntryRequirement.class, new DropEntryRequirementDeserializer())
                .create();
    }

    @Test
    @DisplayName("Deserialize Reusable Code Drop Requirement if empty.")
    void deserialize_reusableCodeDropEntryRequirement_empty() {

        String json = "{\"reusableCode\": {}}";

        DropEntryRequirement dropRequirement = gsonInstance.fromJson(json, DropEntryRequirement.class);

        assertThat(dropRequirement)
                .isNotNull()
                .isInstanceOf(ReusableCodeDropEntryRequirementImpl.class)
                .hasFieldOrPropertyWithValue("reusableCode", null);

    }

    @Test
    @DisplayName("Deserialize Reusable Code Drop Requirement if it has a value.")
    void deserialize_reusableCodeDropEntryRequirement_withValue() {

        String json = "{\"reusableCode\": \"reusable_code_123456\"}";

        DropEntryRequirement dropRequirement = gsonInstance.fromJson(json, DropEntryRequirement.class);

        assertThat(dropRequirement)
                .isNotNull()
                .isInstanceOf(ReusableCodeDropEntryRequirementImpl.class)
                .hasFieldOrPropertyWithValue("reusableCode", "reusable_code_123456");

    }

    @Test
    @DisplayName("Deserialize Single Code Drop Requirement if empty.")
    void deserialize_singleCodeDropEntryRequirement_empty() {

        String json = "{\"code\": {}}";

        DropEntryRequirement dropRequirement = gsonInstance.fromJson(json, DropEntryRequirement.class);

        assertThat(dropRequirement)
                .isNotNull()
                .isInstanceOf(SingleCodeDropEntryRequirementImpl.class)
                .hasFieldOrPropertyWithValue("singleCode", null);

    }

    @Test
    @DisplayName("Deserialize Single Code Drop Requirement if it has a value.")
    void deserialize_singleCodeDropEntryRequirement_withValue() {

        String json = "{\"code\": \"single_code_123456\"}";

        DropEntryRequirement dropRequirement = gsonInstance.fromJson(json, DropEntryRequirement.class);

        assertThat(dropRequirement)
                .isNotNull()
                .isInstanceOf(SingleCodeDropEntryRequirementImpl.class)
                .hasFieldOrPropertyWithValue("singleCode", "single_code_123456");

    }

}