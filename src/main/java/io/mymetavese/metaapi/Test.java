package io.mymetavese.metaapi;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.entities.GameEntity;

public class Test {

    public static void main(String[] args) {

        MetaAPI meta = MetaAPI.Builder.createBuilder()
                .build();

        GameEntity player = meta.buildPlayer("55746d4b-26f9-4f33-80c1-763b63efa66c");

        player.createLinkingLink().queue(linkingLink -> {
            System.out.println(linkingLink.getLinkingLink());
        }, System.out::println);
    }


}
