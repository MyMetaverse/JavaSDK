package io.mymetavese.metaapi.requests.entities;

import com.google.gson.JsonElement;
import io.mymetavese.metaapi.api.entities.ItemURI;
import lombok.Getter;

public class ItemURIImpl implements ItemURI {

    @Getter
    private final String itemURI;

    public ItemURIImpl(JsonElement jsonElement) {
        System.out.println(jsonElement.toString());
        this.itemURI = jsonElement.getAsJsonObject().get("data")
                .getAsJsonObject().get("EnjinToken").getAsJsonObject().get("itemURI").getAsString();
    }

    @Override
    public String toString() {
        return "ItemURIImpl{" +
                "itemURI='" + itemURI + '\'' +
                '}';
    }

}
