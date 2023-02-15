package io.mymetavese.metaapi.requests.entities.p2e;

import io.mymetavese.metaapi.api.entities.p2e.P2EProfileId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class P2EProfileIdImpl implements P2EProfileId {

    private final String id;
    private final String net;

}
