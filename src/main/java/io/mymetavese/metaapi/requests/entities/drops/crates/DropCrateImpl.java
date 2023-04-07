package io.mymetavese.metaapi.requests.entities.drops.crates;

import com.google.gson.annotations.SerializedName;
import io.mymetavese.metaapi.api.entities.drops.crates.DropCrate;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class DropCrateImpl implements DropCrate {

    private final String id;
    private final String name;
    private final int totalSupply;
    private final int availableSupply;

    @SerializedName("tokens")
    private final List<DropCrateItemImpl> tokensInCrate;

    private final DropCrateTypeImpl type;

    @Override
    public List<DropCrateItemImpl> getTokensInCrate() {
        return this.tokensInCrate;
    }

}
