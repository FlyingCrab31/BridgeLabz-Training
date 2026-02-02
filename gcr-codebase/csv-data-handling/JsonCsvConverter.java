import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;

public class JsonCsvConverter {

    static class Student {
        public int id;
        public String name;
        public int age;
        public int marks;
    }

    public static void jsonToCsv(String jsonFile, String csvFile) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        List<Student> students =
                mapper.readValue(new File(jsonFile),
                        new TypeReference<List<Student>>() {});

        BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile));
        writer.write("id,name,age,marks");
        writer.newLine();

        for (Student s : students) {
            writer.write(s.id + "," + s.name + "," + s.age + "," + s.marks);
            writer.newLine();
        }

        writer.close();
        System.out.println("JSON → CSV done");
    }

    public static void csvToJson(String csvFile, String jsonFile) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        List<Student> students = new ArrayList<>();

        String line = br.readLine(); // skip header
        while ((line = br.readLine()) != null) {

            String[] data = line.split(",");
            if (data.length < 4) continue;

            Student s = new Student();
            s.id = Integer.parseInt(data[0].trim());
            s.name = data[1].trim();
            s.age = Integer.parseInt(data[2].trim());
            s.marks = Integer.parseInt(data[3].trim());

            students.add(s);
        }

        br.close();

        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter()
              .writeValue(new File(jsonFile), students);

        System.out.println("CSV → JSON done");
    }

    public static void main(String[] args) throws Exception {

        jsonToCsv("students.json", "students.csv");
        csvToJson("students.csv", "students_output.json");
    }
}
