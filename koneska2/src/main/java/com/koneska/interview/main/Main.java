package com.koneska.interview.main;

import com.koneska.interview.aggregator.HeartRateDataAggregator;
import com.koneska.interview.aggregator.HeartRateDataAggregatorImpl;
import com.koneska.interview.io.HeartRateDataParser;

public class Main {

    public static void main(String args[]) {
        HeartRateDataAggregator aggregator = new HeartRateDataAggregatorImpl();
        System.out.println(HeartRateDataParser.serialize(aggregator.aggregate(HeartRateDataParser.deserialize())));
    }
}
