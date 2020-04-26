package com.definitionbuddy.entities;

import java.util.List;

/**
 * Used to demonstrate the Adapter in module text-helper-facade module
 */
public class DictWord {

    private final String word;
    private final List<String> definitions;
    private final int wordLength;

    public DictWord(String word, List<String> definitions) {
        this.word = word;
        this.definitions = definitions;
        this.wordLength = word.length();
    }

    public String getWord() {
        // do some cleaning
        String capitalized = word.substring(0, 1).toUpperCase() + word.substring(1);
        return capitalized.trim();
    }

    public List<String> getDefinitions() {
        return definitions;
    }

    public int getWordLength() {
        return wordLength;
    }
}
