package io.mymetavese.metaapi.api.entities.drops;

import io.mymetavese.metaapi.api.entities.drops.constraints.DropConstraint;
import io.mymetavese.metaapi.api.entities.drops.requirements.DropEntryRequirement;

import java.util.List;

public interface MetaDrop {

    String getId();
    String getName();
    String getDescription();
    String getSlug();
    String getCreatorId();

    List<DropEntryRequirement> getEntryRequirements();

    List<DropConstraint> getConstraints();



}

