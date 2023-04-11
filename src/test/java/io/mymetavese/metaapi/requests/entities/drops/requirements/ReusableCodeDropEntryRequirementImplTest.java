package io.mymetavese.metaapi.requests.entities.drops.requirements;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ReusableCodeDropEntryRequirementImplTest {

    ReusableCodeDropEntryRequirementImpl reusableCodeDropEntryRequirementStub;

    @BeforeEach
    void setUp() {
        reusableCodeDropEntryRequirementStub = new ReusableCodeDropEntryRequirementImpl("testReusableCode");
    }

    @Test
    @DisplayName("toJsonElement() should return a JsonElement with the correct reusable code & structure")
    void toJsonElement() {

        String entryRequirementJson = "{\"reusableCode\":\"testReusableCode\"}";
        JsonElement entryRequirementJsonElement = JsonParser.parseString(entryRequirementJson);

        assertThat(reusableCodeDropEntryRequirementStub.toJsonElement())
                .isEqualTo(entryRequirementJsonElement);

    }

    @Test
    @DisplayName("getReusableCode() should return the correct reusable code")
    void getReusableCode() {

        assertThat(reusableCodeDropEntryRequirementStub.getReusableCode())
                .isEqualTo("testReusableCode");

    }

}