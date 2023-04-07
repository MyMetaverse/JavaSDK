package io.mymetavese.metaapi.requests.entities.drops;

import com.google.gson.GsonBuilder;
import io.mymetavese.metaapi.api.entities.drops.constraints.DropConstraint;
import io.mymetavese.metaapi.api.entities.drops.requirements.DropEntryRequirement;
import io.mymetavese.metaapi.requests.custom_deserializers.DropConstraintDeserializer;
import io.mymetavese.metaapi.requests.custom_deserializers.DropEntryRequirementDeserializer;
import io.mymetavese.metaapi.requests.entities.drops.crates.DropCrateImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MetaDropImplTest {

    @Test
    void testDeserialization() {

        String json = "{\n" +
                "    \"id\": \"63ca42a6e36aea1021a4a728\",\n" +
                "    \"name\": \"Honey Bear\",\n" +
                "    \"description\": \"Introducing the Honey Bear artefact - the ultimate digital companion!\",\n" +
                "    \"slug\": \"honeybear\",\n" +
                "    \"creatorId\": \"ct_VF03rFw18LA2FpTRBlChd\",\n" +
                "    \"entryRequirements\": [\n" +
                "      {\n" +
                "        \"reusableCode\": {}\n" +
                "      }\n" +
                "    ],\n" +
                "    \"constraints\": [],\n" +
                "    \"crates\": [\n" +
                "      {\n" +
                "        \"id\": \"cr_I2MIE69I\",\n" +
                "        \"name\": \"Crate\",\n" +
                "        \"totalSupply\": 50000,\n" +
                "        \"availableSupply\": 50000,\n" +
                "        \"tokens\": [\n" +
                "          {\n" +
                "            \"id\": \"a800000000000001\",\n" +
                "            \"indexes\": [\n" +
                "              \"0000000000000002\",\n" +
                "              \"0000000000000003\",\n" +
                "              \"0000000000000004\",\n" +
                "              \"0000000000050001\"\n" +
                "            ]\n" +
                "          }\n" +
                "        ],\n" +
                "        \"type\": {\n" +
                "          \"perIndex\": true\n" +
                "        }\n" +
                "      }\n" +
                "    ]\n" +
                "  }";

        MetaDropImpl deserializedDrop = new GsonBuilder()
                .registerTypeAdapter(DropEntryRequirement.class, new DropEntryRequirementDeserializer())
                .registerTypeAdapter(DropConstraint.class, new DropConstraintDeserializer())
                .create()
                .fromJson(json, MetaDropImpl.class);

        assertThat(deserializedDrop)
                .isNotNull()
                .hasFieldOrPropertyWithValue("id", "63ca42a6e36aea1021a4a728")
                .hasFieldOrPropertyWithValue("name", "Honey Bear")
                .hasFieldOrPropertyWithValue("description", "Introducing the Honey Bear artefact - the ultimate digital companion!");

        assertThat(deserializedDrop.getEntryRequirements())
                .isNotNull()
                .hasSize(1)
                .first()
                .isInstanceOf(DropEntryRequirement.class);

        assertThat(deserializedDrop.getConstraints())
                .isNotNull()
                .hasSize(0);

        assertThat(deserializedDrop.getCrates())
                .isNotNull()
                .hasSize(1)
                .first()
                .isInstanceOf(DropCrateImpl.class);

    }

}