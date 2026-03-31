package com.example.basics;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class StudentJsonCreate {
    public static void main(String[] args) throws Exception {

        Map<String, Object> student = new HashMap<>();
        student.put("name", "Anushka");
        student.put("age", 21);
        student.put("subjects", Arrays.asList("Java", "DBMS", "Math"));

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(
            mapper.writerWithDefaultPrettyPrinter()
                  .writeValueAsString(student)
        );
    }
}