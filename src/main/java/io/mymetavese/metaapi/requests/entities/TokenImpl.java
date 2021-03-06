package io.mymetavese.metaapi.requests.entities;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.Metadata.UpdateTokenAchievementsAction;
import io.mymetavese.metaapi.api.actions.Metadata.UpdateTokenAction;
import io.mymetavese.metaapi.api.entities.Token;
import io.mymetavese.metaapi.requests.actions.Metadata.UpdateTokenAchievementsActionImpl;
import io.mymetavese.metaapi.requests.actions.Metadata.UpdateTokenActionImpl;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class TokenImpl implements Token {

    @Getter @Setter @NonNull
    private MetaAPI metaAPI;

    @Getter
    private final String ID;

    @Getter
    private final String index;

    @Getter
    private final int amount;

    @Override
    public UpdateTokenAchievementsAction createTokenAchievementsEditor() {
        return new UpdateTokenAchievementsActionImpl(metaAPI);
    }

    @Override
    public UpdateTokenAction createTokenEditor() {
        return new UpdateTokenActionImpl(metaAPI);
    }

}
