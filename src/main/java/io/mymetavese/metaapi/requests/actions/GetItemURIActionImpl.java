package io.mymetavese.metaapi.requests.actions;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import io.mymetavese.metaapi.API;
import io.mymetavese.metaapi.api.actions.GetItemURIAction;
import io.mymetavese.metaapi.api.entities.Item;
import io.mymetavese.metaapi.api.entities.ItemURI;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.Route;
import io.mymetavese.metaapi.requests.entities.ItemURIImpl;
import okhttp3.Response;

import java.util.Objects;

public class GetItemURIActionImpl extends RestActionImpl<ItemURI> implements GetItemURIAction {

    private final Item item;

    public GetItemURIActionImpl(API api, Item item) {
        super(api, Route.EnjinX.GET_TOKEN_URI);
        // TODO: Add the query to the request body.
        this.item = item;
    }

    @Override
    protected String compileRoute() {
        return route.getRoute();
    }

    @Override
    public ItemURI transform(Response response) throws JsonSyntaxException {
        if (response == null || response.body() == null)
            throw new NullPointerException("Response cannot be null.");

        JsonElement jsonParsedResponse = JsonParser.parseReader(Objects.requireNonNull(response.body()).charStream());
        return new ItemURIImpl(jsonParsedResponse);

    }

}
