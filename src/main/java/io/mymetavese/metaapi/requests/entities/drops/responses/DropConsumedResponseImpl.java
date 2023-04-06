package io.mymetavese.metaapi.requests.entities.drops.responses;

import com.google.gson.annotations.SerializedName;
import io.mymetavese.metaapi.api.entities.drops.responses.DropConsumedResponse;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class DropConsumedResponseImpl implements DropConsumedResponse {

    @SerializedName("eventId")
    private final String dropId;
    private final String crateId;

}
