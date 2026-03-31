package com.example.basics;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJsonObjects {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        // First JSON object
        ObjectNode json1 = mapper.createObjectNode();
        json1.put("name", "Anushka");
        json1.put("age", 22);

        // Second JSON object
        ObjectNode json2 = mapper.createObjectNode();
        json2.put("email", "anu@gmail.com");
        json2.put("city", "Mathura");

        // Merge json2 into json1
        json1.setAll(json2);

        // Print merged JSON
        System.out.println(json1.toPrettyString());
    }
}
