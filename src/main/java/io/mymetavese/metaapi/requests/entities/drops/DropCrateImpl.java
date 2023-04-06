package io.mymetavese.metaapi.requests.entities.drops;

import io.mymetavese.metaapi.api.entities.Item;
import io.mymetavese.metaapi.api.entities.drops.DropCrate;
import io.mymetavese.metaapi.api.entities.drops.DropCrateType;
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
    private final List<Item> tokensInCrate;
    private final DropCrateType type;

}
