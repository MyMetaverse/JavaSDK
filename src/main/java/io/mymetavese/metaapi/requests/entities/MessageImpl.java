package io.mymetavese.metaapi.requests.entities;

import com.google.gson.annotations.SerializedName;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.entities.Message;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

@RequiredArgsConstructor
public class MessageImpl implements Message {

    @Getter @Setter
    private MetaAPI metaAPI;

    @Getter
    @SerializedName("Message")
    private final String message;

    @Getter
    @Nullable
    private final String code;
}
