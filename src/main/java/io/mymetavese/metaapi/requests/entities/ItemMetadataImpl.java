package io.mymetavese.metaapi.requests.entities;

import io.mymetavese.metaapi.MetaAPI;
import io.mymetavese.metaapi.api.entities.ItemMetadata;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public class ItemMetadataImpl implements ItemMetadata {

    private final MetaAPI api;

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String index;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private String image;

    public ItemMetadataImpl(MetaAPI api, String id, String index, String name, String description, String image) {
        this.api = api;
        this.id = id;
        this.index = index;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public ItemMetadataImpl(MetaAPI api, String id, String index) {
        this(api, id, index, null, null, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemMetadataImpl that = (ItemMetadataImpl) o;
        return id.equals(that.id) && index.equals(that.index) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, index, name, description, image);
    }

    @Override
    public String toString() {
        return "ItemMetadataImpl{" +
                "id='" + id + '\'' +
                ", index='" + index + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

}
