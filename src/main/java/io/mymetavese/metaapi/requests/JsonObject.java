package io.mymetavese.metaapi.requests;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JsonObject {
    private final Map<String, Object> mapper;

    private JsonObject() {
        this.mapper = new HashMap<>();
    }

    private JsonObject(JsonObject jsonObject) {
        this.mapper = jsonObject.mapper;
    }

    private Map<String, Object> getMapper(Map<String, Object> mapper, String[] children) {
        if (children.length == 0)
            return mapper;

        Map<String, Object> stringObjectMap = new HashMap<>();
        mapper.put(children[0], stringObjectMap);
        return getMapper(stringObjectMap, Arrays.copyOfRange(children, 1,children.length));
    }

    public JsonObject append(String key, Object value) {
        String[] children = key.split("\\.");

        if(children.length <= 1)
            mapper.put(key, value);
        else {
            String lastKey = children[children.length - 1];
            children = Arrays.copyOf(children, children.length - 1);
            Map<String, Object> t = getMapper(mapper, children);
            t.put(lastKey, value);
        }

        return this;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(mapper);
    }

    public static final class JsonObjectBuilder {
        private JsonObjectBuilder() {
        }

        public static JsonObjectBuilder newBuilder() {
            return new JsonObjectBuilder();
        }

        public static JsonObject from(JsonObject jsonObject) {
            return new JsonObject(jsonObject);
        }

        public JsonObject create() {
            return new JsonObject();
        }
    }
}
