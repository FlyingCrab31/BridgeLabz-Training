class Employee{
    static String companyName = "XYZ Company";
    private static final int totalEmployees = 5000;
    private String name;
    private final int id;
    private String designation;


    static void displayTotalEmployees(){
        System.out.println(totalEmployees);
    }

    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
    }

    // Method to display book details
    void displayDetails() {
        System.out.println("Name : " + name);
        System.out.println("Id: " + id);
        System.out.println("Designation  : " + designation);
    }

    public static void main(String[] args) {
        System.out.print("Total No. of Employees = ");
        displayTotalEmployees();
        System.out.println("Company Name :" + companyName);
        Object obj1 = new Employee("Ankit",23,"Designer");
        Object obj2 = "hi";
        if(obj1 instanceof Employee){
            Employee emp = (Employee) obj1;
            emp.displayDetails();
        }
        if(obj2 instanceof Employee){
            Employee emp = (Employee) obj2;
            emp.displayDetails();
        }

    }

    

}