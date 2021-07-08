package io.mymetavese.metaapi.requests;

import io.mymetavese.metaapi.api.MetaAPI;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EntityBuilder {

    private final MetaAPI metaAPI;

//    public PlayerWallet createPlayerWallet(JsonObject jsonObject) {
//
//        List<LiveWalletItemImpl> liveWallet = new ArrayList<>();
//        for (JsonElement liveWalletElement : jsonObject.get("LiveWallet").getAsJsonArray()) {
//            JsonObject lw = liveWalletElement.getAsJsonObject();
//
//            List<ItemIndex> indexList = new ArrayList<>();
//
//            if (lw.has("token_indexes")) {
//                for (JsonElement token_indexesEl : lw.getAsJsonArray("token_indexes")) {
//                    indexList.add(new ItemIndex(metaAPI, token_indexesEl.getAsString()));
//                }
//            }
//
//            LiveWalletItemImpl liveWalletItem = new LiveWalletItemImpl(
//                    metaAPI,
//                    lw.get("token_id").getAsString(),
//                    indexList,
//                    lw.get("NFT").getAsBoolean(),
//                    lw.get("amount").getAsInt(),
//                    null
//            );
//
//            liveWallet.add(liveWalletItem);
//        }
//
//        JsonObject enjinWalletOb = jsonObject.get("EnjinWallet").getAsJsonObject();
//
//        List<LiveWalletItemImpl> enjinWalletItems = new ArrayList<>();
//
//        for (JsonElement itemsAsElement : enjinWalletOb.getAsJsonArray("items")) {
//            JsonObject itemAsJson = itemsAsElement.getAsJsonObject();
//
//
//            List<ItemIndex> indexList = new ArrayList<>();
//            if (itemAsJson.has("token_indexes")) {
//                for (JsonElement token_indexesEl : itemAsJson.getAsJsonArray("token_indexes")) {
//                    indexList.add(new ItemIndex(metaAPI, token_indexesEl.getAsString()));
//                }
//            }
//
//            LiveWalletItemImpl enjinWalletItem = new LiveWalletItemImpl(
//                    metaAPI,
//                    itemAsJson.get("token_id").getAsString(),
//                    indexList,
//                    itemAsJson.get("NFT").getAsBoolean(),
//                    itemAsJson.get("amount").getAsInt(),
//                    //itemAsJson.get("name").getAsString(),
//                    itemAsJson.has("ItemURI") ? jsonObject.get("ItemURI").getAsString() : null
//            );
//
//            enjinWalletItems.add(enjinWalletItem);
//        }
//
//        EnjinWalletImpl enjinWallet = new EnjinWalletImpl(metaAPI, enjinWalletOb.get("address").getAsString(), enjinWalletItems);
//        return new PlayerWalletImpl(liveWallet, enjinWallet);
//    }

}
