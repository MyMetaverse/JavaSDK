package io.mymetavese.metaapi.requests.entities.drops.requirements;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SingleCodeDropEntryRequirementImplTest {

    SingleCodeDropEntryRequirementImpl singleCodeDropEntryRequirementStub;

    @BeforeEach
    void setUp() {
        singleCodeDropEntryRequirementStub = new SingleCodeDropEntryRequirementImpl("testSingleCode");
    }

    @Test
    @DisplayName("toJsonElement() should return a JsonElement with the correct single code & structure")
    void toJsonElement() {

        String entryRequirementJson = "{\"code\":\"testSingleCode\"}";
        JsonElement entryRequirementJsonElement = JsonParser.parseString(entryRequirementJson);

        assertThat(singleCodeDropEntryRequirementStub.toJsonElement())
                .isEqualTo(entryRequirementJsonElement);

    }

    @Test
    @DisplayName("getSingleCode() should return the correct single code")
    void getSingleCode() {

        assertThat(singleCodeDropEntryRequirementStub.getSingleCode())
                .isEqualTo("testSingleCode");

    }

}