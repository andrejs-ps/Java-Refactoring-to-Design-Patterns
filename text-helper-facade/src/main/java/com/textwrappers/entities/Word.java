package com.textwrappers.entities;

import java.util.List;

public interface Word {

    String getWord();

    List<String> getDefinitions();

    int getLength();
}
