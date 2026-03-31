

import java.util.*;
class InvalidMarkException extends Exception{
    public InvalidMarkException(String message){
        super(message);
    }
}

//Class Student 
class Student{
    String studentName;
    String[] subjects;
    int[] marks;

    Student(String studentName , String[] subjects, int[] marks){
        this.studentName = studentName;
        this.subjects = subjects;
        this.marks = marks;

    }

    //Calculate Avg marks 
    double calculateAverage(){
        int total = 0;
        for(int mark : marks){
            total+= mark;

        }
        return (double) total / marks.length;
    }

    String assignGrade(double average){
        if (average >= 90)  return "A+";
        else if (average >= 75) return  "A";
        else if (average >= 60 ) return "B";
        else if (average >= 50 ) return "C";

        else return "Fail";
        
    }

    //Display Student Report 
    void displayReport(){
        double average = calculateAverage();
        String grade = assignGrade(average);

        System.out.println("\n==================");
        System.out.println("Student Name: "+ studentName);
        System.out.println("Subjects &  Marks:");
        for (int i = 0; i < subjects.length; i++) {
            System.out.println("  " +subjects[i] + " : "  + marks[i]);
        }
        System.out.printf("Average Marks: %.2f%n", average);
        System.out.println("Grade : " + grade);
        System.out.println("-----------------------------");

    }

}

//Main Class 

public class StudentReportGenerator{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        List<Student > studentList = new ArrayList<>();
        System.out.println("Enter no. of Students: ");
        int studentCount = sc.nextInt();
        sc.nextLine();
        for(int i = 1 ; i <= studentCount; i++){
            try {
                System.out.println("\nEnter Details for Student: " + i);

                System.out.print("Student Name: ");
                String name = sc.nextLine();

                System.out.print("Number of subjects: ");
                int subjectCount = sc.nextInt();
                sc.nextLine();

                String[] subjects = new String[subjectCount ];

                int[] marks = new int[subjectCount];

                for (int j = 0; j < subjectCount; j++){
                    System.out.print("Enter subject name: ");
                    subjects[j] = sc.nextLine();

                    System.out.print("Enter marks(0-100): ");

                    int enteredMarks = sc.nextInt();
                    sc.nextLine();

                    if (enteredMarks < 0 || enteredMarks > 100){
                        throw new InvalidMarkException("Invalid marks!!!! Marks must be between 0 and 100.");
                    }
                    marks[j] =  enteredMarks;
                }
                Student student = new Student( name , subjects, marks);

                studentList.add(student);

                    
                
            } 
            catch (InvalidMarkException e){
                System.out.println("Erorr " + e.getMessage());
                i--;
            }
           
        }
         System.out.println("\n====== STUDENT REPORT CARDS ======");
        for (Student student : studentList){
            student.displayReport();
        }


    }
}