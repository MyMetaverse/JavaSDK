package io.mymetavese.metaapi.requests.entities;

import io.mymetavese.metaapi.MetaAPI;
import io.mymetavese.metaapi.api.actions.EthAddressAction;
import io.mymetavese.metaapi.api.actions.WalletAction;
import io.mymetavese.metaapi.api.entities.Player;
import io.mymetavese.metaapi.requests.actions.EthAddressActionImpl;
import io.mymetavese.metaapi.requests.actions.WalletActionImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlayerImpl implements Player {
    @Getter
    private final MetaAPI api;

    @Getter
    private final String playerID;

    public WalletAction fetchWallet() {
        return new WalletActionImpl(api).playerToken(playerID);
    }

    @Override
    public EthAddressAction fetchEthAddress() {
        return new EthAddressActionImpl();
    }
}
