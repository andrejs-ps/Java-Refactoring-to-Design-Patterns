package com.definitionbuddy.dictionary.factorymethod;

import com.definitionbuddy.dictionary.Dictionary;
import com.definitionbuddy.dictionary.Language;
import com.definitionbuddy.dictionary.MedicalDictionary;
import com.definitionbuddy.search.DedicatedMedicalDefinitionSearch;

public class MedicalDictionaryFactory extends DictionaryFactory {



    @Override
    protected Dictionary create(Language language) {
        return new MedicalDictionary(new DedicatedMedicalDefinitionSearch(language));
    }
}
