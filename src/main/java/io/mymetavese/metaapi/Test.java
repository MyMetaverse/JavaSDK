package io.mymetavese.metaapi;

import io.mymetavese.metaapi.api.entities.Item;
import io.mymetavese.metaapi.api.entities.Player;

public class Test {

    public static void main(String[] args) {
        MetaAPI metaAPI = MetaAPI.Builder.aMetaAPI()
                .withToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6InJvbXIwMjA2MDZAZ21haWwuY29tIiwidXNlcklkIjoiNWY4NzczYWM5Njc1MDQ2MTM0YjlhNTYyIiwicm9sZSI6eyJuYW1lIjoiTW9kIiwiZ2FtZUlkIjoiNWY2MDI1ZGM0Yzg2Zjc3OGQ0NTNkYzk4In0sImlhdCI6MTYxMjAzOTM0N30.6Dy9oUxLL6t83gx0pUhTASIal4YA55ZUJDFwEytxhlw")
                .build();

        EnjinXAPI enjinXAPI = EnjinXAPI.Builder.aEnjinXAPI()
                .withToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiNWNhMWQ4YjdiYTg5N2MxYzczZTMyMjc5MjFjYTRmNGRhYTM4NGQ2ZDkxOGFkYTVkNzk2MjE3NzM4OTM2ODQ3ZjhmNGZjOTBkNzFjZGM4NGEiLCJpYXQiOjE2MTQwMjUwMzUsIm5iZiI6MTYxNDAyNTAzNSwiZXhwIjoxNjE0MTExNDM1LCJzdWIiOiI3MTgxNyIsInNjb3BlcyI6WyJhcGkiXX0.Fs3yINJ6uYPr59nkBuArY-JFfm-i7ee_QHdTFiK-0hvNyXIzSoqCYXQEFL09N-NcJ00aCUX569Cwonf92aFjea2Lf6Ic63NrDgaQnpfYf39Wtlrvb8SCWH3OKbe5JRszgET4F_JfPyj5eyi5DxdR05eqzqvMZYKIWTzAYsQ7CQLzaqUu_7OwTsffIu7aRpUN_3hjE1fvB9TuNGSC6PkAv7v2ObsiJwOhV13_r72ff5z2rtrbEu3o4llPaTUdekAzhSJEADS4ZrEs2TpDf8yWEj5b8nuHwgVAeGCol0W-lb_JAQT3KypRRpB-y1v0qg9lmC9sY5MqEYg4tY_YpYNmVKm5bdkHIhjjUL-4K4y9LLxkQOF1LrHIbrUSipj5H208BRo56dOCzulVqmZB-Cz1LgNypRcOJML2ITjE8OJZeVIjt6lutoFz__K08yJIcJouIlsELtYQQ-QVpf9cUScyfgBWfvlp9Ua3vghzG3QNQueYEkFfxO8q3gr-_GbxCi5F97Of33S-83VDEucrS3NmZ1HZl-gH6dU57z1PXw8k2TkrX2EAC2w1HgtSPVOj5Bzjy_XHGX6gLOZvpKuZlWsaihoFQgOBV2aPCuAdsdcNyUYfnDsiCrjAhHf7-bxOeSJrE1eB9AzeJa7Ab50dTlA5ahjg3gJDQ1MeMyXezvDhlTQ")
                .build();

        Player player = metaAPI.buildPlayer("ef62ea6e-bbe8-409e-82ec-cfff5d517599");
        Item itemBuilt = enjinXAPI.buildItem("70800000000003ad", "0000000000000039");

        itemBuilt.getItemURI().queue(System.out::println, System.out::println);

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
