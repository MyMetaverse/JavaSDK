package io.mymetavese.metaapi.api.entities;

public interface ItemMetadata {

    String getId();

    String getIndex();

    String getName();

    String getDescription();

    String getImage();

    void setName(String name);

    void setDescription(String name);

    void setImage(String image);

}
