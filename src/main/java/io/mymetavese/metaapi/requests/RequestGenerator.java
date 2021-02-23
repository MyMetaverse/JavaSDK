package io.mymetavese.metaapi.requests;

import io.mymetavese.metaapi.MetaAPI;
import okhttp3.*;
import okhttp3.internal.http.HttpMethod;

import java.io.IOException;

public class RequestGenerator {

    private static final RequestBody EMPTY_BODY = RequestBody.create(new byte[0]);
    public static final String USER_AGENT = "";
    private static final MediaType MEDIA_TYPE_JSON  = MediaType.parse("application/json; charset=utf-8");

    private final OkHttpClient httpClient;
    private final MetaAPI api;

    public RequestGenerator(MetaAPI api, OkHttpClient okHttpClient) {
        this.httpClient = okHttpClient;
        this.api = api;
    }

    public void request(Request<?> request) {
        String route = request.getCompiledRoute();

        okhttp3.Request.Builder builder = new okhttp3.Request.Builder();
        builder.url(route);

        String method = request.getMethod().toString();
        JsonObject bodyObject = request.getRequestBody();

        RequestBody body = null;

        if (bodyObject == null && HttpMethod.requiresRequestBody(method))
            body = EMPTY_BODY;
        else if(bodyObject != null)
            body = RequestBody.create(MEDIA_TYPE_JSON, bodyObject.toJson());

        builder.method(method, body)
                .header("user-agent", USER_AGENT)
                .header("Authorization", "Bearer " + api.getToken());


        if (request.getHeaders() != null && !request.getHeaders().isEmpty())
            request.getHeaders().forEach(builder::addHeader);

            // Maybe should add attempts here.

        try(Response response = httpClient.newCall(builder.build()).execute()) {
            if (response.code() >= 500) {
                throw new IOException("Internal server error.");
            }

            request.handleResponse(response);
        } catch (IOException ex) {
            ex.printStackTrace();
        }





    }

}
