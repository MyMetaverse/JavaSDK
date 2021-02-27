package io.mymetavese.metaapi.requests.actions.Metadata;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.Metadata.UpdateTokenAchievementsAction;
import io.mymetavese.metaapi.api.entities.Message;
import io.mymetavese.metaapi.api.entities.Metadata.TokenAchievement;
import io.mymetavese.metaapi.requests.JsonObject;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.Route;
import io.mymetavese.metaapi.requests.entities.MessageImpl;
import io.mymetavese.metaapi.requests.entities.Metadata.TokenAchievementImpl;

import java.util.ArrayList;
import java.util.List;

public class UpdateTokenAchievementsActionImpl extends RestActionImpl<Message> implements UpdateTokenAchievementsAction {

    private final List<TokenAchievementImpl> tokenAchievementList;

    public UpdateTokenAchievementsActionImpl(MetaAPI api) {
        super(api, Route.MetaData.UpdateTokenAchievements, MessageImpl.class);
        this.tokenAchievementList = new ArrayList<>();
    }

    @Override
    protected JsonObject buildBody(JsonObject body) {
        body.append("achievements", tokenAchievementList);
        return body;
    }

    @Override
    public UpdateTokenAchievementsAction appendAchievementToEdit(TokenAchievement tokenAchievement) {
        this.tokenAchievementList.add((TokenAchievementImpl) tokenAchievement);
        return this;
    }
}
