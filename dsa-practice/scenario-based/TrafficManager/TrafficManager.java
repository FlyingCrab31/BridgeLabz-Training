package TrafficManager;

public class TrafficManager {
    private Roundabout roundabout;
    private WaitingQueue queue;
    private int roundaboutCapacity;

    public TrafficManager(int roundaboutCapacity, int queueCapacity) {
        this.roundabout = new Roundabout();
        this.queue = new WaitingQueue(queueCapacity);
        this.roundaboutCapacity = roundaboutCapacity;
    }

    public void vehicleArrives(Vehicle v) {
        // if no explicit roundabout capacity constraint, just call roundabout.addCar(v)
        queue.enqueue(v);
    }

    public void moveFromQueueToRoundabout() {
        if (queue.isEmpty()) {
            return;
        }
        Vehicle v = queue.dequeue();
        if (v != null) {
            roundabout.addCar(v);
        }
    }

    public void vehicleExits(String vehicleNumber) {
        boolean removed = roundabout.removeCar(vehicleNumber);
        if (removed) {
            moveFromQueueToRoundabout();
        } else {
            System.out.println("TrafficManager.Vehicle " + vehicleNumber + " not found on roundabout");
        }
    }

    public void printSystemState() {
        roundabout.printState();
        queue.printQueue();
    }

}
