package com.statshelper.strategy;

import java.util.List;
import java.util.Map;

public class TextStatsPalWithStrategy {

    private WordCriteria criteria;

    public TextStatsPalWithStrategy() {
        this.criteria = new Allwords();
    }

    public TextStatsPalWithStrategy(WordCriteria criteria) {
        this.criteria = criteria;
    }

    public Map<String, Long> countWords(List<String> list){
        return criteria.convertToFrequencyTable(list);
    }

    public void setCriteria(WordCriteria criteria){
        this.criteria = criteria;
    }
}
