import java.util.*;

public class PasswordStrengthValidator{

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter Password: ");
        String password=sc.nextLine();

        if(SecurityUtils.isPasswordStrong(password)){
            System.out.println("Password is strong");
        }
        else{
            System.out.println("Password is weak");
        }


    }
}