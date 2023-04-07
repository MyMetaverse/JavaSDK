package io.mymetavese.metaapi.requests.actions.drops;

import io.mymetavese.metaapi.MetaAPIImpl;
import io.mymetavese.metaapi.api.entities.drops.MetaDrop;
import io.mymetavese.metaapi.requests.routes.V2;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetDropActionImplTest {

    @Mock
    MetaAPIImpl metaAPIMock;

    @Mock
    private Response responseMock;

    private GetDropActionImpl getDropAction;

    @BeforeEach
    void setUp() {

        when(metaAPIMock.getRouteAdapter()).thenReturn(new V2());
        getDropAction = new GetDropActionImpl(metaAPIMock, "myDropId");

    }

    @Test
    void compileRoute() {
        assertThat(getDropAction.compileRoute())
                .isNotNull()
                .isEqualTo(String.format("/metadrops/%s", "myDropId"));
    }

    @Test
    void transform() {

        String json = "{\n" +
                "    \"id\": \"63ca42a6e36aea1021a4a728\",\n" +
                "    \"name\": \"Honey Bear\",\n" +
                "    \"description\": \"Introducing the Honey Bear artefact\",\n" +
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
                "  }\n";

        ResponseBody responseBodyStub = ResponseBody.create(json, MediaType.get("application/json"));

        when(responseMock.body()).thenReturn(responseBodyStub);

        MetaDrop transformedEntity = getDropAction.transform(responseMock);

        assertThat(transformedEntity)
                .isNotNull();

        assertThat(transformedEntity)
                .hasFieldOrPropertyWithValue("id", "63ca42a6e36aea1021a4a728")
                .hasFieldOrPropertyWithValue("name", "Honey Bear")
                .hasFieldOrPropertyWithValue("description", "Introducing the Honey Bear artefact")
                .hasFieldOrPropertyWithValue("slug", "honeybear")
                .hasFieldOrPropertyWithValue("creatorId", "ct_VF03rFw18LA2FpTRBlChd");

        assertThat(transformedEntity.getEntryRequirements())
                .isNotNull()
                .hasSize(1);

        assertThat(transformedEntity.getConstraints())
                .isNotNull()
                .hasSize(0);

        assertThat(transformedEntity.getCrates())
                .isNotNull()
                .hasSize(1);


    }

}