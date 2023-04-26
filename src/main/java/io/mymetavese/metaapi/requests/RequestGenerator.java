package io.mymetavese.metaapi.requests;

import io.mymetavese.metaapi.MetaAPIImpl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.http.HttpMethod;

import java.io.IOException;

public class RequestGenerator {

    private static final RequestBody EMPTY_BODY = RequestBody.create(new byte[0]);
    public static final String USER_AGENT = "";
    private static final MediaType MEDIA_TYPE_JSON  = MediaType.get("application/json; charset=utf-8");

    private final OkHttpClient httpClient;
    private final MetaAPIImpl api;

    public RequestGenerator(MetaAPIImpl api, OkHttpClient okHttpClient) {
        this.httpClient = okHttpClient;
        this.api = api;
    }

    public void asyncRequest(Request<?> request) {
        api.getExecutorService().execute(() -> request(request));
    }

    public void request(Request<?> request) {

        String route = request.getCompiledRoute();

        okhttp3.Request.Builder builder = new okhttp3.Request.Builder();
        builder.url(api.getRouteAdapter().getBaseUrl() + route);

        String method = request.getMethod().toString();
        JsonObject bodyObject = request.getRequestBody();

        RequestBody body = null;

        if (bodyObject == null && HttpMethod.requiresRequestBody(method))
            body = EMPTY_BODY;
        else if(bodyObject != null)
            body = RequestBody.create(bodyObject.toJson(), MEDIA_TYPE_JSON);

        builder.method(method, body)
                .header("User-Agent", USER_AGENT)
                .header("Authorization", "Bearer " + api.getTokenHandler().getToken());


        if (request.getHeaders() != null && !request.getHeaders().isEmpty())
            request.getHeaders().forEach(builder::addHeader);


        try (Response response = httpClient.newCall(builder.build()).execute()) {

            if (response.code() >= 500) {
                String responseBodyString = response.peekBody(Long.MAX_VALUE).string();
                request.handleResponse(response);
                throw new IOException("Internal server error: " + responseBodyString);
            }

            // Try to Re-authenticate if the token is invalid and the re-authentication has not been attempted for more
            // than 2 times.
            if (response.code() == 401 && request.getAttempts() < 2) {

                request.addAttempt();
                api.getTokenHandler().authenticate();
                this.request(request);

            } else {
                request.handleResponse(response);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
