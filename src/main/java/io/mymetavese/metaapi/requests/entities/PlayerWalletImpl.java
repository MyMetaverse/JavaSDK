package io.mymetavese.metaapi.requests.entities;

import io.mymetavese.metaapi.api.entities.PlayerWallet;
import io.mymetavese.metaapi.api.entities.v2.WalletItem;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Data
public class PlayerWalletImpl implements PlayerWallet {

    private final List<WalletItemImpl> centralizedItems;
    private final List<WalletItemImpl> lockedItems;
    private final Map<String, List<WalletItemImpl>> itemsInChains;

    @Override
    public List<? extends WalletItem> getEnjinWallet() {
        return itemsInChains.get("enjin");
    }

    @Override
    public List<? extends WalletItem> getMyMetaverseWallet() {
        return centralizedItems;
    }

    @Override
    public List<? extends WalletItem> getItemsByChain(String chain) {
        return itemsInChains.containsKey(chain) ? itemsInChains.get(chain) : Collections.emptyList();
    }

    @Override
    public List<? extends WalletItem> getCentralizedItems() {
        return centralizedItems;
    }

    @Override
    public List<WalletItem> getAllItems() {

        List<WalletItem> allItems = new ArrayList<>();

        allItems.addAll(centralizedItems);
        allItems.addAll(lockedItems);

        itemsInChains.forEach((chain, walletItems) -> allItems.addAll(walletItems));

        return allItems;

    }

}
