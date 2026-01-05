import java.util.ArrayList;
import java.util.List;

interface Insurable{
    double calculateInsurance(double insurancePerDay,int days);
    String getInsuranceDetails();
}
abstract class Vehicle{
    private String vehicleNumber;
    private String type;
    private double rentalRate; // base rental rate
    public Vehicle(String vehicleNumber, String type, double rentalRate){
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }
    public void displayDetails() {
        System.out.println("Vehicle number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("rentalRate: " + rentalRate);
    }

    public double calculateInsurance(double insurancePerDay,int days){
        double totalInsurance = insurancePerDay * days; 
        return totalInsurance;
    }

    public double calculateRentalCost(int days){
        return rentalRate * days;
    }

    //Getter & Setter methods..
    public void setVehicleNumber(String vehicleNumber){
        this.vehicleNumber = vehicleNumber;
    }
    public String getVehicleNumber(){
        return vehicleNumber;
    }


    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }


    public void setRate(Double rentalRate){
        this.rentalRate = rentalRate;
    }
    public double getRentalRate(){
        return rentalRate;
    }


}


class Car extends Vehicle implements Insurable{

    public Car(double insurancePerDay, String vehicleNumber, String type, double rentalRate) {
        super(vehicleNumber, type, rentalRate);
    }
    @Override
    public String getInsuranceDetails(){
        return "Insurance for car is rs 500/day";
    }
    @Override
    public double calculateRentalCost(int days){
        return getRentalRate() * days;
    }

}


class Bike extends Vehicle implements Insurable{
    
    public Bike(double insurancePerDay, String vehicleNumber, String type, double rentalRate) {
        super(vehicleNumber, type, rentalRate);
    }
    @Override
    public String getInsuranceDetails(){
        return "Insurance for bike is rs 500/day";
    }
    @Override
    public double calculateRentalCost(int days){
        return getRentalRate() * days;
    }

}


class Truck extends Vehicle implements Insurable{
    


    public Truck(double insurancePerDay, String vehicleNumber, String type, double rentalRate) {
        super(vehicleNumber, type, rentalRate);
    }

    @Override
    public String getInsuranceDetails(){
        return "Insurance for truck is rs 500/day";
    }
    @Override
    public double calculateRentalCost(int days){
        return getRentalRate() * days;
    }

}
public class VehicleRental{
    public static void main(String[] args) {
        Car v1 = new Car(300,"abc01","car",500);
        Bike v2 = new Bike(100,"xyz98","bike",200);
        Truck v3 = new Truck(500,"ghj65","truck",800);


        // System.out.println(v1.calculateInsurance(5));
        // System.out.println(v1.calculateRentalCost(5));
        // v1.getInsuranceDetails();
        // v1.getVehicleNumber();

        // System.out.println();

        // v2.calculateInsurance(5);
        // v2.calculateRentalCost(5);
        // v2.getInsuranceDetails();
        // v2.getVehicleNumber();

        // System.out.println();

        // v3.calculateInsurance(5);
        // v3.calculateRentalCost(5);
        // v3.getInsuranceDetails();
        // v3.getVehicleNumber();

        // Polymorphic list
        List<Vehicle> vehicle = new ArrayList<>();
        vehicle.add(v1);
        vehicle.add(v2);
        vehicle.add(v3);

        // Process using Employee reference (polymorphism)
        for (Vehicle veh : vehicle) {
            System.out.println("----- Vehicle -----");
            veh.displayDetails();  // calls overridden version in subclass
            System.out.println("Total rent = " + veh.calculateRentalCost(5));
            System.out.println("Total Insurance cost of vehicle = " + veh.calculateInsurance(500, 5));
           
            System.out.println();
        }

    }

}