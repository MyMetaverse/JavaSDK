package io.mymetavese.metaapi;

import io.mymetavese.metaapi.api.entities.Player;

public class Test {

    public static void main(String[] args) {
        MetaAPI metaAPI = MetaAPI.Builder.aMetaAPI()
                .withToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6InJvbXIwMjA2MDZAZ21haWwuY29tIiwidXNlcklkIjoiNWY4NzczYWM5Njc1MDQ2MTM0YjlhNTYyIiwicm9sZSI6eyJuYW1lIjoiTW9kIiwiZ2FtZUlkIjoiNWY2MDI1ZGM0Yzg2Zjc3OGQ0NTNkYzk4In0sImlhdCI6MTYxMjAzOTM0N30.6Dy9oUxLL6t83gx0pUhTASIal4YA55ZUJDFwEytxhlw")
                .build();

        Player player = metaAPI.buildPlayer("4de998c2-4179-44ac-aed4-a83467b4ec11");
        player.fetchWallet().queue(playerWallet -> {
            System.out.println(playerWallet.getAllItems());
        }, System.out::println);
    }

}
