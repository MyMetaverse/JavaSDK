package io.mymetavese.metaapi.api.actions;

import io.mymetavese.metaapi.api.RestAction;
import io.mymetavese.metaapi.api.entities.PlayerWallet;

public interface WalletAction extends RestAction<PlayerWallet> {

    WalletAction playerToken(String playerID);

}
