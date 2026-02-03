package com.example.handson;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JsonToXml {
    public static void main(String[] args) throws Exception {

        String json = "{\"name\":\"Anushka\",\"age\":22}";

        ObjectMapper jsonMapper = new ObjectMapper();
        JsonNode node = jsonMapper.readTree(json);

        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(node);

        System.out.println(xml);
    }
}
