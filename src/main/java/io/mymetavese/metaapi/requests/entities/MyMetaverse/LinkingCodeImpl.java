package io.mymetavese.metaapi.requests.entities.MyMetaverse;

import com.google.gson.annotations.SerializedName;
import io.mymetavese.metaapi.api.entities.MyMetaverse.LinkingCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class LinkingCodeImpl implements LinkingCode {

    @SerializedName("Message")
    private final String message;

    private final String code;

    @SerializedName("LinkingCode")
    private final String linkingCode;

}
