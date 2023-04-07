package io.mymetavese.metaapi.requests.entities.drops.responses;

import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DropConsumedResponseImplTest {

    @Test
    @DisplayName("Deserialization of API response should work correctly")
    void testDeserialization() {

        String jsonProvidedByAPI = "{\"eventId\":\"testDropId\",\"crateId\":\"cr_123456\"}";

        DropConsumedResponseImpl deserializedDropConsumedResponse = new Gson()
                .fromJson(jsonProvidedByAPI, DropConsumedResponseImpl.class);

        assertThat(deserializedDropConsumedResponse.getDropId())
                .isEqualTo("testDropId");

        assertThat(deserializedDropConsumedResponse.getCrateId())
                .isEqualTo("cr_123456");

    }

}