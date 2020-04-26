package com.definitionbuddy.dictionary;

import com.definitionbuddy.search.DefinitionSearch;
import com.definitionbuddy.search.WebServiceDefinitionSearch;

import java.util.List;

import static com.definitionbuddy.dictionary.Language.ENGLISH;
import static com.definitionbuddy.dictionary.Language.SPANISH;
import static com.definitionbuddy.search.WebServiceDefinitionSearch.newForeignLanguageInstance;

public class GeneralDictionary implements Dictionary {

    private final DefinitionSearch search;

    // dummy additional objects to show that
    // new dependencies can be added within a static factory method
    // without affecting the client
    private SynonymFinder finder;
    private ExampleProvider examples;

    public GeneralDictionary() {
        search = WebServiceDefinitionSearch.newInstance();
    }

    public GeneralDictionary(DefinitionSearch search) {
        this.search = search;
    }

    public GeneralDictionary(DefinitionSearch search, SynonymFinder finder, ExampleProvider examples) {
        this.search = search;
        this.finder = finder;
        this.examples = examples;
    }

    public static GeneralDictionary english() {
        return new GeneralDictionary(
                newForeignLanguageInstance(ENGLISH),
                new SynonymFinder(),
                new ExampleProvider());
    }

    public static GeneralDictionary spanish() {
        return new GeneralDictionary(newForeignLanguageInstance(SPANISH));
    }

    public List<String> getDefinitions(String word) {
        return search.getDefinition(word);
    }
}
