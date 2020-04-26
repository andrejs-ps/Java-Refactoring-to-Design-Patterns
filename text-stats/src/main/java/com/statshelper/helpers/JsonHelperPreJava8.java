package com.statshelper.helpers;

import java.util.ArrayList;
import java.util.List;

public class JsonHelperPreJava8 {


    /**
     * Accepts a Json String and extracts definitions from lines prefixed with "definition"
     * @param json properly formatted Json String
     * @return a list of definitions
     */
    public static List<String> extractDefinitions(String json) {

        List<String> defs = new ArrayList<>();

        for (String line : json.split("\\n")) {
            if (line.contains("definition") &&
                    line.substring(line.lastIndexOf(":")+ 3).trim().length() > 3) {
                String def = line.substring(line.lastIndexOf(":") + 3, line.length() - 2);
                defs.add(def);
            }
        }

        return defs.isEmpty() ? List.of("Nothing found") : defs;
    }
}
