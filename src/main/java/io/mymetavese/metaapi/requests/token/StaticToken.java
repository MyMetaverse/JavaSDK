package io.mymetavese.metaapi.requests.token;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StaticToken implements TokenHandler {

    @Getter
    private final String token;

}
