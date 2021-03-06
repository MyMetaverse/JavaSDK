package io.mymetavese.metaapi.api;

import io.mymetavese.metaapi.MetaAPIImpl;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public interface RestAction<T> {

    /**
     * The while MetaAPI object.
     * @return A MetaAPI object
     */
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
     * Submits a request for execution in asynchronous logic.
     *
     *
     * @param success The success callback from the request.
     */
    default void queue(Consumer<? super T> success) {
        queue(success, null);
    };

    /**
     * Submits a Request but in synchronous logic.
     *
     * @return The response of the Request.
     */
    T complete();

    /**
     * Submits a request for execution after some time delay.
     * @param time The time
     * @param timeUnit The unit to be used.
     * @param success The success callback..
     * @param failure The failure callback.
     */
    default void queueAfter(long time, TimeUnit timeUnit, Consumer<? super T> success, Consumer<? super RequestError> failure) {
        Runnable runnable = () -> queue(success, failure);
        ((MetaAPIImpl) getMetaAPI()).getScheduledExecutorService().schedule(runnable, time, timeUnit);
    }

    /**
     * Submits a request for execution after some time delay.
     * @param time The time
     * @param timeUnit The unit to be used.
     * @param success The success callback..
     */
    default void queueAfter(long time, TimeUnit timeUnit, Consumer<? super T> success) {
        queueAfter(time, timeUnit, success, null);
    }
}
