package io.mymetavese.metaapi.requests.actions.drops;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.drops.GetAllDropsAction;
import io.mymetavese.metaapi.api.entities.drops.MetaDrop;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.routes.Routes;
import okhttp3.Response;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

public class GetAllDropsActionImpl extends RestActionImpl<List<MetaDrop>> implements GetAllDropsAction {

    public GetAllDropsActionImpl(MetaAPI api) {
        super(api, Routes.GET_ALL_DROPS);
    }

    @Override
    public List<MetaDrop> transform(Response response) {

        if (response == null || response.body() == null) {
            throw new NullPointerException("Response cannot be null");
        }

        Gson gson = new Gson();
        Type listOfMetaDropObjectsType = new TypeToken<List<MetaDrop>>() {}.getType();

        try (Reader reader = Objects.requireNonNull(response.body()).charStream()) {
            return gson.fromJson(reader, listOfMetaDropObjectsType);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;

    }

}
