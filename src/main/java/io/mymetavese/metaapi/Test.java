package io.mymetavese.metaapi;

import io.mymetavese.metaapi.api.entities.Item;
import io.mymetavese.metaapi.api.entities.Player;

public class Test {

    public static void main(String[] args) {
        MetaAPI metaAPI = MetaAPI.Builder.aMetaAPI()
                .withToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6InJvbXIwMjA2MDZAZ21haWwuY29tIiwidXNlcklkIjoiNWY4NzczYWM5Njc1MDQ2MTM0YjlhNTYyIiwicm9sZSI6eyJuYW1lIjoiTW9kIiwiZ2FtZUlkIjoiNWY2MDI1ZGM0Yzg2Zjc3OGQ0NTNkYzk4In0sImlhdCI6MTYxMjAzOTM0N30.6Dy9oUxLL6t83gx0pUhTASIal4YA55ZUJDFwEytxhlw")
                .build();

        Player player = metaAPI.buildPlayer("5746d4b-26f9-4f33-80c1-763b63efa66c");

        player.fetchEthAddress().queue(System.out::println, System.out::println);

        player.fetchWallet().queue(playerWallet -> {
            for (Item item : playerWallet.getAllItems()) {
                System.out.println(item.getTokenId());
                System.out.println(item.getAmount());
                System.out.println("=================================");
            }
        }, System.out::println);

        player.fetchTrades(metaAPI.buildPlayer("00c36b81-001b-4a37-9b4d-707dcd9930b3")).queue(tradeableItemsList -> {
            System.out.println(tradeableItemsList.toString());
        }, System.out::println);
    }

}
