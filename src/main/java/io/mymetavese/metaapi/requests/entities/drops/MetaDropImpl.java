package io.mymetavese.metaapi.requests.entities.drops;

import io.mymetavese.metaapi.api.entities.drops.DropConstraint;
import io.mymetavese.metaapi.api.entities.drops.MetaDrop;
import io.mymetavese.metaapi.api.entities.drops.requirements.DropEntryRequirement;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class MetaDropImpl implements MetaDrop {

    private final String id;
    private final String name;
    private final String description;
    private final String slug;
    private final String creatorId;
    private final List<DropEntryRequirement> entryRequirements;
    private final List<DropConstraint> constraints;

}
