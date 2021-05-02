package io.mymetavese.metaapi.api.entities;

public interface LinkingLink {

    /**
     * Get the link required to link the player between an adopter and MyMetaverse.
     * @return The linking link (URL).
     */
    String getLinkingLink();

    String getLinkId();

    String getStatus();

}
