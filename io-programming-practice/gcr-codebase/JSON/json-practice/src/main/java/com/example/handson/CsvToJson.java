package com.example.handson;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.MappingIterator;

import java.io.File;

public class CsvToJson {
    public static void main(String[] args) throws Exception {

        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();

        MappingIterator<JsonNode> it =
                csvMapper.readerFor(JsonNode.class)
                         .with(schema)
                         .readValues(new File("src/main/resources/users.csv"));

        ObjectMapper jsonMapper = new ObjectMapper();
        System.out.println(
                jsonMapper.writerWithDefaultPrettyPrinter()
                          .writeValueAsString(it.readAll())
        );
    }
}
