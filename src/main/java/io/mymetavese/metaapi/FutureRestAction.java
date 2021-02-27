package io.mymetavese.metaapi;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.requests.JsonObject;
import io.mymetavese.metaapi.requests.Request;
import io.mymetavese.metaapi.requests.RestActionImpl;
import io.mymetavese.metaapi.requests.Route;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class FutureRestAction<T> extends CompletableFuture<T> {
    public FutureRestAction(MetaAPI api, RestActionImpl<T> restAction, String compileRoute, Route route, JsonObject requestBody, Map<String, String> extraHeaders) {
        final Request<T> request = new Request<>(restAction, compileRoute, route, requestBody, extraHeaders, this::complete, this::completeExceptionally);
        ((MetaAPIImpl) api).getRequestGenerator().request(request);
    }

}
