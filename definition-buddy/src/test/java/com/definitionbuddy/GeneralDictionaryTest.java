package com.definitionbuddy;

import com.definitionbuddy.dictionary.GeneralDictionary;
import com.definitionbuddy.search.WebServiceDefinitionSearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class GeneralDictionaryTest {

    @Test
    public void dictTest(){
        GeneralDictionary d = new GeneralDictionary(WebServiceDefinitionSearch.newInstance());

        List<String> definitions = d.getDefinitions("hello");

        Assertions.assertEquals(definitions.size(), 3);

        definitions.forEach(System.out::println);
    }


}