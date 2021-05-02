package io.mymetavese.metaapi.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RequestError extends Throwable {

    @Getter
    private final String code;

    @Getter
    private final String message;

    @Getter
    private final String help;

    @Override
    public String toString() {
        return "RequestError{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", help='" + help + '\'' +
                '}';
    }

}
