package io.mymetavese.metaapi.requests;

import io.mymetavese.metaapi.MetaAPI;
import io.mymetavese.metaapi.api.RestAction;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public abstract class RestActionImpl<T> extends Transformable<T> implements RestAction<T> {

    private final MetaAPI api;

    protected final Route route;

    private final RequestBody requestBody;

    private Map<String, String> extraHeaders;

    public RestActionImpl(MetaAPI api, Route route) {
        this(api, route, null);
    }

    public RestActionImpl(MetaAPI api, Route route, RequestBody requestBody) {
       this.route = route;
       this.requestBody = requestBody;
       this.api = api;
    }

    protected abstract String compileRoute();

    public void addHeader(String header, String data) {
        if(extraHeaders == null)
            extraHeaders = new HashMap<>();

        extraHeaders.put(header, data);
    }

    public void handleSuccess(Request<T> request, Response response) {
        request.onSuccess(transform(response));
    }

    public void handleFailure(Request<T> request, Response badResponse) {
        request.onFailure(badResponse);
    }

    @Override
    public CompletableFuture<T> submit() {
        return null;
    }

    @Override
    public void queue(Consumer<? super T> success, Consumer<Response> failure) {
        Request<T> request = new Request<>(this, compileRoute(), route, requestBody, extraHeaders, success, failure);
        api.getRequestGenerator().request(request); // TODO: Change this to a general created obj
    }

    @Override
    public T complete() {
        return null;
    }
}

