package com.example.handson;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;

public class MergeJsonFiles {
    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        ObjectNode j1 = (ObjectNode) mapper.readTree(new File("src/main/resources/file1.json"));
        ObjectNode j2 = (ObjectNode) mapper.readTree(new File("src/main/resources/file2.json"));

        j1.setAll(j2);
        System.out.println(j1.toPrettyString());
    }
}
