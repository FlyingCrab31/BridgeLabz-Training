class Vehicle {
    protected int maxSpeed;
    protected String model;

    public Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    public void displayInfo() {
        System.out.println("Model    : " + model);
        System.out.println("MaxSpeed : " + maxSpeed + " km/h");
    }
}
interface Refuelable {
    void refuel();
}
class ElectricVehicle extends Vehicle {
    private final int batteryCapacity; // in kWh

    public ElectricVehicle(int maxSpeed, String model, int batteryCapacity) {
        super(maxSpeed, model);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() {
        System.out.println("Charging electric vehicle " + model +
                           " with battery capacity " + batteryCapacity + " kWh.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Battery  : " + batteryCapacity + " kWh");
    }
}
class PetrolVehicle extends Vehicle implements Refuelable {
    private final int fuelTankCapacity; // in liters

    public PetrolVehicle(int maxSpeed, String model, int fuelTankCapacity) {
        super(maxSpeed, model);
        this.fuelTankCapacity = fuelTankCapacity;
    }

    @Override
    public void refuel() {
        System.out.println("Refueling petrol vehicle " + model +
                           " up to " + fuelTankCapacity + " liters.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("FuelTank : " + fuelTankCapacity + " L");
    }
}
public class VehicleDemo1 {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle(160, "Tesla Model 3", 75);
        PetrolVehicle pv = new PetrolVehicle(200, "Honda City", 45);

        ev.displayInfo();
        ev.charge();

        System.out.println();

        pv.displayInfo();
        pv.refuel();
    }
}
