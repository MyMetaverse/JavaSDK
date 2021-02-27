package io.mymetavese.metaapi.requests;

import com.google.gson.Gson;
import io.mymetavese.metaapi.api.MetaAPI;
import lombok.SneakyThrows;
import okhttp3.Response;

import java.lang.reflect.Field;
import java.util.Objects;

public class Utils {

    private final static Gson gson = new Gson();

    @SneakyThrows
    public static <T> T transformElement(Response response, Class<? extends T> as, MetaAPI metaAPI) {
        T element = gson.fromJson(Objects.requireNonNull(response.body()).charStream(), as);
        // If is an ApiImplementation this will fill the object with our api and only it doesn't has any API assigned.
        if (element instanceof ApiImplementation && ((ApiImplementation) element).getMetaAPI() == null)
            ((ApiImplementation) element).setMetaAPI(metaAPI);

        for (Field declaredField : element.getClass().getDeclaredFields()) {
            if (declaredField.getType().isAssignableFrom(ApiImplementation.class)) {
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }

                ApiImplementation apiImplementation = (ApiImplementation) declaredField.get(element);
                apiImplementation.setMetaAPI(metaAPI);
            }
        }
        return element;
    }
}
