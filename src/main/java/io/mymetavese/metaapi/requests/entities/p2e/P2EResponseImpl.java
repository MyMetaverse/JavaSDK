package io.mymetavese.metaapi.requests.entities.p2e;

import io.mymetavese.metaapi.api.entities.p2e.P2EResponse;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class P2EResponseImpl implements P2EResponse {

    private final P2EProfileIdImpl profileId;
    private final int balance;

}
