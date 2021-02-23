package io.mymetavese.metaapi.requests.entities;

import io.mymetavese.metaapi.api.entities.Error;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ErrorImpl implements Error {

    private final int code;

    @Getter
    private final String error;

    @Override
    public int code() {
        return code;
    }

    @Override
    public String getMessage() {
        return error;
    }

    @Override
    public String toString() {
        return "ErrorImpl{" +
                "code=" + code +
                ", error='" + error + '\'' +
                '}';
    }
}
