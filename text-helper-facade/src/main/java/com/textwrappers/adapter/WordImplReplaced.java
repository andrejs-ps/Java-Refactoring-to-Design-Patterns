package com.textwrappers.adapter;

import com.definitionbuddy.entities.DictWord;
import com.textwrappers.entities.Word;

import java.util.List;

/**
 * Solution two - if we want to entire replace our own
 */
public class WordImplReplaced implements Word {

    private final DictWord dictWord;
    private final String word;
    private final List<String> definitions;
    private final int wordLength;

    public WordImplReplaced(String word, List<String> definitions) {
        dictWord = new DictWord(word, definitions);
        this.word = word;
        this.definitions = definitions;
        this.wordLength = word.length();
    }

    public String getWord() {
        return dictWord.getWord();
    }

    public List<String> getDefinitions() {
        return dictWord.getDefinitions();
    }

    public int getLength() {
        return dictWord.getWordLength();
    }
}
