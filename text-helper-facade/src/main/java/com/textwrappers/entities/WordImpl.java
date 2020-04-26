package com.textwrappers.entities;

import java.util.List;

public class WordImpl implements Word {

    private final String word;
    private final List<String> definitions;
    private final int wordLength;

    public WordImpl(String word, List<String> definitions) {
        this.word = word;
        this.definitions = definitions;
        this.wordLength = word.length();
    }

    public String getWord() {
        return word;
    }

    public List<String> getDefinitions() {
        return definitions;
    }

    public int getLength() {
        return wordLength;
    }
}
