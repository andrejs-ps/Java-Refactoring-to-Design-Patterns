package com.statshelper;

import java.nio.file.Paths;
import java.util.*;

import static com.statshelper.helpers.HelperUtils.*;
import static java.util.Collections.reverseOrder;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.*;

public class ConditionalComplexityToStrategyBefore {

    /**
     * supply an argument to the program - either 'all' or 'nostopwords' or 'nonumbers'
     */
    public static void main(String[] args) {

        String content = readFile(Paths.get("text-stats/src/main/resources/design_patterns.txt"));
        List<String> words = tokenize(content);


        Map<String, Long> wordsFrequency;
        String filterCriteria = args[0];

        if (filterCriteria.equalsIgnoreCase("all")) {
            wordsFrequency = words.stream()
                    .map(String::toLowerCase)
                    .collect(groupingBy(w -> w, counting()));

        } else if (filterCriteria.equalsIgnoreCase("nostopwords")) {
            wordsFrequency = words.stream()
                    .map(String::toLowerCase)
                    .filter(word -> !getStopWords().contains(word))
                    .collect(groupingBy(w -> w, counting()));

        } else if (filterCriteria.equalsIgnoreCase("nonumbers")) {
            wordsFrequency = words.stream()
                    .map(String::toLowerCase)
                    .filter(word -> !isNumeric(word))
                    .collect(groupingBy(w -> w, counting()));
        } else {
            throw new IllegalArgumentException("Unsupported argument:" + filterCriteria);
        }

        Map<String, Long> sorted = sortDescending(wordsFrequency);
        System.out.println(sorted);

    }

    private static Map<String, Long> sortDescending(Map<String, Long> stringFrequencyMap) {
        return stringFrequencyMap.entrySet()
                .stream()
                .sorted(reverseOrder(comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey,
                                Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
    }
}
