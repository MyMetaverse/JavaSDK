package io.mymetavese.metaapi.requests.actions.Metadata;

import com.google.gson.Gson;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.Metadata.FetchTokenAction;
import io.mymetavese.metaapi.api.entities.Metadata.TokenMetadata;
import io.mymetavese.metaapi.api.entities.Token;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.entities.Metadata.TokenMetadataImpl;
import io.mymetavese.metaapi.requests.routes.Routes;
import okhttp3.Response;

import java.util.Objects;

public class FetchTokenActionImpl extends RestActionImpl<TokenMetadata> implements FetchTokenAction {

    private final Token token;

    public FetchTokenActionImpl(MetaAPI api, Token token) {
        super(api, Routes.GET_TOKEN_METADATA, TokenMetadataImpl.class);
        this.token = token;
    }

    @Override
    protected String compileRoute() {
        return route.compileRoute(token.getID(), token.getIndex());
    }

    @Override
    public TokenMetadata transform(Response response) {

        if (response == null || response.body() == null) {
            throw new NullPointerException("Response cannot be null");
        }

        Gson gson = new Gson();
        return gson.fromJson(Objects.requireNonNull(response.body()).charStream(), TokenMetadataImpl.class);

    }

}
