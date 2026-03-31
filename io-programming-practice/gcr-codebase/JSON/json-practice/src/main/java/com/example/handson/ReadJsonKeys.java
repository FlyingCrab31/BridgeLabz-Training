package com.example.handson;

import com.fasterxml.jackson.databind.*;
import java.io.File;
import java.util.Iterator;

public class ReadJsonKeys {
    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File("src/main/resources/file1.json"));

        Iterator<String> keys = root.fieldNames();

        while (keys.hasNext()) {
            String key = keys.next();
            System.out.println(key + " : " + root.get(key));
        }
    }
}
