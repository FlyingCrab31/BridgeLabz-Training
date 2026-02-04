import java.util.*;

interface SensitiveData{


}

class UserCredentials implements SensitiveData{
    String password;

    UserCredentials(String password){
        this.password=password;
    }
}

class PublicInfo{
    String info;

    PublicInfo(String info){
        this.info=info;
    }
}

class EncryptionService{
    public static void process(Object obj){
        if(obj instanceof SensitiveData){
            System.out.println("Sensitive Data detected...Encryption applied");
        }
        else{
            System.out.println("Public Data..No encryption applied");
        }
    }


}


public class SensitiveDataTagging{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

         System.out.println("Choose data type:");
        System.out.println("1. User Credentials");
        System.out.println("2. Public Info");

        int choice=sc.nextInt();
        sc.nextLine();

        Object obj;

        if(choice==1){
            System.out.print("Enter password: ");
            String pwd = sc.nextLine();

            obj = new UserCredentials(pwd);
        }

        else{
             System.out.print("Enter public info: ");
            String info = sc.nextLine();

            obj = new PublicInfo(info);
        }

        EncryptionService.process(obj);

    }
}