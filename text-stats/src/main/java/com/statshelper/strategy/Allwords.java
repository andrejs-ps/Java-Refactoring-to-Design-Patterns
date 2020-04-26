package com.statshelper.strategy;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Allwords implements WordCriteria {

    @Override
    public Map<String, Long> convertToFrequencyTable(List<String> list) {
        return list.stream()
                .map(String::toLowerCase)
                .collect(groupingBy(w -> w, counting()));
    }
}
