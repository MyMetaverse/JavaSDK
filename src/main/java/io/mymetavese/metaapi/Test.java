package io.mymetavese.metaapi;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.requests.token.OAuthToken;
import io.mymetavese.metaapi.requests.token.TokenHandler;

public class Test {

    public static void main(String[] args) {

        TokenHandler tokenHandler = OAuthToken.create("60a6be577a0ef3d457ba449f", "ZyOJhrdaFPznsHFhhwhLDVEWT0740Tjq");
        MetaAPI metaAPI = MetaAPI.Builder.createBuilder()
                .useApiV2()
                .withTokenHandler(tokenHandler)
                .build();


        System.out.println(tokenHandler.getToken());

        metaAPI.buildPlayer("ef62ea6e-bbe8-409e-82ec-cfff5d517599").fetchEthAddress().queue(s -> {
            System.out.println(s);
        }, error -> {
            System.out.println(error);
        });
    }


}
