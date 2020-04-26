package com.statshelper.strategy;

import java.util.List;
import java.util.Map;

public interface WordCriteria {

    Map<String, Long> convertToFrequencyTable(List<String> list);
}
