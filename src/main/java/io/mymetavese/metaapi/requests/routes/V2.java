package io.mymetavese.metaapi.requests.routes;

import io.mymetavese.metaapi.requests.Route;

import java.util.HashMap;

import static io.mymetavese.metaapi.requests.Method.GET;

public class V2 extends RouteAdapter {


    public V2() {
        super("http://localhost:8080", new HashMap<>());

        //this.routes.put("LINK_PLAYER", );
        this.routes.put("GET_WALLET", new Route(GET, "/users/{user}/wallet"));
        this.routes.put("GET_ETH_ADDRESS", new Route(GET, "/users/{user}/ethereum-address"));
    }


}
