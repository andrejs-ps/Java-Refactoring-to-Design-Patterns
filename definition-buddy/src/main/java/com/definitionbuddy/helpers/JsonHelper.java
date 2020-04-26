package com.definitionbuddy.helpers;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class JsonHelper {

    /**
     * Accepts a Json String and extracts definitions from lines prefixed with "definition"
     * @param json properly formatted Json String
     * @return a list of definitions
     */
    public static List<String> extractDefinitions(String json) {

        Predicate<String> nonEmptyDefinition = line -> line.contains("definition") &&
                                               line.substring(line.lastIndexOf(":")+ 3).trim().length() > 3;

        Function<String, String> extractDefinition = line -> line.substring(line.lastIndexOf(":") + 3, line.length() - 2);

        List<String> defs =
                stream(json.split("\\n"))
                .filter(nonEmptyDefinition)
                .map(extractDefinition)
                .collect(toList());

        return defs.isEmpty() ? List.of("Nothing found") : defs;
    }
}
