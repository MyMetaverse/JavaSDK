package io.mymetavese.metaapi.requests.entities.drops.crates;

import com.google.gson.annotations.SerializedName;
import io.mymetavese.metaapi.api.entities.drops.crates.DropCrateItem;
import io.mymetavese.metaapi.requests.entities.ItemIndex;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class DropCrateItemImpl implements DropCrateItem {

    @SerializedName("id")
    private final String tokenId;
    @SerializedName("indexes")
    private final List<String> tokenIndexes;

    @Override
    public boolean isNFT() {
        return true;
    }

    @Override
    public List<ItemIndex> getTokenIndexes() {
        return this.tokenIndexes.stream().map(s -> new ItemIndex(null, s))
                .collect(Collectors.toList());
    }

    @Override
    public int getAmount() {
        return this.tokenIndexes.size();
    }

}
