package io.mymetavese.metaapi.requests.actions;

import io.mymetavese.metaapi.api.actions.EthAddressAction;
import okhttp3.Response;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class EthAddressActionImpl implements EthAddressAction {

    @Override
    public CompletableFuture<String> submit() {
        return null;
    }

    @Override
    public void queue(Consumer<? super String> success, Consumer<Response> failure) {

    }

    @Override
    public String complete() {
        return null;
    }

}
