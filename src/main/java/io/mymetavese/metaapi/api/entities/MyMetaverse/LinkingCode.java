package io.mymetavese.metaapi.api.entities.MyMetaverse;

import io.mymetavese.metaapi.api.entities.Message;

public interface LinkingCode extends Message {

    /**
     * Represents a fresh linking code for Enjin wallet.
     * @return String represeting the linking code.
     */
    String getLinkingCode();

}
