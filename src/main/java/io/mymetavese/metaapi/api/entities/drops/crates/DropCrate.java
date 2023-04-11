package io.mymetavese.metaapi.api.entities.drops.crates;

import io.mymetavese.metaapi.requests.entities.drops.crates.DropCrateItemImpl;

import java.util.List;

public interface DropCrate {

    /**
     * Obtain the ID of the crate
     * @return The ID of the crate
     */
    String getId();

    /**
     * Obtain the name of the crate
     * @return The name of the crate
     */
    String getName();

    /**
     * Get the total supply for this crate
     * <p>
     * Get the total number of tokens that will be distributed in this crate.
     * @return The total supply of tokens in this crate
     */
    int getTotalSupply();

    /**
     * Get the number of tokens available in this crate
     * <p>
     * Get the number of tokens that are still available in this crate.
     * @return The number of tokens available in this crate
     */
    int getAvailableSupply();

    /**
     * Get the tokens available in this crate
     * <p>
     * Get the tokens (its Ids and Indexes) available in this crate.
     *
     * @return The tokens available in this crate
     */
    List<DropCrateItemImpl> getTokensInCrate();

    /**
     * Get the type of this crate
     * @return The type of this crate
     */
    DropCrateType getType();

}
