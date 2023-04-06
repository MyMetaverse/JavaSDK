package io.mymetavese.metaapi.requests.entities.drops;

import io.mymetavese.metaapi.api.entities.drops.constraints.DropConstraint;
import io.mymetavese.metaapi.api.entities.drops.MetaDrop;
import io.mymetavese.metaapi.api.entities.drops.requirements.DropEntryRequirement;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public class MetaDropImpl implements MetaDrop {

    private final String id;
    private final String name;
    private final String description;
    private final String slug;
    private final String creatorId;
    private final List<DropEntryRequirement> entryRequirements;
    private final List<DropConstraint> constraints;

    @Override
    public String toString() {
        return "MetaDropImpl{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description.substring(0, Math.min(10,description.length())) + "... (.getDescription() to see Full)" + '\'' +
                ", slug='" + slug + '\'' +
                ", creatorId='" + creatorId + '\'' +
                ", entryRequirements=" + entryRequirements +
                ", constraints=" + constraints +
                '}';
    }

}
