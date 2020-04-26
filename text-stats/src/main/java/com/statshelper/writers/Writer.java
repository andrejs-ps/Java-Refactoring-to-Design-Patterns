package com.statshelper.writers;

import java.nio.file.Path;

public interface Writer {

    void write(String s, Path path);
}
