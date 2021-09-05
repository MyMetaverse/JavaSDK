package io.mymetavese.metaapi.requests.entities;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.v2.DeleteTokenIndexProperty;
import io.mymetavese.metaapi.api.actions.v2.UpdateTokenIndexProperty;
import io.mymetavese.metaapi.api.entities.v2.IndexProperty;
import io.mymetavese.metaapi.requests.actions.v2.DeleteTokenIndexPropertyImpl;
import io.mymetavese.metaapi.requests.actions.v2.UpdateTokenIndexPropertyImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

import java.lang.reflect.Type;

@AllArgsConstructor
@Data
public class IndexPropertyImpl implements IndexProperty {

    @Getter @NonNull
    MetaAPI metaAPI;

    @Getter
    WalletIndexImpl walletIndex;

    @Getter
    String name;

    @Getter
    boolean hidden;

    @Getter
    String raw;

    @Getter
    JsonElement value;

    @Override
    public UpdateTokenIndexProperty updateValue(Object value) {
        return new UpdateTokenIndexPropertyImpl(metaAPI, walletIndex, this, value);
    }

    @Override
    public DeleteTokenIndexProperty updateValue() {
        return new DeleteTokenIndexPropertyImpl(metaAPI, walletIndex, this);
    }

    @Override
    public <T> T parse(Type type) {
        Gson gson = new Gson();
        return gson.fromJson(raw, type);
    }
}
