public class ElectricCar implements Vehicle{

    public void displaySpeed(int speed){
        System.out.println("Electeric Car Speed: "+speed+"km/hr");

    }

    @Override

    public void displayBatteryPercentage(){
        System.out.println("Battery Level:  75%");
    }
}