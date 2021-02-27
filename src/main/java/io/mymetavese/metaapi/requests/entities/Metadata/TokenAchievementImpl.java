package io.mymetavese.metaapi.requests.entities.Metadata;

import io.mymetavese.metaapi.api.entities.Metadata.TokenAchievement;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TokenAchievementImpl implements TokenAchievement {

    private final String name;

    private final Object value;

}
