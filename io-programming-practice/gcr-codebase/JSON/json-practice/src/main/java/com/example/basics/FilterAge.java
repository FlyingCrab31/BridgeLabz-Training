package com.example.basics;


import com.fasterxml.jackson.databind.*;
import java.io.File;

public class FilterAge {
    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root =
            mapper.readTree(new File("src/main/resources/users.json"));

        root.forEach(node -> {
            if (node.get("age").asInt() > 25) {
                System.out.println(node);
            }
        });
    }
}
