package com.koneska.interview.aggregator;

import com.koneska.interview.domain.HeartRateDataAggregate;
import com.koneska.interview.domain.HeartRateRaw;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class HeartRateDataAggregatorImpl implements HeartRateDataAggregator {
    @Override
    public List<HeartRateDataAggregate> aggregate(List<HeartRateRaw> heartRateRawData) {

        //group by monitoring date
        Map<LocalDate, List<HeartRateRaw>> groupByDate =
                heartRateRawData.stream().collect(Collectors.collectingAndThen(groupingBy(HeartRateRaw::getMonitoringDate),
                        (hr) -> {
                            hr.forEach((k, v) -> hr.get(k).sort(Comparator.comparing(HeartRateRaw::getBpm)));
                            return hr;
                        }));

        //System.out.println(groupByDate);

        final List<HeartRateDataAggregate> result = new ArrayList<>(groupByDate.size());
        groupByDate.forEach((key, val)->{
            int dailyMeasurementsTotal, medianIdx1;

            HeartRateDataAggregate aggregate = new HeartRateDataAggregate();
            aggregate.setDate(key);
            HeartRateDataAggregate.Bpm bpm = new HeartRateDataAggregate.Bpm();
            dailyMeasurementsTotal =  val.size();
            bpm.setMax(val.get(dailyMeasurementsTotal - 1).getBpm());
            bpm.setMin(val.get(0).getBpm());
            medianIdx1 = dailyMeasurementsTotal / 2;

            if (dailyMeasurementsTotal % 2 == 0) {
                int medianIdx2 = medianIdx1 - 1;
                double median = (val.get(medianIdx1).getBpm() + val.get(medianIdx2).getBpm()) / 2;
                bpm.setMedian(median);
            } else {
                bpm.setMedian(val.get(medianIdx1).getBpm());
            }

            aggregate.setBpm(bpm);
            result.add(aggregate);

        });


        return result;
    }
}
