package io.mymetavese.metaapi.requests.entities.drops.requirements;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.mymetavese.metaapi.api.entities.drops.requirements.SingleCodeDropEntryRequirement;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class SingleCodeDropEntryRequirementImpl implements SingleCodeDropEntryRequirement {

    private final String singleCode;

    @Override
    public JsonElement toJsonElement() {
        JsonObject thisAsJson = new JsonObject();
        thisAsJson.addProperty("code", this.singleCode);
        return thisAsJson;
    }

}
