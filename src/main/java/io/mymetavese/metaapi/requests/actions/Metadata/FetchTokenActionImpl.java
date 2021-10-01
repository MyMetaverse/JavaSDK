package io.mymetavese.metaapi.requests.actions.Metadata;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.actions.Metadata.FetchTokenAction;
import io.mymetavese.metaapi.api.entities.Metadata.TokenMetadata;
import io.mymetavese.metaapi.api.entities.v2.IndexProperty;
import io.mymetavese.metaapi.api.entities.v2.WalletIndex;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.Utils;
import io.mymetavese.metaapi.requests.entities.IndexPropertyImpl;
import io.mymetavese.metaapi.requests.entities.Metadata.TokenMetadataImpl;
import io.mymetavese.metaapi.requests.entities.WalletIndexImpl;
import io.mymetavese.metaapi.requests.routes.Routes;
import lombok.Getter;
import lombok.SneakyThrows;
import okhttp3.Response;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class FetchTokenActionImpl extends RestActionImpl<TokenMetadata> implements FetchTokenAction {

    private final WalletIndex walletIndex;

    public FetchTokenActionImpl(MetaAPI api, WalletIndex walletIndex) {
        super(api, Routes.GET_TOKEN_METADATA);
        this.walletIndex = walletIndex;
    }

    @Override
    protected String compileRoute() {
        return route.compileRoute(walletIndex.getBaseNFT().getTokenId(), walletIndex.getIndex());
    }

    @Override
    @SneakyThrows
    public TokenMetadata transform(Response response) {

        Gson gson = new Gson();
        String data = Objects.requireNonNull(response.body()).string();
        TokenMetadataBlueprint firstFill = gson.fromJson(data,
                TokenMetadataBlueprint.class);

        JsonObject secondFill = gson.fromJson(data, JsonObject.class);

        Set<IndexProperty> props = Utils.preventNull(secondFill, "properties", jsonElement ->
            jsonElement.getAsJsonObject().keySet().stream()
                    .map(keyName -> {
                        JsonElement el = jsonElement.getAsJsonObject().get(keyName);
                        return new IndexPropertyImpl(
                                this.getMetaAPI(),
                                (WalletIndexImpl) walletIndex,
                                keyName,
                                false,
                                gson.toJson(el),
                                el);
                            }
                    )
                    .collect(Collectors.toSet())
        , new HashSet<>());

        Set<IndexProperty> hiddenProps = Utils.preventNull(secondFill, "hiddenProperties", jsonElement ->
                        jsonElement.getAsJsonObject().keySet().stream()
                                .map(keyName -> {
                                    JsonElement el = jsonElement.getAsJsonObject().get(keyName);
                                    return new IndexPropertyImpl(
                                            this.getMetaAPI(),
                                            (WalletIndexImpl) walletIndex,
                                            keyName,
                                            true,
                                            gson.toJson(el),
                                            el);
                                        }
                                )
                                .collect(Collectors.toSet())
                , new HashSet<>());

        return new TokenMetadataImpl(
                firstFill.getName(),
                firstFill.getDescription(),
                firstFill.getImageURL(),
                firstFill.getTokenIndex(),
                props,
                hiddenProps
        );
    }

    @Getter
    private static class TokenMetadataBlueprint {
        private String name;
        private String description;
        private String imageURL;
        private String tokenIndex;

        private JsonElement properties;
        private JsonElement hiddenProperties;
    }

}
