package com.statshelper.helpers;

import com.definitionbuddy.dictionary.Dictionary;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static java.util.Collections.reverseOrder;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class HelperUtils {

    public static String readFile(Path path){
        try {
            return Files.readString(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static String join(String word, List<String> defs) {
        return word + ": " + String.join("; ", defs);
    }

    public static List<String> getWords(Path path) {

        String content = readFile(path);

        return Arrays.stream(content.split(","))
                .map(String::trim)
                .collect(toList());
    }

    public static Map<String, Long> sortDescending(Map<String, Long> stringFrequencyMap) {
        return stringFrequencyMap.entrySet()
                .stream()
                .sorted(reverseOrder(comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey,
                                Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
    }

    public static List<String> tokenize(String s) {
        String sanitized =
                s.replaceAll("[^A-Za-z0-9]", " ")
                 .replaceAll(" +", " ");

        return Arrays.asList(sanitized.split(" "));
    }

    public static List<String> tokenizeList(List<String> list){
        return tokenize(String.join(" ", list));
    }

    public static Collection<String> getStopWords() {
        return List.of("the", "of", "a", "and", "to", "in", "that", "for", "are", "as", "be", "by", "or", "is");
    }

    public static boolean isNumeric(String strNum) {
        return strNum.matches("-?\\d+(\\.\\d+)?");
    }

    /**
     * Using a supplied dictionary, define each word in a list
     * and concatenate, i.e. "word1: definitions; word2: definitions"
     * @return words with their definitions as one big string
     */
    public static String defineWords(Dictionary dictionary, List<String> words) {

        List<String> wordsWithDefinitionsList = new ArrayList<>();
        // get and merge definitions with each
        for(String word : words){
            List<String> defs = dictionary.getDefinitions(word);
            String wordWithDefinition = join(word, defs);
            wordsWithDefinitionsList.add(wordWithDefinition);
        }
        return String.join("\n", wordsWithDefinitionsList);
    }
}
