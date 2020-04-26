package com.definitionbuddy.dictionary.factorymethod;

import com.definitionbuddy.dictionary.Dictionary;
import com.definitionbuddy.dictionary.Language;
import com.definitionbuddy.dictionary.LegalDictionary;
import com.definitionbuddy.search.DedicatedLegalDefinitionSearch;

public class LegalDictionaryFactory extends DictionaryFactory {

    @Override
    protected Dictionary create(Language language) {
        return new LegalDictionary(new DedicatedLegalDefinitionSearch(language));
    }
}
