package io.mymetaverse.metaapi;

import io.mymetavese.metaapi.requests.Route;
import io.mymetavese.metaapi.requests.routes.RouteAdapter;

import java.util.HashMap;

import static io.mymetavese.metaapi.requests.Method.GET;
import static io.mymetavese.metaapi.requests.Method.POST;

public class LocalV2 extends RouteAdapter {


    public LocalV2() {
        //super("https://devcloud.mymetaverse.io/adopters", new HashMap<>());
        super("http://127.0.0.1:8080", new HashMap<>());

        //this.routes.put("LINK_PLAYER", );
        this.routes.put("GET_WALLET", new Route(GET, "/{user}/wallet"));
        this.routes.put("GET_ETH_ADDRESS", new Route(GET, "/{user}/ethereum-address"));

        this.routes.put("CREATE_LINKING_LINK", new Route(POST, "/{user}/linking-link"));
        this.routes.put("GET_LINKING_LINK", new Route(GET, "/{user}/linking-link"));

    }


}
