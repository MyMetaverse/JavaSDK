package io.mymetavese.metaapi.requests.entities;

import io.mymetavese.metaapi.api.entities.v2.TransferableItemsList;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TransferableItemsListImpl implements TransferableItemsList {

    @Getter
    private final List<WalletItemImpl> initiatorWallet;

    @Getter
    private final List<WalletItemImpl> receiverWallet;

}
