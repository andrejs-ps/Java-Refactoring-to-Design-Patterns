package com.definitionbuddy;

import com.definitionbuddy.helpers.JsonHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class JsonHelperTest {

    private static final String JSON = "[\n {\n   \"word\": \"¡adiós!\",\n \"phonetic\": \"\",\n \"origin\": \"\",\n \"meaning\": {\n \"interjección\": {\n " +
            "\"definitions\": [\n  {\n  " +
            "\"definition\": \"Expresión de despedida o con la que se saludan dos personas que se encuentran pero no se paran a hablar.\",\n   \"example\": \"\",\n   \"synonyms\": []\n  },\n {\n " +
            "\"definition\": \"Expresión que se usa para indicar disgusto, asombro o decepción.\",\n   \"example\": \"¡adios, qué tortazo!\",\n \"synonyms\": []\n   },\n " +
            "{\n  \"definition\": \"\",\n \"example\": \"\",\n \"synonyms\": []\n }\n ]\n }\n}\n }\n]";

    @Test
    public void jsonHelperExtractsDefinitionsCorrectly() {

        List<String> definitions = JsonHelper.extractDefinitions(JSON);
        Assertions.assertEquals(definitions.size(), 2);
    }
}