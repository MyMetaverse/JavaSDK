package io.mymetavese.metaapi.api.actions.Metadata;

import io.mymetavese.metaapi.api.RestAction;
import io.mymetavese.metaapi.api.entities.Message;
import io.mymetavese.metaapi.api.entities.Metadata.TokenAchievement;

public interface UpdateTokenAchievementsAction extends RestAction<Message> {

    /**
     * Update the achievement of this token.
     * @param tokenAchievement A instance of a TokenAchievement with updated information.
     * @return The Action to continue the editing session.
     */
    UpdateTokenAchievementsAction appendAchievementToEdit(TokenAchievement tokenAchievement);

    /**
     * Update the achievement of this token.
     * @param name The name of the achievement
     * @param value The new value for this achievemnt.
     * @return The Action to continue the editing session.
     */
    default UpdateTokenAchievementsAction updateAchievemnt(String name, Object value) {
        return appendAchievementToEdit(new TokenAchievement() {
            @Override
            public String getName() {
                return name;
            }

            @Override
            public Object getValue() {
                return value;
            }
        });
    }

}
