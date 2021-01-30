package io.mymetavese.metaapi.requests;

import okhttp3.Response;

public abstract class Transformable<T> {

    public abstract T transform(Response response);

}
