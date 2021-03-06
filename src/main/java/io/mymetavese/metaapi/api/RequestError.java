package io.mymetavese.metaapi.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RequestError extends Throwable {

    @Getter
    private final String code;

    @Getter
    private final String error;


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
