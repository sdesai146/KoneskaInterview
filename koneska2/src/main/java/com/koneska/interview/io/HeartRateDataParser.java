package com.koneska.interview.io;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.koneska.interview.domain.HeartRateDataAggregate;
import com.koneska.interview.domain.HeartRateRaw;
import com.koneska.interview.exception.KoneskaException;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import static java.util.Objects.nonNull;

public class HeartRateDataParser {

    /**
     * Convert Json file to Java object
     * @return
     */
    public static List<HeartRateRaw> deserialize() {
        List<HeartRateRaw> obj = null;
        try {
            //Reads file from classpath, it can be changed to use different path
            URL resource = HeartRateDataParser.class.getClassLoader().getResource("heart-rate.json");
            if (nonNull(resource)) {

                File file = new File(resource.toURI());

                ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());

                //JSON file to Java object
                obj = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, HeartRateRaw.class));

            }
            return obj;
        } catch (URISyntaxException  |  IOException e) {
           throw new KoneskaException.DeserializerException("Enable to Read heart-rate.json file", e);
        }


    }

    /**
     * Java object to JSON. Currently returns string, can be changed to write to a file
     * @param result
     * @return
     */
    public static String serialize(List<HeartRateDataAggregate> result) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            return mapper.writeValueAsString(result);

        } catch (JsonProcessingException e) {
            throw new KoneskaException.SerializerException("Enable to Read heart-rate.json file", e);
        }
    }


}
