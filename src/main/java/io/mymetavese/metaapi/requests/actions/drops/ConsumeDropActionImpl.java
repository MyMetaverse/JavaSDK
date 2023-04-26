package io.mymetavese.metaapi.requests.actions.drops;

import com.google.gson.JsonArray;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.drops.ConsumeDropAction;
import io.mymetavese.metaapi.api.entities.drops.requirements.DropEntryRequirement;
import io.mymetavese.metaapi.api.entities.drops.responses.DropConsumedResponse;
import io.mymetavese.metaapi.api.entities.v2.GameEntity;
import io.mymetavese.metaapi.requests.JsonObject;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.entities.drops.responses.DropConsumedResponseImpl;
import io.mymetavese.metaapi.requests.routes.Routes;

import java.util.List;

public class ConsumeDropActionImpl extends RestActionImpl<DropConsumedResponse> implements ConsumeDropAction {

    private final String dropId;
    private final GameEntity dropReceiver;
    private final List<DropEntryRequirement> dropEntryRequirements;

    public ConsumeDropActionImpl(MetaAPI api, String dropId, GameEntity dropReceiver, List<DropEntryRequirement> dropEntryRequirements) {
        super(api, Routes.CONSUME_DROP, DropConsumedResponseImpl.class);
        this.dropId = dropId;
        this.dropReceiver = dropReceiver;
        this.dropEntryRequirements = dropEntryRequirements;
    }

    @Override
    protected String compileRoute() {
        return route.compileRoute(dropId);
    }

    @Override
    protected JsonObject buildBody() {

        JsonObject body = JsonObject.JsonObjectBuilder.newBuilder().create();
        JsonArray requirements = new JsonArray();

        body.append("playerId", dropReceiver.getPlayerID());

        dropEntryRequirements.stream()
                .map(DropEntryRequirement::toJsonElement)
                .forEach(requirements::add);

        body.append("claimRequirements", requirements);

        return body;
    }

}
