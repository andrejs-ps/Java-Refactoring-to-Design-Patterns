package com.statshelper;

import com.statshelper.strategy.NoStopWords;
import com.statshelper.strategy.TextStatsPalWithPredicate;
import com.statshelper.strategy.TextStatsPalWithStrategy;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static com.statshelper.helpers.HelperUtils.*;
import static com.statshelper.strategy.TextStatsPalWithPredicate.WordFilterCriteria2.NO_NUMBERS;
import static com.statshelper.strategy.TextStatsPalWithPredicate.WordFilterCriteria2.NO_STOP_WORDS;
import static com.statshelper.strategy.TextStatsPalWithPredicate.mapUserInputToFilters;

public class ConditionalComplexityToStrategyAfter {

    /**
     * Supply 1+ arguments, e.g. no_stop_words, no_numbers
     */
    public static void main(String[] args) {

        String content = readFile(Paths.get("text-stats/src/main/resources/design_patterns.txt"));
        List<String> words = tokenize(content);

        System.out.println("------- Using the Strategy pattern --------");
        TextStatsPalWithStrategy textStats = new TextStatsPalWithStrategy();
        Map<String, Long> wordStats1 = textStats.countWords(words);
        System.out.println(sortDescending(wordStats1));


        System.out.println("------- Change the Strategy --------");
        textStats.setCriteria(new NoStopWords());
        Map<String, Long> wordStats2 = textStats.countWords(words);
        System.out.println(sortDescending(wordStats2));


        System.out.println("------- With Predicate (Functional Programming) --------");
        // Using Java 8 predicates on client side
        Predicate<String> noStopWords = word -> !getStopWords().contains(word);
        Predicate<String> noNumbers = word -> !isNumeric(word);

        Predicate<String> combined = noStopWords.and(noNumbers);
        List<Predicate<String>> filters = List.of(noStopWords, noNumbers);

        List<Predicate<String>> userFilters = mapUserInputToFilters(args); // no_stop_words, no_numbers

        TextStatsPalWithPredicate textStatsPal = new TextStatsPalWithPredicate();
        Map<String, Long> wordStats = textStatsPal.countWords(words, userFilters);
        System.out.println(sortDescending(wordStats));
    }
}
