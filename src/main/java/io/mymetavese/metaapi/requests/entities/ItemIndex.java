package io.mymetavese.metaapi.requests.entities;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.Metadata.UpdateTokenAchievementsAction;
import io.mymetavese.metaapi.requests.actions.Metadata.UpdateTokenAchievementsActionImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ItemIndex {

    @Getter
    private final MetaAPI metaAPI;

    @Getter
    private final String index;

    public UpdateTokenAchievementsAction updateAchievements() {
        return new UpdateTokenAchievementsActionImpl(metaAPI);
    }

    @Override
    public String toString() {
        return index;
    }
}
