package io.mymetavese.metaapi.requests.entities.drops.wrapper;

import io.mymetavese.metaapi.MetaAPIImpl;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.entities.drops.requirements.DropEntryRequirement;
import io.mymetavese.metaapi.api.entities.v2.GameEntity;
import io.mymetavese.metaapi.requests.Route;
import io.mymetavese.metaapi.requests.actions.drops.ConsumeDropActionImpl;
import io.mymetavese.metaapi.requests.actions.drops.GetAllDropsActionImpl;
import io.mymetavese.metaapi.requests.actions.drops.GetDropActionImpl;
import io.mymetavese.metaapi.requests.entities.GameEntityImpl;
import io.mymetavese.metaapi.requests.routes.RouteAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MetaDropsWrapperImplTest {

    @Mock
    MetaAPIImpl metaAPIMock;

    MetaDropsWrapperImpl metaDropsWrapperStub;

    @BeforeEach
    void setUp() {

        RouteAdapter routeAdapterMock = mock(RouteAdapter.class);

        metaDropsWrapperStub = new MetaDropsWrapperImpl(metaAPIMock);

        when(metaAPIMock.getRouteAdapter()).thenReturn(routeAdapterMock);

    }

    @Test
    void getAllDrops() {
        assertThat(metaDropsWrapperStub.getAllDrops())
                .isNotNull()
                .isInstanceOf(GetAllDropsActionImpl.class)
                .hasFieldOrPropertyWithValue("metaAPI", metaAPIMock);
    }

    @Test
    void getDropById() {
        assertThat(metaDropsWrapperStub.getDropById("testId"))
                .isNotNull()
                .isInstanceOf(GetDropActionImpl.class)
                .hasFieldOrPropertyWithValue("metaAPI", metaAPIMock)
                .hasFieldOrPropertyWithValue("dropId", "testId");
    }

    @Test
    void consumeDrop() {

        GameEntityImpl gameEntityMock = mock(GameEntityImpl.class);

        List<DropEntryRequirement> dropEntryRequirementList = Arrays.asList(
                mock(DropEntryRequirement.class),
                mock(DropEntryRequirement.class)
        );

        when(metaAPIMock.getRouteAdapter()).thenReturn(mock(RouteAdapter.class));

        assertThat(metaDropsWrapperStub.consumeDrop("testId", gameEntityMock, dropEntryRequirementList))
                .isNotNull()
                .isInstanceOf(ConsumeDropActionImpl.class)
                .hasFieldOrPropertyWithValue("metaAPI", metaAPIMock)
                .hasFieldOrPropertyWithValue("dropId", "testId")
                .hasFieldOrPropertyWithValue("dropReceiver", gameEntityMock)
                .hasFieldOrPropertyWithValue("dropEntryRequirements", dropEntryRequirementList);
    }

}