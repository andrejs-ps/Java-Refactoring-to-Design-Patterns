package com.definitionbuddy.search;

import com.definitionbuddy.dictionary.Language;

import java.util.List;

public class DedicatedLegalDefinitionSearch implements DefinitionSearch {

    private Language language;

    public DedicatedLegalDefinitionSearch() {
        this.language = Language.ENGLISH; // default
    }

    public DedicatedLegalDefinitionSearch(Language language) {
        this.language = language;
    }

    @Override
    public List<String> getDefinition(String word) {
        return List.of("Find and implement a dedicated provider, since the general one is insufficient");
    }
}
