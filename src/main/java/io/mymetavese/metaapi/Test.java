package io.mymetavese.metaapi;

import io.mymetavese.metaapi.api.MetaAPI;
import io.mymetavese.metaapi.api.entities.EnjinWalletItem;
import io.mymetavese.metaapi.api.entities.GameEntity;
import io.mymetavese.metaapi.api.entities.Item;

public class Test {

    public static void main(String[] args) {

        MetaAPI metaAPIImpl = MetaAPI.Builder.createBuilder()
                .withToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6InJvbXIwMjA2MDZAZ21haWwuY29tIiwidXNlcklkIjoiNWY4NzczYWM5Njc1MDQ2MTM0YjlhNTYyIiwicm9sZSI6eyJuYW1lIjoiTW9kIiwiZ2FtZUlkIjoiNWY2MDI1ZGM0Yzg2Zjc3OGQ0NTNkYzk4In0sImlhdCI6MTYxMjAzOTM0N30.6Dy9oUxLL6t83gx0pUhTASIal4YA55ZUJDFwEytxhlw")
                .build();

        GameEntity gameEntity = metaAPIImpl.buildPlayer("55746d4b-26f9-4f33-80c1-763b63efa66c");


        gameEntity.fetchEthAddress().queue(System.out::println,
                requestError -> System.out.println(requestError.getLocalizedMessage()));

        gameEntity.fetchWallet().queue(playerWallet -> {
            for (Item item : playerWallet.getAllItems()) {
                if(item instanceof EnjinWalletItem)
                    System.out.println(((EnjinWalletItem) item).getName());
                System.out.println(item.getTokenId());
                System.out.println(item.getAmount());
                System.out.println(item.getTokenIndexes());
                System.out.println("=================================");
            }
        }, System.out::println);

    }

}
