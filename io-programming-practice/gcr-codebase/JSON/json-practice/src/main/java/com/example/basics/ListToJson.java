package com.example.basics;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

class Student {
    public String name;
    public int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}


public class ListToJson {
    public static void main(String[] args) throws Exception {

        List<Student> students = List.of(
                new Student("Anushka", 22),
                new Student("Rahul", 26)
        );

        ObjectMapper mapper = new ObjectMapper();
        String jsonArray = mapper.writeValueAsString(students);

        System.out.println(jsonArray);
    }
}
