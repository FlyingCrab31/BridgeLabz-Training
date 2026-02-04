import java.util.*;

public class VehicleRentalSystem{

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        Vehicle vehicle;

        System.out.print("Enter vehicle (car/bike/bus): ");
        String vehicleInput = sc.nextLine().toLowerCase();

        switch(vehicleInput){
            case "car":
                vehicle=new Car();
                break;

                case "bike":
                vehicle=new Bike();
                break;

                case "bus":
                vehicle=new Bus();
                break;

                default:
                System.out.println("Invalid vehicle type");
                return;
        
        }

        System.out.print("Enter action (rent/return): ");
        String actionInput = sc.nextLine().toLowerCase();

        if(actionInput.equals("rent")){
            vehicle.rent();
        }else if(actionInput.equals("return")){
            vehicle.returnVehicle();
        }else{
            System.out.println("Invalid action");
        
        }




    }
}