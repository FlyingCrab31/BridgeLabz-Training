import java.util.*;
import java.io.Serializable;

class Employee implements Serializable{
    int id;
    String name;

    Employee(int id, String name){
        this.id=id;
        this.name=name;
    }
}

class TempSession{
    String sessionId;
    TempSession(String sessionId){
        this.sessionId=sessionId;
    }

}


class BackUpService{
    public static void backup(Object obj){
        if(obj instanceof Serializable){
            System.out.println("Backup allowed");

        }
        else{
            System.out.println("Backup denied");
        }
    }

}

public class DataSerializableBackup{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        System.out.println("Select data type for backup:");
        System.out.println("1. Employee Data");
        System.out.println("2. Temporary Session Data");

        int choice=sc.nextInt();
        sc.nextLine();

        Object obj;
        if(choice==1){
            System.out.print("Enter employee id: ");
            int id=sc.nextInt();
            sc.nextLine();

            System.out.print("Enter employee name: ");
            String name=sc.nextLine();

            obj=new Employee(id,name);
        }
        else if(choice==2){
            System.out.print("Enter Session id: ");
            String sessionId=sc.nextLine();

            obj=new TempSession(sessionId);
        }

        else{
            System.out.println("Invalid choice");
            return;
        }
        BackUpService.backup(obj);
        


    }

}