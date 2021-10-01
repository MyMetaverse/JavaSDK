package io.mymetavese.metaapi.requests.routes;

import io.mymetavese.metaapi.requests.Route;

import java.util.HashMap;

import static io.mymetavese.metaapi.requests.Method.GET;

public class MetadataAdapter extends RouteAdapter {

    public MetadataAdapter() {

        super("https://cloud.mymetaverse.io", new HashMap<>());

        this.routes.put("GET_TOKEN_METADATA", new Route(GET, "/token/{tokenID}/{tokenIndex}.json"));

    }

}
