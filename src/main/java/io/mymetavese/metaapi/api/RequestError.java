package io.mymetavese.metaapi.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RequestError extends Throwable {

    private final int code;

    @Getter
    private final String error;

    public int code() {
        return code;
    }

    @Override
    public String getMessage() {
        return error;
    }

    @Override
    public String toString() {
        return "RequestError{" +
                "code=" + code +
                ", error='" + error + '\'' +
                '}';
    }
}
