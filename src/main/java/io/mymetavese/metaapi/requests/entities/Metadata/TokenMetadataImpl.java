package io.mymetavese.metaapi.requests.entities.Metadata;

import com.google.gson.annotations.SerializedName;
import io.mymetavese.metaapi.api.entities.Metadata.TokenMetadata;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TokenMetadataImpl implements TokenMetadata {

    private final String name;
    private final String description;
    @SerializedName("image")
    private final String imageURI;

}
