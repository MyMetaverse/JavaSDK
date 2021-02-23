package io.mymetavese.metaapi.requests;

import com.google.gson.Gson;
import io.mymetavese.metaapi.API;
import io.mymetavese.metaapi.MetaAPI;
import io.mymetavese.metaapi.api.RestAction;
import io.mymetavese.metaapi.api.entities.Error;
import io.mymetavese.metaapi.requests.entities.ErrorImpl;
import okhttp3.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public abstract class RestActionImpl<T> extends Transformable<T> implements RestAction<T> {

    private final API api;

    protected final Route route;

    private final JsonObject requestBody;

    private Map<String, String> extraHeaders;

    public RestActionImpl(API api, Route route) {
        this.route = route;
        this.api = api;
        this.requestBody = buildBody(JsonObject.JsonObjectBuilder.newBuilder().create());
    }

    protected String compileRoute() {
        return route.compileRoute();
    }

    protected JsonObject buildBody(JsonObject body) {
        return null;
    }

    public void addHeader(String header, String data) {
        if(extraHeaders == null)
            extraHeaders = new HashMap<>();

        extraHeaders.put(header, data);
    }

    public void handleSuccess(Request<T> request, Response response) {
        request.onSuccess(transform(response));
    }

    public void handleFailure(Request<T> request, Response badResponse) {
        Gson gson = new Gson();
        request.onFailure(new ErrorImpl(badResponse.code(), gson.fromJson(Objects.requireNonNull(badResponse.body()).charStream(), ErrorImpl.class).getMessage()));
    }

    @Override
    public CompletableFuture<T> submit() {
        return null;
    }

    @Override
    public void queue(Consumer<? super T> success, Consumer<Error> failure) {
        Request<T> request = new Request<>(this, compileRoute(), route, requestBody, extraHeaders, success, failure);
        api.getRequestGenerator().request(request); // TODO: Change this to a general created obj
    }

    @Override
    public T complete() {
        return null;
    }

}

