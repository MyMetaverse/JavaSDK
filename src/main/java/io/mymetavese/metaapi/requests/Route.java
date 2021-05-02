package io.mymetavese.metaapi.requests;

import lombok.Getter;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.mymetavese.metaapi.requests.Method.*;

public class Route {

    private static final String API_ROUTE = "https://cloud.mymetaverse.io";

    public static class LiveWallet {
        public static final Route LINK_PLAYER = new Route(POST, "/LiveWallet/LinkPlayer");
        public static final Route DEPOSIT = new Route(POST, "/LiveWallet/Deposit");
        public static final Route GET_TRADEABLE_ITEMS = new Route(GET, "/LiveWallet/Trade/GetTradeableItems/{InitiatorPlayerID}&{ReceiverPlayerID}");
        public static final Route SEND_TRADE_REQUEST = new Route(POST, "/LiveWallet/Trade/SendTradeRequest");
        public static final Route GET_ETH_ADDRESS = new Route(GET, "/LiveWallet/GetEthAddress/{PlayerID}");
        public static final Route GET_ITEMS = new Route(GET, "/LiveWallet/GetItems/{PlayerID}");
        public static final Route CREATE_LINKING_LINK = new Route(POST, "/playerBehavior/createLinkingLink");
    }

    public static class MetaData {
        public static final Route EDIT_TOKEN = new Route(POST, "/api/Metadata/EditToken/{id}/{index}");
        public static final Route UPDATE_TOKEN_ACHIEVEMENTS = new Route(POST, "/api/Metadata/UpdateTokenAchievementsAction/{id}/{index}");
    }

    public static class MyMetaverse {
        public static final Route CREATE_LIVEWALLET = new Route(POST, "/MyMetaverse/CreateLiveWallet");
        public static final Route GET_GAMES_LINKING_CODES = new Route(GET, "/MyMetaverse/GetGamesLinkingCodes/{MyMetaverseID}");
        public static final Route UNLINK_LIVEWALLET_GAME = new Route(POST, "/MyMetaverse/UnlinkLiveWalletGame");
        public static final Route GET_LIVE_WALLET_STATUS = new Route(GET, "/MyMetaverse/GetLiveWalletStatus/{MyMetaverseID}");
        public static final Route UNLINK_ENJIN_WALLET = new Route(POST, "/MyMetaverse/UnlinkEnjinWallet");
        public static final Route SEND_ALLOWANCE_REQUEST = new Route(GET, "/MyMetaverse/SendAllowanceRequest/{MyMetaverseID}");
        public static final Route GET_ITEMS = new Route(GET, "/MyMetaverse/GetItems/{MyMetaverseID}");
        public static final Route GET_TRADE_REQUEST_INFO = new Route(GET, "/MyMetaverse/Trade/Requests/{TradeRequestID}&{MyMetaverseID}");
        public static final Route GET_TRADE_REQUESTS = new Route(GET, "/MyMetaverse/Trade/Requests/{MyMetaverseID}");
        public static final Route DECIDE_TRADE_REQUEST = new Route(POST, "/MyMetaverse/Trade/Requests/{TradeRequestID}&{MyMetaverseID}/Decide");
        public static final Route SEND_TRADE_REQUEST = new Route(POST, "/MyMetaverse/Trade/SendTradeRequest");
        public static final Route LINK_LIVEWALLET_TO_MOD = new Route(POST, "/MyMetaverse/LinkLiveWalletToModAccount/{MyMetaverseID}");
        public static final Route SYNC_ENJIN_WALLET_ITEMS = new Route(POST, "/MyMetaverse/SyncEnjinWalletItems");
        public static final Route REMOVE_DEV = new Route(DELETE, "/MyMetaverse/RemoveDev/{UserID}");
    }

    @Getter
    private final Method method;

    @Getter
    private final String route;

    private final int arguments;

    public Route(Method method, String route) {
        this.method = method;
        this.route = route;
        this.arguments = findArguments(route);
    }

    private String compileNextArgument(String route, String... args) {
        Matcher matcher = regex.matcher(route);
        String replacement = args[0].isEmpty() ? "undefined" : args[0];
        route = matcher.replaceFirst(replacement);

        if (args.length - 1 != 0) {
            return compileNextArgument(route, Arrays.copyOfRange(args, 1, args.length));
        } else {
            return route;
        }
    }

    public String compileRoute(String... args) {
        if(args.length < arguments) {
            throw new IllegalArgumentException("You are missing some arguments in this route.");
        }
        String fullRoute = API_ROUTE + route;

        if(arguments == 0)
            return fullRoute;

        return compileNextArgument(fullRoute, args);
    }

    private static final String pattern = "((\\{)(.+?)(}))";
    private static final Pattern regex = Pattern.compile(pattern);

    private int findArguments(String str) {
        int count = 0;
        Matcher matcher = regex.matcher(str);
        while (matcher.find()) count++;
        return count;
    }

}
