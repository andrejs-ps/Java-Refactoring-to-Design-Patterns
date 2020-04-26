package com.definitionbuddy;

import com.definitionbuddy.dictionary.factorymethod.DictionaryFactory;
import com.definitionbuddy.dictionary.factorymethod.GeneralDictionaryFactory;

import static com.definitionbuddy.dictionary.Language.ENGLISH;

public class AppWithFactoryMethod {

    public static void main(String[] args){

        DictionaryFactory dictionaryFactory = new GeneralDictionaryFactory();

        dictionaryFactory.newDictionary(ENGLISH)
                .getDefinitions("coffee")
                .forEach(System.out::println);
    }
}
