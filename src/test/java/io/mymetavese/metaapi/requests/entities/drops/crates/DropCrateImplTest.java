package io.mymetavese.metaapi.requests.entities.drops.crates;

import com.google.gson.Gson;
import io.mymetavese.metaapi.api.entities.Item;
import io.mymetavese.metaapi.requests.entities.ItemIndex;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DropCrateImplTest {

    @Test
    void testDeserialization() {

        // This is a JSON string comes from Postman docs.
        String crateJson = "{\n" +
                "      \"id\": \"cr_I2MIE69I\",\n" +
                "      \"name\": \"Crate\",\n" +
                "      \"totalSupply\": 50000,\n" +
                "      \"availableSupply\": 49661,\n" +
                "      \"tokens\": [\n" +
                "        {\n" +
                "          \"id\": \"a800000000000001\",\n" +
                "          \"indexes\": [\n" +
                "            \"0000000000000341\",\n" +
                "            \"0000000000000342\",\n" +
                "            \"0000000000000343\",\n" +
                "            \"0000000000050001\"\n" +
                "          ]\n" +
                "        }\n" +
                "      ],\n" +
                "      \"type\": {\n" +
                "        \"perIndex\": true\n" +
                "      }\n" +
                "    }";

        // Deserialize the JSON string to DropCrateImpl object and check if all the fields are correct.

        DropCrateImpl deserializedDropCrate = new Gson().fromJson(crateJson, DropCrateImpl.class);

        assertThat(deserializedDropCrate)
                .isNotNull()
                .hasFieldOrPropertyWithValue("id", "cr_I2MIE69I")
                .hasFieldOrPropertyWithValue("name", "Crate")
                .hasFieldOrPropertyWithValue("totalSupply", 50000)
                .hasFieldOrPropertyWithValue("availableSupply", 49661)
                .hasFieldOrProperty("tokensInCrate");

        assertThat(deserializedDropCrate.getTokensInCrate())
                .isNotNull()
                .hasSize(1);

        Item firstToken = deserializedDropCrate.getTokensInCrate().get(0);

        assertThat(firstToken)
                .isNotNull()
                .hasFieldOrPropertyWithValue("tokenId", "a800000000000001")
                        .hasFieldOrProperty("tokenIndexes");

        assertThat(firstToken.getTokenIndexes())
                .isNotNull()
                .hasSize(4)
                .containsExactly(
                        new ItemIndex(null, "0000000000000341"),
                        new ItemIndex(null, "0000000000000342"),
                        new ItemIndex(null, "0000000000000343"),
                        new ItemIndex(null, "0000000000050001")
                );

        assertThat(deserializedDropCrate.getType())
                .isNotNull()
                .hasFieldOrPropertyWithValue("perIndex", true);

    }

}