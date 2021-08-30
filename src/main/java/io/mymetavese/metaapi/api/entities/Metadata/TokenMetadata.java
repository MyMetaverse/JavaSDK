package io.mymetavese.metaapi.api.entities.Metadata;

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
    String getImageURI();

}
