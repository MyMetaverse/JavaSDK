package io.mymetavese.metaapi.requests;

import lombok.Getter;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Route {

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
        String fullRoute = route;

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
