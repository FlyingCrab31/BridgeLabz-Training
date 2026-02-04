import java.time.LocalDate;
import java.util.*;

public class DateFormatUtility{

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter date (YYYY-MM-DD): ");
        String inputDate=sc.nextLine();

        System.out.println("Choose format:");
        System.out.println("1. dd-MM-yyyy");
        System.out.println("2. dd/MM/yyyy");
        System.out.println("3. MMM dd, yyyy");

        int choice=sc.nextInt();
        String pattern;

        switch(choice){
            case 1:
                pattern="dd-MM-yyyy";
                break;
              case 2:
                pattern="dd/MM/yyyy";
                break;
              case 3:
                pattern="MMM dd, yyyy";
                break; 
             default:
                System.out.println("Invalid Choice");
                return;          

        }

        LocalDate date=LocalDate.parse(inputDate);
        String  formattedDate=DateUtils.dateFormat(date,pattern);
        System.out.println("Formatted Date: "+formattedDate);
    }
}