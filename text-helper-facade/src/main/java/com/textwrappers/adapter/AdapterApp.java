package com.textwrappers.adapter;

import com.definitionbuddy.entities.DictWord;
import com.textwrappers.entities.Word;
import com.textwrappers.entities.WordImpl;

import java.util.IntSummaryStatistics;
import java.util.List;

public class AdapterApp {

    public static void main(String[] args) {

        Word word1 = new WordImpl("design", List.of(" The purposeful arrangement of parts or details."));
        Word word2 = new WordImpl("pattern", List.of("A plan, or model to be followed in making things"));

        DictWord word3 = new DictWord("adapter", List.of("A connector for " +
                "joining parts having different designs"));

        Word word4 = new WordAdapter(word3);

        List<Word> words = List.of(word1, word2, word4);

        IntSummaryStatistics stats = computeWordStats(words);

        System.out.println("Longest word length: " + stats.getMax());
        System.out.println("Shortest word length: " + stats.getMin());
    }

    private static IntSummaryStatistics computeWordStats(List<Word> wordLengthList) {
        return wordLengthList.stream()
                .mapToInt(Word::getLength)
                .summaryStatistics();
    }
}
