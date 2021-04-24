package com.koneska.interview.aggregator;

import com.koneska.interview.domain.HeartRateDataAggregate;
import com.koneska.interview.domain.HeartRateRaw;

import java.util.List;

public interface HeartRateDataAggregator {

    /**
     * Reads raw heart rate data and calculates min, max, median per day
     * @param heartRateRawData
     * @return
     */
    public List<HeartRateDataAggregate> aggregate(List<HeartRateRaw> heartRateRawData);

}
