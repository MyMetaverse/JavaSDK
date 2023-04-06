package io.mymetavese.metaapi.api.entities.drops.wrapper;

import io.mymetavese.metaapi.api.ApiEntity;
import io.mymetavese.metaapi.api.actions.drops.ConsumeDropAction;
import io.mymetavese.metaapi.api.actions.drops.GetAllDropsAction;
import io.mymetavese.metaapi.api.actions.drops.GetDropAction;
import io.mymetavese.metaapi.api.entities.drops.requirements.DropEntryRequirement;
import io.mymetavese.metaapi.api.entities.v2.GameEntity;

import java.util.List;

public interface MetaDropsWrapper extends ApiEntity {

    GetAllDropsAction getAllDrops();

    GetDropAction getDropById(String dropId);

    ConsumeDropAction consumeDrop(String dropId, GameEntity dropReceiver, List<DropEntryRequirement> dropEntryRequirements);


}
