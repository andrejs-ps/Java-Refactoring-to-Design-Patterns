package com.definitionbuddy.search;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static com.definitionbuddy.helpers.JsonHelper.extractDefinitions;
import static java.nio.charset.StandardCharsets.UTF_8;

public class LocalBackupDefinitionSearch implements DefinitionSearch {

    public static LocalBackupDefinitionSearch newInstance(){
        return new LocalBackupDefinitionSearch();
    }

    @Override
    public List<String> getDefinition(String word) {

        String content;
        try {
            content = Files.readString(Paths.get("definition-buddy/src/main/resources/BackupLocalDefinitions.json"), UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        String sub1 = content.substring(content.indexOf("word\": \"" + word) + 4);
        String sub2 = sub1.substring(0, sub1.indexOf("word\": \""));

        return extractDefinitions(sub2);
    }
}
