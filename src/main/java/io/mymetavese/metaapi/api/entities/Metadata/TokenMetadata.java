package io.mymetavese.metaapi.api.entities.Metadata;

import io.mymetavese.metaapi.api.entities.v2.IndexProperty;

import java.util.Set;

public interface TokenMetadata {

    /**
     * Get the name of the token
     * @return the name of the token
     */
    String getName();

    /**
     * Get token description
     * @return the token's description
     */
    String getDescription();

    /**
     * Get token image
     * @return the URI of the token's image
     */
    String getImageURL();

    String getTokenIndex();

    Set<IndexProperty> getProperties();

    Set<IndexProperty> getHiddenProperties();

}
