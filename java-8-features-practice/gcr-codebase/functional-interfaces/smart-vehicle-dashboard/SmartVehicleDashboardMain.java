import java.util.*;

public class SmartVehicleDashboardMain{

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        Vehicle vehicle;

        System.out.print("Enter 1. Car Or 2. Electric Vehicle: ");
        int choice=sc.nextInt();

        System.out.println("Enter speed: ");
        int speed=sc.nextInt();

        if(choice==1){
            vehicle=new Car();
        }
        else if(choice==2){
            vehicle=new ElectricCar();

        }
        else{
            System.out.println("Invalid choice");
            return;
        }
        vehicle.displaySpeed(speed);
        vehicle.displayBatteryPercentage();
    }
}