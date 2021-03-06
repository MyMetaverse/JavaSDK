package io.mymetavese.metaapi.api.entities;

import org.jetbrains.annotations.Nullable;

public interface Message {

    /**
     * Represents a simple response with a single message.
     * @return A string with the response message.
     */
    String getMessage();

    /**
     * The resulting code of the found message.
     * <br />
     * <b>Note: </b> This can return null.
     * @return The code or null if not applicable.
     */
    @Nullable
    String getCode();

}
