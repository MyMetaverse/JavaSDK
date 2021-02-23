package io.mymetavese.metaapi.api.entities;

import io.mymetavese.metaapi.api.actions.EthAddressAction;
import io.mymetavese.metaapi.api.actions.WalletAction;

public interface Player {

    WalletAction fetchWallet();

    EthAddressAction fetchEthAddress();

}
