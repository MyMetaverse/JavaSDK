package io.mymetavese.metaapi.api.actions.Metadata;

import io.mymetavese.metaapi.api.RestAction;
import io.mymetavese.metaapi.api.entities.Message;
import io.mymetavese.metaapi.api.entities.Metadata.TokenAchievement;

public interface UpdateTokenAchievementsAction extends RestAction<Message> {

    UpdateTokenAchievementsAction appendAchievementToEdit(TokenAchievement tokenAchievement);

}
