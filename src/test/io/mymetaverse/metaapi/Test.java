package io.mymetaverse.metaapi;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.entities.GameEntity;
import io.mymetavese.metaapi.requests.token.StaticToken;
import io.mymetavese.metaapi.requests.token.TokenHandler;

public class Test {

    public static void main(String[] args) {

        //TokenHandler tokenHandler = OAuthToken.create("60a6be577a0ef3d457ba449f", "ZyOJhrdaFPznsHFhhwhLDVEWT0740Tjq");
        TokenHandler tokenHandler = StaticToken.create("945303c6-aa4f-4bc6-947f-e7669a9525ee");
        MetaAPI metaAPI = MetaAPI.Builder.createBuilder()
                .useApiV2()
                .withTokenHandler(tokenHandler)
                .build();


        GameEntity gameEntity = metaAPI.buildPlayer("55746d4b-26f9-4f33-80c1-763b63efa66c");

        //gameEntity.createLinkingLink().queue(System.out::println, System.out::println);
        gameEntity.getLinkingLink().queue(System.out::println, System.out::println);

    }


}
