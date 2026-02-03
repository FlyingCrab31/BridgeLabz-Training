package com.example.ipl;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.*;
import java.io.*;
import java.util.*;

public class IplCsvProcessor {

    public static void processCsv() throws Exception {

        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();

        InputStream is = IplCsvProcessor.class
                .getClassLoader()
                .getResourceAsStream("ipl.csv");

        if(is == null) {
            throw new RuntimeException("ipl.csv not found in resources");
        }

        MappingIterator<Map<String, String>> it =
                mapper.readerFor(Map.class)
                      .with(schema)
                      .readValues(is);

        List<Map<String, String>> rows = new ArrayList<>();

        while (it.hasNext()) {
            Map<String, String> row = it.next();

            row.put("team1", IPLCensorService.maskTeam(row.get("team1")));
            row.put("team2", IPLCensorService.maskTeam(row.get("team2")));
            row.put("winner", IPLCensorService.maskTeam(row.get("winner")));
            row.put("player_of_match", "REDACTED");

            rows.add(row);
        }

        if(!rows.isEmpty()) {
            // Build schema from first row's keys
            CsvSchema.Builder schemaBuilder = CsvSchema.builder();
            for(String col : rows.get(0).keySet()) {
                schemaBuilder.addColumn(col);
            }
            CsvSchema outputSchema = schemaBuilder.build().withHeader();

            mapper.writer(outputSchema)
                  .writeValue(new File("ipl_censored.csv"), rows);
        }
    }
}
