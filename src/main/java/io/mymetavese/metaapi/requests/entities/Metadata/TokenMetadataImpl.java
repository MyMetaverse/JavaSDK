package io.mymetavese.metaapi.requests.entities.Metadata;

import io.mymetavese.metaapi.api.entities.Metadata.TokenMetadata;
import io.mymetavese.metaapi.api.entities.v2.IndexProperty;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Getter
@RequiredArgsConstructor
@Data
public class TokenMetadataImpl implements TokenMetadata {

    private final String name;
    private final String description;
    private final String imageURL;
    private final String tokenIndex;

    private final Set<IndexProperty> properties;
    private final Set<IndexProperty> hiddenProperties;

}
