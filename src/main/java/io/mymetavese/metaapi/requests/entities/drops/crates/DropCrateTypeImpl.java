package io.mymetavese.metaapi.requests.entities.drops.crates;

import io.mymetavese.metaapi.api.entities.drops.crates.DropCrateType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class DropCrateTypeImpl implements DropCrateType {

    private final boolean perIndex;

}
