package com.example.handson;

import com.fasterxml.jackson.databind.*;

public class FilterAge {
    public static void main(String[] args) throws Exception {

        String json = "[{\"name\":\"A\",\"age\":20},{\"name\":\"B\",\"age\":30}]";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode array = mapper.readTree(json);

        for (JsonNode node : array) {
            if (node.get("age").asInt() > 25) {
                System.out.println(node);
            }
        }
    }
}

