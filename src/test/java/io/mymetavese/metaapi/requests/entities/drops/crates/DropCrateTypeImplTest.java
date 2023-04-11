package io.mymetavese.metaapi.requests.entities.drops.crates;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DropCrateTypeImplTest {

    @Test
    void testDeserialization() {

        String json = "{\n" + "\"perIndex\": true\n" + "}";

        DropCrateTypeImpl deserializedDropCrateType = new Gson().fromJson(json, DropCrateTypeImpl.class);

        assertThat(deserializedDropCrateType)
                .isNotNull()
                .hasFieldOrPropertyWithValue("perIndex", true);

    }

}