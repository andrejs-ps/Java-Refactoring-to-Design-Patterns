package com.statshelper.strategy;

import java.util.List;
import java.util.Map;

import static com.statshelper.helpers.HelperUtils.getStopWords;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class NoStopWords implements WordCriteria {

    @Override
    public Map<String, Long> convertToFrequencyTable(List<String> list) {
        return list.stream()
                .map(String::toLowerCase)
                .filter(word -> !getStopWords().contains(word))
                .collect(groupingBy(w -> w, counting()));
    }

}
