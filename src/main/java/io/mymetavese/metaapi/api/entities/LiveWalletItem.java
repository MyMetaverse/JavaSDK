package io.mymetavese.metaapi.api.entities;

public interface LiveWalletItem extends Item {

    /**
     * Return if this items is locked.
     * <br />
     * <b>Note:</b> Use this with instanceof to prevent any further errors.
     * @return An object about the element locked, could be either String or Integer.
     */
    Object getLocked();

}
