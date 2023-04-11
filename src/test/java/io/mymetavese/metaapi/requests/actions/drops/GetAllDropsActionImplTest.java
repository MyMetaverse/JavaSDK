package io.mymetavese.metaapi.requests.actions.drops;

import io.mymetavese.metaapi.MetaAPIImpl;
import io.mymetavese.metaapi.api.entities.drops.MetaDrop;
import io.mymetavese.metaapi.requests.routes.RouteAdapter;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetAllDropsActionImplTest {

    @Mock
    MetaAPIImpl metaAPIMock;

    @Mock
    private Response responseMock;

    private GetAllDropsActionImpl getAllDropsActionImpl;

    @BeforeEach
    void setUp() {

        when(metaAPIMock.getRouteAdapter()).thenReturn(mock(RouteAdapter.class));
        getAllDropsActionImpl = new GetAllDropsActionImpl(metaAPIMock);

    }

    @Test
    void transform() {

        String json = "[\n" +
                "  {\n" +
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
                "  }\n" +
                "]";

        ResponseBody responseBodyStub = ResponseBody.create(json, MediaType.get("application/json"));

        when(responseMock.body()).thenReturn(responseBodyStub);

        List<MetaDrop> transformedEntities = getAllDropsActionImpl.transform(responseMock);

        assertThat(transformedEntities)
                .isNotNull()
                .hasSize(1);

        assertThat(transformedEntities)
                .first()
                .hasFieldOrPropertyWithValue("id", "63ca42a6e36aea1021a4a728")
                .hasFieldOrPropertyWithValue("name", "Honey Bear")
                .hasFieldOrPropertyWithValue("description", "Introducing the Honey Bear artefact")
                .hasFieldOrPropertyWithValue("slug", "honeybear")
                .hasFieldOrPropertyWithValue("creatorId", "ct_VF03rFw18LA2FpTRBlChd");

        assertThat(transformedEntities.get(0).getEntryRequirements())
                .isNotNull()
                .hasSize(1);

        assertThat(transformedEntities.get(0).getConstraints())
                .isNotNull()
                .hasSize(0);

        assertThat(transformedEntities.get(0).getCrates())
                .isNotNull()
                .hasSize(1);

    }

}