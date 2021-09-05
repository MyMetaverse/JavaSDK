package io.mymetavese.metaapi.requests;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.mymetavese.metaapi.api.MetaAPI;
import lombok.SneakyThrows;
import okhttp3.Response;

import java.io.Reader;
import java.util.Objects;
import java.util.function.Function;

public class Utils {

    private final static Gson gson = new Gson();

    @SneakyThrows
    public static <T> T transformElement(Response response, Class<? extends T> as, MetaAPI metaAPI) {
        Reader reader = Objects.requireNonNull(response.body()).charStream();
        return gson.fromJson(reader, as);
    }

    public static  <T> T preventNull (JsonObject jsonObject, String k, Function<JsonElement, T> something, T t) {
        if (!jsonObject.has(k))
            return t;
        return something.apply(jsonObject.get(k));
    }

}
