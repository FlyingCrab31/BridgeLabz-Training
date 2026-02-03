package com.example.basics;


import com.fasterxml.jackson.databind.*;
import java.io.File;

public class ReadSpecificFields {
    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root =
            mapper.readTree(new File("src/main/resources/users.json"));

        for (JsonNode node : root) {
            System.out.println(
                node.get("name").asText() + " - " +
                node.get("email").asText()
            );
        }
    }
}

