package io.mymetavese.metaapi.api;

import io.mymetavese.metaapi.api.entities.Player;
import io.mymetavese.metaapi.api.entities.Token;

public interface MetaAPI {

    Player buildPlayer(String playerID);

    Token buildToken(String id, String index);

}
