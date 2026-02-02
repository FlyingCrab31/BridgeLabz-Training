import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DatabaseToCSV{

    public static void main(String args[]){
        String url = "jdbc:mysql://localhost:3306/companydb";
        String user = "root";
        String password = "root";

        String csvFile = "employees_report.csv";

        try(
            Connection con = DriverManager.getConnection(url,user,password);
            Statement smt = con.createStatement();
            ResultSet rs = smt.executeQuery(
                "SELECT emp_id, name, department, salary FROM employees"
            );

            FileWriter fw = new FileWriter(csvFile)
        ){
            fw.write("Employee ID,Name,Department,Salary\n");

            while(rs.next()){
                fw.write(
                    rs.getInt("emp_id")+","+
                    rs.getString("name")+","+
                    rs.getString("department")+","+
                    rs.getDouble("salary")+"\n"
                );
            }
            System.out.println("Csv report generated successfully");
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
