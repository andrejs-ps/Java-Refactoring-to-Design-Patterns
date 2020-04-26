package com.definitionbuddy;

import com.definitionbuddy.dictionary.GeneralDictionary;
import com.definitionbuddy.search.LocalBackupDefinitionSearch;
import com.definitionbuddy.search.WebServiceDefinitionSearch;

import java.util.List;

public class AppNoFactory {

    public static void main(String[] args){

        // initial code - dependencies inside

        GeneralDictionary d = new GeneralDictionary();
        List<String> definitions = d.getDefinitions("computer");
        definitions.forEach(System.out::println);


        // With injected dependencies - but:
            // 1) We complicate the client code
            // 2) We expose unnecessary details (we leak what should be perhaps encapsulated)

        GeneralDictionary d2 = new GeneralDictionary(WebServiceDefinitionSearch.newInstance());
        List<String> definitions2 = d2.getDefinitions("book");
        definitions2.forEach(System.out::println);


        // Dict with Local Backup Injected - use it if the WebService is unavailable
        GeneralDictionary d3 = new GeneralDictionary(LocalBackupDefinitionSearch.newInstance());
        List<String> definitions3 = d3.getDefinitions("tea");
        definitions3.forEach(System.out::println);

    }
}
