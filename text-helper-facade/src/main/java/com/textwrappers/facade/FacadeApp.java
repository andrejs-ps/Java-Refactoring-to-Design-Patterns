package com.textwrappers.facade;


import com.definitionbuddy.dictionary.Dictionary;
import com.definitionbuddy.dictionary.factorymethod.GeneralDictionaryFactory;
import com.statshelper.strategy.TextStatsPalWithPredicate;

import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static com.definitionbuddy.dictionary.Language.ENGLISH;
import static com.statshelper.helpers.HelperUtils.tokenizeList;
import static com.statshelper.strategy.TextStatsPalWithPredicate.WordFilterCriteria2.NO_STOP_WORDS;

public class FacadeApp {

    public static void main(String[] args) {

        // Without Facade - init each service separately
        Dictionary dict = new GeneralDictionaryFactory().newDictionary(ENGLISH);
        TextStatsPalWithPredicate textStatsPal = new TextStatsPalWithPredicate();


        // With Facade
        MyTextHelper helper = MyTextHelper.newHelper();

        List<String> definitions = helper
                .withDefinitionBuddy(ENGLISH)
                .getDefinitions("tea");


        Map<String, Long> frequencyTable = helper
                .withStatsPal()
                .countWords(tokenizeList(definitions), List.of(NO_STOP_WORDS));


        helper.withFileWriter()
                .write(mapToString(frequencyTable), Paths.get("frequencyTable.txt"));

    }

    private static String mapToString(Map<?, ?> map) {
        StringBuilder mapAsString = new StringBuilder("{");
        for (Object key : map.keySet()) {
            mapAsString.append(key + "=" + map.get(key) + ", ");
        }
        mapAsString.delete(mapAsString.length() - 2, mapAsString.length()).append("}");
        return mapAsString.toString();
    }
}
