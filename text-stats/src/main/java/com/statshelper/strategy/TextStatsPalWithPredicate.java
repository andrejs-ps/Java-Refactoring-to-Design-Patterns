package com.statshelper.strategy;

import java.util.*;
import java.util.function.Predicate;
import static com.statshelper.helpers.HelperUtils.getStopWords;
import static com.statshelper.helpers.HelperUtils.isNumeric;
import static java.util.stream.Collectors.*;

public class TextStatsPalWithPredicate {

    public Map<String, Long> countWords(List<String> list) {
        return list.stream()
                .map(String::toLowerCase)
                .collect(groupingBy(w -> w, counting()));
    }

    public Map<String, Long> countWords(List<String> list, Collection<Predicate<String>> filters) {

        Predicate<String> allFilters = filters.stream().reduce(Predicate::and).orElse(x -> true);

        return list.stream()
                .map(String::toLowerCase)
                .filter(allFilters)
                .collect(groupingBy(w -> w, counting()));
    }

    private static final Map<String, Predicate<String>> FILTERS = Map.of(

            "no_stop_words", word -> !getStopWords().contains(word),
            "no_numbers", word -> !isNumeric(word)
    );

    /**
     * If a user inputs no_stop_words, then get the corresponding Predicate from the map
     */
    public static List<Predicate<String>> mapUserInputToFilters(String[] args) {
        List<String> userInput =  Arrays.asList(args);
        Set<String> mapKeys = FILTERS.keySet();
        return mapKeys
                .stream()
                .filter(k -> userInput.stream().anyMatch(mapKeys::contains))
                .map( k -> FILTERS.get(k))
                .collect(toList());
    }

    // Enum alternative to the Map above
    public enum WordFilterCriteria {

        NO_STOP_WORDS(word -> !getStopWords().contains(word)),
        NO_NUMBERS(word -> !isNumeric(word));

        private final Predicate<String> wordFilter;

        WordFilterCriteria(Predicate<String> wordFilter) {
            this.wordFilter = wordFilter;
        }

        public Predicate<String> get(){
            return wordFilter;
        }
    }

    // Plain constant pool alternative to the Map above
    public static class WordFilterCriteria2 {
        public static final Predicate<String> NO_STOP_WORDS = word -> !getStopWords().contains(word);
        public static final Predicate<String> NO_NUMBERS = word -> !isNumeric(word);
    }

}
