package io.mymetavese.metaapi.requests.actions.drops;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.drops.GetDropAction;
import io.mymetavese.metaapi.api.entities.drops.constraints.DropConstraint;
import io.mymetavese.metaapi.api.entities.drops.MetaDrop;
import io.mymetavese.metaapi.api.entities.drops.requirements.DropEntryRequirement;
import io.mymetavese.metaapi.requests.custom_deserializers.DropConstraintDeserializer;
import io.mymetavese.metaapi.requests.custom_deserializers.DropEntryRequirementDeserializer;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.entities.drops.MetaDropImpl;
import io.mymetavese.metaapi.requests.routes.Routes;
import okhttp3.Response;

import java.io.IOException;
import java.io.Reader;
import java.util.Objects;

public class GetDropActionImpl extends RestActionImpl<MetaDrop> implements GetDropAction {

    String dropId;

    public GetDropActionImpl(MetaAPI api, String dropId) {
        super(api, Routes.GET_DROP, MetaDropImpl.class);
        this.dropId = dropId;
    }

    @Override
    protected String compileRoute() {
        return route.compileRoute(this.dropId);
    }

    @Override
    public MetaDrop transform(Response response) {

        if (response == null || response.body() == null) {
            throw new NullPointerException("Response cannot be null");
        }

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(DropEntryRequirement.class, new DropEntryRequirementDeserializer())
                .registerTypeAdapter(DropConstraint.class, new DropConstraintDeserializer())
                .create();

        try (Reader reader = Objects.requireNonNull(response.body()).charStream()) {
            return gson.fromJson(reader, MetaDropImpl.class);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;

    }


}
