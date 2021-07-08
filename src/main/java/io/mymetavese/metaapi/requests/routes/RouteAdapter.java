package io.mymetavese.metaapi.requests.routes;

import io.mymetavese.metaapi.requests.Route;
import lombok.Getter;

import java.util.Map;

public abstract class RouteAdapter {

    protected final Map<String, Route> routes;

    @Getter
    private final String baseUrl;

    public RouteAdapter(String baseUrl, Map<String, Route> routes) {
        this.routes = routes;
        this.baseUrl = baseUrl;
    }

    public Route getRoute(Routes route) {
        Route foundRoute = this.routes.get(route.toString());
        if(foundRoute == null)
            throw new NullPointerException("The route you are trying to reach is not registered.");
        return foundRoute;
    }

}
