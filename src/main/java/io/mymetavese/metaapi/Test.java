package io.mymetavese.metaapi;

import io.mymetavese.metaapi.requests.token.OAuthToken;
import io.mymetavese.metaapi.requests.token.TokenHandler;

public class Test {

    public static void main(String[] args) {

        TokenHandler tokenHandler = OAuthToken.create("60a6be577a0ef3d457ba449f", "ZyOJhrdaFPznsHFhhwhLDVEWT0740Tjq");

        System.out.println(tokenHandler.getToken());
        System.out.println(tokenHandler.getToken());
        System.out.println(tokenHandler.getToken());
        System.out.println(tokenHandler.getToken());
        System.out.println(tokenHandler.getToken());

    }


}
