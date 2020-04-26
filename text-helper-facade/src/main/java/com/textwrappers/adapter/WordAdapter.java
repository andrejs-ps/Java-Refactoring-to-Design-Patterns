package com.textwrappers.adapter;

import com.definitionbuddy.entities.DictWord;
import com.textwrappers.entities.Word;

import java.util.List;

/**
 * Separate adapter class if we want to keep both our own and external implementations
 */
public class WordAdapter implements Word {

    private final DictWord dictWord;

    public WordAdapter(DictWord dictWord) {
        this.dictWord = dictWord;
    }

    @Override
    public String getWord() {
        // benefit from better functionality
        // or revert string manipulation done by getWord
        return dictWord.getWord();
    }

    @Override
    public List<String> getDefinitions() {
        return dictWord.getDefinitions();
    }

    @Override
    public int getLength() {
        // adapt a different method name
        return dictWord.getWordLength();
    }
}
