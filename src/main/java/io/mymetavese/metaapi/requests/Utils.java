package io.mymetavese.metaapi.requests;

import com.google.gson.Gson;
import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.requests.entities.TokenImpl;
import lombok.SneakyThrows;
import okhttp3.Response;

import java.lang.reflect.Field;
import java.util.Objects;

public class Utils {

    private final static Gson gson = new Gson();

    @SneakyThrows
    public static <T> T transformElement(Response response, Class<? extends T> as, MetaAPI metaAPI) {
        return gson.fromJson(Objects.requireNonNull(response.body()).charStream(), as);
    }
}
