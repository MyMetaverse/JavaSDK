package io.mymetavese.metaapi.api.entities;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.Metadata.UpdateTokenAchievementsAction;
import io.mymetavese.metaapi.api.actions.Metadata.UpdateTokenAction;

public interface Token {

    MetaAPI getMetaAPI();

    String getID();

    String getIndex();

    UpdateTokenAchievementsAction createTokenAchievementsEditor();

    UpdateTokenAction createTokenEditor();

}
