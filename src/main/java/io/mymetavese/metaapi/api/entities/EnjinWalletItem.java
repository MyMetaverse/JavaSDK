package io.mymetavese.metaapi.api.entities;

public interface EnjinWalletItem extends Item {

    /**
     * @return A string that represents the name of this token.
     */
    String getName();

    /**
     * @return A string representing the URI of this token.
     */
    String getItemURI();
}
