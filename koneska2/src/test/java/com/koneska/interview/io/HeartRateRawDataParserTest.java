package com.koneska.interview.io;

import com.koneska.interview.domain.HeartRateDataAggregate;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HeartRateRawDataParserTest {

    @Test
    public void testSerializer() {
        HeartRateDataAggregate res1 = new HeartRateDataAggregate();
        res1.setDate(LocalDate.of(2021,11, 1));
        res1.setBpm(new HeartRateDataAggregate.Bpm(10,10,10));

        HeartRateDataAggregate res3 = new HeartRateDataAggregate();
        res3.setDate(LocalDate.of(2021,11, 2));
        res3.setBpm(new HeartRateDataAggregate.Bpm(10,10,10));

        HeartRateDataAggregate res2 = new HeartRateDataAggregate();
        res2.setDate(LocalDate.of(2021,12, 1));
        res2.setBpm(new HeartRateDataAggregate.Bpm(10,10,10));

        List<HeartRateDataAggregate> input = new ArrayList<>();
        input.add(res3);
        input.add(res2);
        input.add(res1);
        System.out.println(HeartRateDataParser.serialize(input));

        Assert.assertEquals("[{\"date\":\"11/02/2021\",\"bpm\":{\"min\":10.0,\"max\":10.0,\"median\":10.0}},{\"date\":\"12/01/2021\",\"bpm\":{\"min\":10.0,\"max\":10.0,\"median\":10.0}},{\"date\":\"11/01/2021\",\"bpm\":{\"min\":10.0,\"max\":10.0,\"median\":10.0}}]", HeartRateDataParser.serialize(input));

    }
}
