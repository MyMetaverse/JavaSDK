package io.mymetavese.metaapi.requests.token;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class StaticToken implements TokenHandler {

    @Getter
    private final String token;

    public static StaticToken create(String token) {
        return new StaticToken(token);
    }

}
