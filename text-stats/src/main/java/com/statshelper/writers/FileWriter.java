package com.statshelper.writers;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriter implements Writer {


    @Override
    public void write(String s, Path path) {
        try {
            Files.write(path, String.join("\n", s).getBytes());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
