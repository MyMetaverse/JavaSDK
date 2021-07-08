package io.mymetavese.metaapi.requests;

import com.google.gson.Gson;
import io.mymetavese.metaapi.FutureRestAction;
import io.mymetavese.metaapi.MetaAPIImpl;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.RequestError;
import io.mymetavese.metaapi.api.RestAction;
import io.mymetavese.metaapi.requests.routes.Routes;
import lombok.Getter;
import okhttp3.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public abstract class RestActionImpl<T> extends Transformable<T> implements RestAction<T> {

    @Getter
    private final MetaAPI metaAPI;

    protected final Route route;

    protected JsonObject requestBody;

    private final Class<? extends T> classToTransform;

    private Map<String, String> extraHeaders;

    public RestActionImpl(MetaAPI api, Routes route) {
        this(api, route, null);
    }

    public RestActionImpl(MetaAPI api, Routes route, Class<? extends T> classToTransform) {
        this.route = ((MetaAPIImpl) api).getRouteAdapter().getRoute(route);
        this.metaAPI = api;
        this.classToTransform = classToTransform;
    }

    protected String compileRoute() {
        return route.compileRoute();
    }

    /**
     * Create your 'global' request body.
     */
    protected void createRequestBody() {
        requestBody = JsonObject.JsonObjectBuilder.newBuilder().create();
    }

    protected JsonObject buildBody() {
        return null;
    }

    public void addHeader(String header, String data) {
        if (extraHeaders == null)
            extraHeaders = new HashMap<>();

        extraHeaders.put(header, data);
    }

    public void handleSuccess(Request<T> request, Response response) {
        request.onSuccess(transform(response));
    }

    public void handleFailure(Request<T> request, Response badResponse) {
        Gson gson = new Gson();
        RequestError requestError = gson.fromJson(Objects.requireNonNull(badResponse.body()).charStream(), RequestError.class);
        request.onFailure(requestError);
    }

    @Override
    public T transform(Response response) {
        if (classToTransform == null)
            throw new NullPointerException("Class to transform cannot be null.");

        if (response == null || response.body() == null)
            throw new NullPointerException("Response cannot be null");

        return Utils.transformElement(response, classToTransform, metaAPI);
    }

    @Override
    public CompletableFuture<T> submit() {
        return new FutureRestAction<>(metaAPI, this, compileRoute(), route, buildBody(), extraHeaders);
    }

    @Override
    public void queue(Consumer<? super T> success, Consumer<? super RequestError> failure) {
        Request<T> request = new Request<>(this, compileRoute(), route, buildBody(), extraHeaders, success, failure);
        ((MetaAPIImpl) metaAPI).getRequestGenerator().asyncRequest(request);
    }

    @Override
    public T complete() {
        return submit().join();
    }
}

