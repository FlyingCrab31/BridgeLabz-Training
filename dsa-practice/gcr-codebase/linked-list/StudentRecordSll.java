
class Node {

    int rollNo;
    String name;
    int age;
    char grade;
    Node next;

    public Node(int rollNo, String name, int age, char grade, Node next) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }

}

// Class
public class StudentRecordSll {

    Node head;

    public void insertAtEnd(int rollNo, int age, String name, char grade) {
        Node newNode = new Node(rollNo, name, age, grade, null);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void insertAtBegining(int rollNo, int age, String name, char grade) {
        this.head = new Node(rollNo, name, age, grade, null);
    }

    public void insertAtSpecificPosition(int rollNo, int age, String name, char grade) {
        Node node = new Node(rollNo, name, age, grade, null);
        if (head == null) {
            head = node;
        } else {
            Node current = head;
            int count = 1;
            while (current.next != null && count < 2) {
                current = current.next;
                count++;
            }
            current.next = node;
        }
    }

    public void deleteByRoll(int rollNo) {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.rollNo == rollNo) {
            head = head.next;
            return;
        }
        Node current = head;
        Node previous = null;
        //for searching the particular roll No.
        while (current != null && current.rollNo != rollNo) {
            previous = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("Record not found");
            return;
        }
        previous.next = current.next;
    }

    public Node searchByRoll(int rollNo) {
        Node current = head;
        if (head == null) {
            System.out.println("Not found");
            return null;
        }
        if (head.rollNo == rollNo) {
            head = head.next;
            return current;

        } else {
            while (current != null && current.rollNo != rollNo) {
                current = current.next;
            }
            if (current == null) {
                System.out.println("Not found");
                return null;
            }
            return current;
        }
    }

    public void updateGradeByRoll(int rollNo, char grade) {
        Node current = head;
        if (head == null) {
            System.out.println("Not Found");
            return;
        }
        if (head.rollNo == rollNo) {
            head.grade = 'A';
        } else {
            while (current != null && current.rollNo != rollNo) {
                current = current.next;
            }
            if (current == null) {
                System.out.println("Not Found");
                return;
            }
            current.grade = 'A';
        }
    }

    public void displayRecords() {
        Node current = head;
        while (current != null) {
            System.out.println("Roll No: " + current.rollNo + ", Name: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        StudentRecordSll obj = new StudentRecordSll();
        obj.insertAtBegining(23, 18, "rishabh", 'A');
        obj.insertAtSpecificPosition(15, 19, "Akash", 'C');
        obj.insertAtEnd(87, 12, "Willams", 'B');
        // obj.displayRecords();
        // System.out.println();
        // obj.deleteByRoll(15);
        // obj.displayRecords();
        Node record = obj.searchByRoll(23);
        System.out.println("Name : " + record.name + " , Age : " + record.age + " , Grade : " + record.grade);

    }
}
