import java.util.*;
public class UnitConversionSystem{
    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);

        System.out.println("1. Km to Miles OR 2. Kg to Lbs");
        System.out.print("Choose Conversion: ");
        int choice=sc.nextInt();

        switch(choice){
            case 1:
            System.out.print("Enter kilometers: ");
            double km=sc.nextDouble();
            System.out.println("Miles = "+UnitConverter.kmToMiles(km));
            break;

             case 2:
            System.out.print("Enter kilograms: ");
            double kg=sc.nextDouble();
            System.out.println("Pounds = "+UnitConverter.kgToLbs(kg));
            break;

            default:
                System.out.println("Invalid choice");
                return;
        }

    }
}