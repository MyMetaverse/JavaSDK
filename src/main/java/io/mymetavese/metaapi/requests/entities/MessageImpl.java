package io.mymetavese.metaapi.requests.entities;

import com.google.gson.annotations.SerializedName;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.entities.Message;
import io.mymetavese.metaapi.requests.ApiImplementation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class MessageImpl implements Message, ApiImplementation {

    @Getter @Setter
    private MetaAPI metaAPI;

    @Getter
    @SerializedName("Message")
    private final String message;
}
