package io.mymetavese.metaapi.requests.entities.drops.requirements;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.mymetavese.metaapi.api.entities.drops.requirements.ReusableCodeDropEntryRequirement;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class ReusableCodeDropEntryRequirementImpl implements ReusableCodeDropEntryRequirement {

    private final String reusableCode;

    @Override
    public JsonElement toJsonElement() {
        JsonObject thisAsJson = new JsonObject();
        thisAsJson.addProperty("reusableCode", this.reusableCode);
        return thisAsJson;
    }
}
