package io.mymetavese.metaapi.api;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public interface RestAction<T> {

    MetaAPI getMetaAPI();

    /**
     * Submits a Request and provides the representation of the task in a {@link CompletableFuture}
     * @return A {@link CompletableFuture} representing the request.
     */
    CompletableFuture<T> submit();

    /**
     * Submits a request for execution in asynchronous logic.
     *
     *
     * @param success The success callback from the request.
     * @param failure The callback error from the request.
     */
    void queue(Consumer<? super T> success, Consumer<? super RequestError> failure);

    /**
     * Submits a Request but in synchronous logic.
     *
     * @return The response of the Request.
     */
    T complete();

}
