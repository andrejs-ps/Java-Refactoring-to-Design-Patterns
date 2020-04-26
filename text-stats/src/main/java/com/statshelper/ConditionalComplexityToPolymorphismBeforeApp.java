package com.statshelper;

import com.definitionbuddy.dictionary.Dictionary;
import com.statshelper.helpers.HelperUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static com.definitionbuddy.dictionary.SimpleDictionaryFactory.english;
import static com.statshelper.helpers.HelperUtils.getWords;

public class ConditionalComplexityToPolymorphismBeforeApp {


    /**
     * supply an argument to the program - either 'txt' or 'pdf'
     */
    public static void main(String[] args){

        List<String> words = getWords(Paths.get("text-stats/src/main/resources/words.csv"));

        Dictionary dict = english();
        String wordsWithDefinitions = HelperUtils.defineWords(dict, words);


        String outputDestination = args[0];
        // example of a non-deeply nested, but large conditional code
        if(outputDestination.equalsIgnoreCase("txt")){

            try {
                Files.write(Paths.get("wordsWithDefinitions.csv"), wordsWithDefinitions.getBytes());
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }

        } else if (outputDestination.equalsIgnoreCase("pdf")){

            String sanitized = wordsWithDefinitions.replaceAll("\\p{C}", "");
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);
            PDPageContentStream contentStream;
            try {
                contentStream = new PDPageContentStream(document, page);
                contentStream.setFont(PDType1Font.COURIER, 12);
                contentStream.beginText();
                contentStream.showText(sanitized);
                contentStream.endText();
                contentStream.close();
                document.save(Paths.get("wordsWithDefinitions.pdf").toFile());
                document.close();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
        else {
            throw new IllegalArgumentException("We only currently support writing to txt or pdf. " +
                                                "You have input: " + outputDestination);
        }
    }
}
