package io.mymetavese.metaapi.api.entities.drops;

import io.mymetavese.metaapi.api.entities.drops.constraints.DropConstraint;
import io.mymetavese.metaapi.api.entities.drops.requirements.DropEntryRequirement;
import io.mymetavese.metaapi.requests.entities.drops.crates.DropCrateImpl;

import java.util.List;

public interface MetaDrop {

    String getId();
    String getName();
    String getDescription();
    String getSlug();
    String getCreatorId();

    List<DropConstraint> getConstraints();

    List<DropCrateImpl> getCrates();

    List<DropEntryRequirement> getEntryRequirements();

}

