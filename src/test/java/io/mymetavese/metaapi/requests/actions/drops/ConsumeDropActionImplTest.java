package io.mymetavese.metaapi.requests.actions.drops;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.mymetavese.metaapi.MetaAPIImpl;
import io.mymetavese.metaapi.api.entities.v2.GameEntity;
import io.mymetavese.metaapi.requests.entities.drops.requirements.ReusableCodeDropEntryRequirementImpl;
import io.mymetavese.metaapi.requests.routes.RouteAdapter;
import io.mymetavese.metaapi.requests.routes.V2;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConsumeDropActionImplTest {

    @Mock
    MetaAPIImpl metaAPIMock;

    @Mock
    GameEntity gameEntityMock;

    @Mock
    private Response response;

    private ConsumeDropActionImpl consumeDropActionImpl;

    @BeforeEach
    void setUp() {

        ReusableCodeDropEntryRequirementImpl reusableCodeDropEntryRequirementStub = new ReusableCodeDropEntryRequirementImpl("my_reusable_code");
        RouteAdapter routeAdapter = new V2();

        when(metaAPIMock.getRouteAdapter()).thenReturn(routeAdapter);

        consumeDropActionImpl = new ConsumeDropActionImpl(metaAPIMock,
                "MyStubDrop",
                gameEntityMock,
                Collections.singletonList(reusableCodeDropEntryRequirementStub));

    }

    @Test
    void transform() {

        String json = "{\"eventId\": \"63ec9c2589adf4e1aca2687f\"," + "\"crateId\": \"cr_123456\"}";
        ResponseBody responseBodyStub = ResponseBody.create(json, MediaType.get("application/json"));

        when(response.body()).thenReturn(responseBodyStub);

        assertThat(consumeDropActionImpl.transform(response))
                .isNotNull()
                .hasFieldOrPropertyWithValue("dropId", "63ec9c2589adf4e1aca2687f")
                .hasFieldOrPropertyWithValue("crateId", "cr_123456");

    }

    @Test
    void compileRoute() {
        assertThat(consumeDropActionImpl.compileRoute())
                .isNotNull()
                .isEqualTo(String.format("/metadrops/%s/consume", "MyStubDrop"));
    }

    @Test
    void buildBody() {

        String expectedBody = "{\n" +
                "    \"playerId\": \"cdbc3194-b76c-483d-b644-035904423dbe\",\n" +
                "    \"claimRequirements\": [\n" +
                "        {\n" +
                "            \"reusableCode\": \"my_reusable_code\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        when(gameEntityMock.getPlayerID()).thenReturn("cdbc3194-b76c-483d-b644-035904423dbe");

        JsonObject expectedBodyAsJson = JsonParser.parseString(expectedBody).getAsJsonObject();
        JsonObject actualBodyAsJson = JsonParser.parseString(consumeDropActionImpl.buildBody().toJson()).getAsJsonObject();

        assertThat(actualBodyAsJson)
                .isNotNull()
                .isEqualTo(expectedBodyAsJson);

    }

}