package io.mymetavese.metaapi.requests.entities.drops.wrapper;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.drops.ConsumeDropAction;
import io.mymetavese.metaapi.api.actions.drops.GetAllDropsAction;
import io.mymetavese.metaapi.api.actions.drops.GetDropAction;
import io.mymetavese.metaapi.api.entities.drops.requirements.DropEntryRequirement;
import io.mymetavese.metaapi.api.entities.drops.wrapper.MetaDropsWrapper;
import io.mymetavese.metaapi.api.entities.v2.GameEntity;
import io.mymetavese.metaapi.requests.actions.drops.ConsumeDropActionImpl;
import io.mymetavese.metaapi.requests.actions.drops.GetAllDropsActionImpl;
import io.mymetavese.metaapi.requests.actions.drops.GetDropActionImpl;
import lombok.Getter;

import java.util.List;


public class MetaDropsWrapperImpl implements MetaDropsWrapper {

    @Getter
    private final MetaAPI metaAPI;

    public MetaDropsWrapperImpl(MetaAPI metaAPI) {
        this.metaAPI = metaAPI;
    }

    public GetAllDropsAction getAllDrops() {
        return new GetAllDropsActionImpl(this.metaAPI);
    }

    public GetDropAction getDropById(String dropId) {
        return new GetDropActionImpl(this.metaAPI, dropId);
    }

    public ConsumeDropAction consumeDrop(String dropId, GameEntity dropReceiver, List<DropEntryRequirement> dropEntryRequirements) {
        return new ConsumeDropActionImpl(this.metaAPI, dropId, dropReceiver, dropEntryRequirements);
    }

}
