package io.mymetaverse.metaapi;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.entities.v2.GameEntity;
import io.mymetavese.metaapi.api.entities.v2.IndexProperty;
import io.mymetavese.metaapi.requests.token.OAuthToken;
import io.mymetavese.metaapi.requests.token.TokenHandler;

public class Test {

    public static void main(String[] args) {

        TokenHandler tokenHandler = OAuthToken
                .create("6133b36dfd1c085cfd2c0bc9", "a9IJy2bSbxJ3KYYLuc1Vn9JJ0nIxbzQd");

        MetaAPI metaAPI = MetaAPI.Builder.createBuilder()
                .withTokenHandler(tokenHandler)
                .useApiV2()
                .build();


        GameEntity gameEntity = metaAPI.buildPlayer("ricardo");

        //gameEntity.createLinkingLink().queue(System.out::println, System.out::println);
        gameEntity.fetchWallet().queue(wallet -> {
            wallet.getAllItems().stream().filter(walletItem -> walletItem.getTokenId().equals("10")).findFirst().ifPresent(item -> {
                System.out.println(item);
                item.getTokenIndexes().stream().findFirst().ifPresent(index -> {
                    System.out.println(index);
                    item.getIndex(index).fill().queue(tokenMetadata -> {
                        for (IndexProperty property : tokenMetadata.getProperties()) {
                            System.out.println(property);

                            System.out.println(property.parse(Integer.class).toString());
                        }
                    });
                });
            });
        }, System.out::println);

    }


}
