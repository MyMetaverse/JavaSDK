package io.mymetavese.metaapi.requests.token.oauth.scopes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public enum OAuthScope {

    WALLET_READ("wallet.read"),
    P2E_READ("p2e.read"),
    P2E_ADD("p2e.add"),
    LINKING_CREATE("linkinglink.create"),
    LINKING_READ("linkinglink.read");

    private final String scope;

}
