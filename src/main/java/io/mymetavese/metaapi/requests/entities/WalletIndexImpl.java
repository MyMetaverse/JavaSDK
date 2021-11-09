package io.mymetavese.metaapi.requests.entities;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.GiveWhitelistedTokenAction;
import io.mymetavese.metaapi.api.actions.Metadata.FetchTokenAction;
import io.mymetavese.metaapi.api.actions.v2.DeleteTokenIndexProperty;
import io.mymetavese.metaapi.api.actions.v2.UpdateTokenIndexDetails;
import io.mymetavese.metaapi.api.actions.v2.UpdateTokenIndexProperty;
import io.mymetavese.metaapi.api.entities.v2.GameEntity;
import io.mymetavese.metaapi.api.entities.v2.IndexProperty;
import io.mymetavese.metaapi.api.entities.v2.WalletIndex;
import io.mymetavese.metaapi.api.entities.v2.WalletItem;
import io.mymetavese.metaapi.requests.actions.GiveWhitelistedTokenActionImpl;
import io.mymetavese.metaapi.requests.actions.Metadata.FetchTokenActionImpl;
import io.mymetavese.metaapi.requests.actions.v2.DeleteTokenIndexPropertyImpl;
import io.mymetavese.metaapi.requests.actions.v2.UpdateTokenIndexDetailsImpl;
import io.mymetavese.metaapi.requests.actions.v2.UpdateTokenIndexPropertyImpl;
import lombok.*;

import java.util.Map;

@RequiredArgsConstructor
@Data
public class WalletIndexImpl implements WalletIndex {

    @Getter @NonNull
    private MetaAPI metaAPI;

    @Getter
    private final String index;

    @Getter
    private final WalletItem baseNFT;

    @Override
    public Map<String, IndexProperty> getProperties() {
        return null;
    }

    @Override
    public Map<String, IndexProperty> getPrivateProperties() {
        return null;
    }

    @Override
    public UpdateTokenIndexProperty updateProperty(String property, boolean hidden, Object value) {
        return new UpdateTokenIndexPropertyImpl(metaAPI, this, property, hidden, value);
    }

    @Override
    public DeleteTokenIndexProperty deleteProperty(String property, boolean hidden) {
        return new DeleteTokenIndexPropertyImpl(metaAPI, this, property, hidden);
    }

    @Override
    public UpdateTokenIndexDetails updateDetails() {
        return new UpdateTokenIndexDetailsImpl(metaAPI, this);
    }

    @Override
    public FetchTokenAction fill() {
        return new FetchTokenActionImpl(metaAPI, this);
    }

    @Override
    public GiveWhitelistedTokenAction give(GameEntity receiverEntity) {
        return new GiveWhitelistedTokenActionImpl(metaAPI, this, receiverEntity);
    }

}
