package io.mymetavese.metaapi.requests;

import io.mymetavese.metaapi.api.entities.Error;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import okhttp3.Response;

import java.util.Map;
import java.util.function.Consumer;

@Getter
@RequiredArgsConstructor
public class Request<T> {

    private final RestActionImpl<T> restAction;
    private final String url;
    private final Route route;
    private final JsonObject requestBody;
    private final Map<String, String> headers;

    private final Consumer<? super T> success;
    private final Consumer<Error> failure;

    public String getCompiledRoute() {
        return url;
    }

    public Method getMethod() {
        return route.getMethod();
    }

    public void onSuccess(T t) {
        success.accept(t);
    }

    public void onFailure(Error response) {
       failure.accept(response);
    }

    public void handleResponse(Response response) {

        if (response.code() == 200) {
            restAction.handleSuccess(this, response);
        } else {
            restAction.handleFailure(this, response);
        }

    }
}
