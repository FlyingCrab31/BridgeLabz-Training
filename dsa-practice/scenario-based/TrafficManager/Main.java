package TrafficManager;

public class Main {
    public static void main(String[] args) {
        TrafficManager manager = new TrafficManager(5, 3);

        Vehicle v1 = new Vehicle("UP32AA1111", "Car");
        Vehicle v2 = new Vehicle("UP32BB2222", "Bus");
        Vehicle v3 = new Vehicle("UP32CC3333", "Bike");

        manager.vehicleArrives(v1);
        manager.vehicleArrives(v2);
        manager.vehicleArrives(v3);

        // Move some into roundabout
        manager.moveFromQueueToRoundabout();
        manager.moveFromQueueToRoundabout();

        manager.printSystemState();

        manager.vehicleExits("UP32AA1111");
        manager.printSystemState();
    }

}
