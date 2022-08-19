package io.mymetavese.metaapi.requests.entities.p2e;

import io.mymetavese.metaapi.api.entities.p2e.P2EResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class P2EResponseImpl implements P2EResponse {

    private final int profileId;
    private final int balance;

}
