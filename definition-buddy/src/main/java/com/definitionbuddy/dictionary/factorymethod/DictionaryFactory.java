package com.definitionbuddy.dictionary.factorymethod;

import com.definitionbuddy.dictionary.Dictionary;
import com.definitionbuddy.dictionary.Language;

public abstract class DictionaryFactory {

    public Dictionary newDictionary(Language language){

        // perhaps some common steps before creation
        Dictionary d = create(language);
        // perhaps some common steps after creation
        return d;
    }

    abstract Dictionary create(Language language);
}
