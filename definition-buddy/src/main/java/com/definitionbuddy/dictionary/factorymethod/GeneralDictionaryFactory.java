package com.definitionbuddy.dictionary.factorymethod;

import com.definitionbuddy.dictionary.Dictionary;
import com.definitionbuddy.dictionary.GeneralDictionary;
import com.definitionbuddy.dictionary.Language;

import static com.definitionbuddy.search.WebServiceDefinitionSearch.newForeignLanguageInstance;

public class GeneralDictionaryFactory extends DictionaryFactory {

    @Override
    Dictionary create(Language language) {
        return new GeneralDictionary(newForeignLanguageInstance(language));
    }
}
