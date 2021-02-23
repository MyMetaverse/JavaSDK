package io.mymetavese.metaapi.requests;

import lombok.Getter;
import sun.security.acl.AllPermissionsImpl;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.mymetavese.metaapi.requests.Method.GET;
import static io.mymetavese.metaapi.requests.Method.POST;

public class Route {

    private static final String API_ROUTE = "https://livewallet.mymetaverse.io";

    public static class LiveWallet {
        public static final Route LINK_PLAYER = new Route(POST, "/LiveWallet/LinkPlayer");
        public static final Route DEPOSIT = new Route(POST, "/LiveWallet/Deposit");
        public static final Route GET_TRADEABLE_ITEMS = new Route(GET, "/LiveWallet/Trade/GetTradeableItems/{InitiatorPlayerID}&{ReceiverPlayerID}");
        public static final Route SEND_TRADE_REQUEST = new Route(POST, "/LiveWallet/Trade/SendTradeRequest");
        public static final Route GET_ETH_ADDRESS = new Route(GET, "/LiveWallet/GetEthAddress/{PlayerID}");
        public static final Route GET_ITEMS = new Route(GET, "/LiveWallet/GetItems/{PlayerID}");
    }

    public static class MetaData {
        public static final Route EDIT_TOKEN = new Route(POST, "/api/Metadata/EditToken/{internalID}/{tokenIndex}");
        public static final Route UPDATE_TOKEN_ACHIEVEMENTS = new Route(POST, "/api/Metadata/UpdateTokenAchievements/{internalID}/{tokenIndex}");
    }

    public static class EnjinX {
        public static final Route GET_TOKEN_URI = new Route(GET, "https://cloud.enjin.io/graphql");
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
        String fullRoute = !route.startsWith("/") ? route : API_ROUTE + route;

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
