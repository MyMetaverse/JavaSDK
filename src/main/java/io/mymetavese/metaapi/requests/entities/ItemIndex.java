package io.mymetavese.metaapi.requests.entities;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.Metadata.UpdateTokenAchievementsAction;
import io.mymetavese.metaapi.api.actions.Metadata.UpdateTokenAction;
import io.mymetavese.metaapi.requests.actions.Metadata.UpdateTokenAchievementsActionImpl;
import io.mymetavese.metaapi.requests.actions.Metadata.UpdateTokenActionImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class ItemIndex {

    @Getter @Setter
    MetaAPI metaAPI;

    private final String index;


    public UpdateTokenAchievementsAction updateAchievements() {
        return updateAchievements(metaAPI);
    }

    public UpdateTokenAction updateToken() {
        return updateToken(metaAPI);
    }

    public UpdateTokenAchievementsAction updateAchievements(MetaAPI metaAPI) {
        return new UpdateTokenAchievementsActionImpl(metaAPI);
    }

    public UpdateTokenAction updateToken(MetaAPI metaAPI) {
        return new UpdateTokenActionImpl(metaAPI);
    }

    @Override
    public String toString() {
        return index;
    }
}
