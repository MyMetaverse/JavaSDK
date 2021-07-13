package io.mymetavese.metaapi.requests.routes;

import io.mymetavese.metaapi.requests.Route;

import java.util.HashMap;

import static io.mymetavese.metaapi.requests.Method.GET;
import static io.mymetavese.metaapi.requests.Method.POST;

public class V2 extends RouteAdapter {


    public V2() {
        //super("https://devcloud.mymetaverse.io/adopters", new HashMap<>());
        super("http://127.0.0.1:8080", new HashMap<>());

        //this.routes.put("LINK_PLAYER", );
        this.routes.put("GET_WALLET", new Route(GET, "/users/{user}/wallet"));
        this.routes.put("GET_ETH_ADDRESS", new Route(GET, "/users/{user}/ethereum-address"));

        this.routes.put("CREATE_LINKING_LINK", new Route(POST, "/users/{user}/linking-link"));
        this.routes.put("GET_LINKING_LINK", new Route(GET, "/users/{user}/linking-link"));

    }


}
