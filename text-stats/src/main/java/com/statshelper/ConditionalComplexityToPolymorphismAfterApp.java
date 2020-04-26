package com.statshelper;

import com.definitionbuddy.dictionary.Dictionary;
import com.statshelper.writers.Writer;
import com.statshelper.writers.WriterFactory;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.definitionbuddy.dictionary.SimpleDictionaryFactory.english;
import static com.statshelper.helpers.HelperUtils.*;
import static com.statshelper.writers.WriterFactory.WriterType;
import static com.statshelper.writers.WriterFactory.getWriter;

public class ConditionalComplexityToPolymorphismAfterApp {

    /**
     * supply an argument to the program - either 'txt' or 'pdf'
     */
    public static void main(String[] args){

        List<String> words = getWords(Paths.get("text-stats/src/main/resources/words.csv"));

        Dictionary dict = english();
        String wordsWithDefinitions = defineWords(dict, words);

        // no branching
        String outputDestination = args[0];
        Writer fileWriter = getWriter(WriterType.valueOf(outputDestination));
        fileWriter.write(wordsWithDefinitions, Paths.get("wordsWithDefinitions." + outputDestination));
    }
}
