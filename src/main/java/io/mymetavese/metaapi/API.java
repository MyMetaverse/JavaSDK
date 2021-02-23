package io.mymetavese.metaapi;

import io.mymetavese.metaapi.requests.RequestGenerator;
import okhttp3.OkHttpClient;

public interface API {

    String getToken();

    RequestGenerator getRequestGenerator();

    OkHttpClient getClient();

}
