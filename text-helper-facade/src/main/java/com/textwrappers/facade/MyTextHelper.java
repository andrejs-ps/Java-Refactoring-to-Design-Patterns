package com.textwrappers.facade;

import com.definitionbuddy.dictionary.Dictionary;
import com.definitionbuddy.dictionary.Language;
import com.definitionbuddy.dictionary.factorymethod.DictionaryFactory;
import com.definitionbuddy.dictionary.factorymethod.GeneralDictionaryFactory;
import com.statshelper.strategy.TextStatsPalWithPredicate;
import com.statshelper.writers.FileWriter;
import com.statshelper.writers.Writer;

public class MyTextHelper {

    private DictionaryFactory dict;
    private TextStatsPalWithPredicate textStats;


    private MyTextHelper(DictionaryFactory dict, TextStatsPalWithPredicate textStats) {
        this.dict = dict;
        this.textStats = textStats;
    }

    public static MyTextHelper newHelper() {
        return new MyTextHelper(new GeneralDictionaryFactory(), new TextStatsPalWithPredicate());
    }

    public Dictionary withDefinitionBuddy(Language language) {
        return dict.newDictionary(language);
    }

    public TextStatsPalWithPredicate withStatsPal() {
        return textStats;
    }

    public Writer withFileWriter() {
        return new FileWriter();
    }
}
