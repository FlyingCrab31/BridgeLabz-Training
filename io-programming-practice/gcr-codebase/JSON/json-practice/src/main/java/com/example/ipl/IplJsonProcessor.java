package com.example.ipl;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.io.File;

public class IplJsonProcessor {

    public static void processJson() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        InputStream is = IplJsonProcessor.class
                .getClassLoader()
                .getResourceAsStream("ipl.json");

        if(is == null) {
            throw new RuntimeException("ipl.json not found in resources");
        }

        IPLMatch[] matches = mapper.readValue(is, IPLMatch[].class);

        for (IPLMatch match : matches) {
            IPLCensorService.censorMatch(match);
        }

        mapper.writerWithDefaultPrettyPrinter()
              .writeValue(new File("ipl_censored.json"), matches);
    }
}
