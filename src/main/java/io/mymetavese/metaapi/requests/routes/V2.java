package io.mymetavese.metaapi.requests.routes;

import io.mymetavese.metaapi.requests.Route;

import java.util.HashMap;

import static io.mymetavese.metaapi.requests.Method.*;

public class V2 extends RouteAdapter {


    public V2() {

        super("https://cloud.mymetaverse.io/adopters", new HashMap<>());

        this.routes.put("GET_WALLET", new Route(GET, "/users/{userId}/wallet"));
        this.routes.put("GET_TRANSFERABLE_ITEMS", new Route(GET, "/users/{userId}/wallet/transferable/{receiverId}"));
        this.routes.put("GET_ETH_ADDRESS", new Route(GET, "/users/{userId}/ethereum-address"));

        this.routes.put("CREATE_LINKING_LINK", new Route(POST, "/users/{userId}/linking-link"));
        this.routes.put("GET_LINKING_LINK", new Route(GET, "/users/{userId}/linking-link"));

        this.routes.put("GET_TOKEN_METADATA", new Route(GET, "/tokens/{tokenId}/{index}.json"));
        this.routes.put("UPDATE_TOKEN_DETAILS", new Route(PUT, "/tokens/{tokenId}/"));
        this.routes.put("UPDATE_TOKEN_PROPERTY", new Route(POST, "/tokens/{tokenId}/{propertyName}"));
        this.routes.put("DELETE_TOKEN_PROPERTY", new Route(DELETE, "/tokens/{tokenId}/{propertyName}"));

        this.routes.put("UPDATE_TOKEN_INDEX_DETAILS", new Route(PUT, "/tokens/{tokenId}/indexes/{tokenIndex}"));
        this.routes.put("UPDATE_TOKEN_INDEX_PROPERTY", new Route(PUT, "/tokens/{tokenId}/indexes/{tokenIndex}/properties/{propertyName}"));
        this.routes.put("DELETE_TOKEN_INDEX_PROPERTY", new Route(DELETE, "/tokens/{tokenId}/indexes/{tokenIndex}/properties/{propertyName}"));

        this.routes.put("GET_ACTIVE_META_CITIZEN", new Route(GET, "/users/{userId}/wallet/metacitizen"));

        this.routes.put("GIVE_WHITELISTED_TOKEN", new Route(POST, "/tokens/{tokenId}/give"));

        this.routes.put("GET_P2E_POINTS", new Route(GET, "/users/{userId}/p2e/points"));
        this.routes.put("ADD_P2E_POINTS", new Route(POST, "/users/{userId}/p2e/points"));

        this.routes.put("GET_ALL_DROPS", new Route(GET, "/metadrops"));
        this.routes.put("GET_DROP", new Route(GET, "/metadrops/{dropId}"));
        this.routes.put("CONSUME_DROP", new Route(POST, "/metadrops/{dropId}/consume"));

    }

}
