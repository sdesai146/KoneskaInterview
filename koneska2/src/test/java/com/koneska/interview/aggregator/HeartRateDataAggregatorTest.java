package com.koneska.interview.aggregator;


import com.koneska.interview.domain.HeartRateDataAggregate;
import com.koneska.interview.domain.HeartRateRaw;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.Assert;

public class HeartRateDataAggregatorTest {

    private List<HeartRateDataAggregate> common() {
        HeartRateDataAggregatorImpl testSubject = new HeartRateDataAggregatorImpl();
        HeartRateRaw raw1 = new HeartRateRaw();
        raw1.setBpm(10);
        raw1.setStartTime(LocalDateTime.of(2021,11, 1, 1, 1, 2));
        raw1.setStartTime(LocalDateTime.of(2021,11, 1, 1, 1, 1));

        HeartRateRaw raw2 = new HeartRateRaw();
        raw2.setBpm(10);

        raw2.setStartTime(LocalDateTime.of(2021,11, 2, 1, 1, 2));
        raw2.setStartTime(LocalDateTime.of(2021,11, 2, 1, 1, 1));

        HeartRateRaw raw3 = new HeartRateRaw();
        raw3.setBpm(10);
        raw3.setStartTime(LocalDateTime.of(2021,12, 1, 1, 1, 2));
        raw3.setStartTime(LocalDateTime.of(2021,12, 1, 1, 1, 1));

        List<HeartRateRaw> data = Arrays.asList(raw1, raw2, raw3);
        List<HeartRateDataAggregate> result = testSubject.aggregate(data);

        return result;
    }

    @Test
    public void testAggregate() {


        HeartRateDataAggregate res1 = new HeartRateDataAggregate();
        res1.setDate(LocalDate.of(2021,11, 1));
        res1.setBpm(new HeartRateDataAggregate.Bpm(10,10,10));

        HeartRateDataAggregate res3 = new HeartRateDataAggregate();
        res3.setDate(LocalDate.of(2021,11, 2));
        res3.setBpm(new HeartRateDataAggregate.Bpm(10,10,10));

        HeartRateDataAggregate res2 = new HeartRateDataAggregate();
        res2.setDate(LocalDate.of(2021,12, 1));
        res2.setBpm(new HeartRateDataAggregate.Bpm(10,10,10));

        List<HeartRateDataAggregate> expected = new ArrayList<>();
        expected.add(res3);
        expected.add(res2);
        expected.add(res1);


        Assert.assertEquals(expected, common());
    }
}
