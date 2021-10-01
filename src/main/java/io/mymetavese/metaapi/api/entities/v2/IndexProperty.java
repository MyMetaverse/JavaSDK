package io.mymetavese.metaapi.api.entities.v2;

import com.google.gson.JsonElement;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.v2.DeleteTokenIndexProperty;
import io.mymetavese.metaapi.api.actions.v2.UpdateTokenIndexProperty;

import java.lang.reflect.Type;

public interface IndexProperty {

    MetaAPI getMetaAPI();

    WalletIndex getWalletIndex();

    String getName();

    boolean isHidden();

    String getRaw();

    JsonElement getValue();

    UpdateTokenIndexProperty updateValue(Object value);

    DeleteTokenIndexProperty updateValue();

    <T> T parse(Type type);

}
