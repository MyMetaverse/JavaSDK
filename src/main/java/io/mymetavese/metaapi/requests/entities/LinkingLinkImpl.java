package io.mymetavese.metaapi.requests.entities;

import io.mymetavese.metaapi.api.entities.LinkingLink;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LinkingLinkImpl implements LinkingLink {

    @Getter
    private final String status;

    @Getter
    private final String linkingLink;

    @Getter
    private final String linkId;

}
