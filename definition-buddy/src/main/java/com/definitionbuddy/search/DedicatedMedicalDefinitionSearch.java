package com.definitionbuddy.search;

import com.definitionbuddy.dictionary.Language;

import java.util.List;

public class DedicatedMedicalDefinitionSearch implements DefinitionSearch {

    private Language language;

    public DedicatedMedicalDefinitionSearch(){
        this.language = Language.ENGLISH; // default
    }

    public DedicatedMedicalDefinitionSearch(Language language) {
        this.language = language;
    }

    @Override
    public List<String> getDefinition(String word) {
        return List.of("Perhaps from a database");
    }
}
