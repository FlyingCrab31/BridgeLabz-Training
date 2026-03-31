// Vehicle node for both roundabout and queue
class Vehicle {
    int id;
    String plate;
    Vehicle next; // used only inside roundabout (circular linked list)

    Vehicle(int id, String plate) {
        this.id = id;
        this.plate = plate;
    }

    @Override
    public String toString() {
        return "Car{" + id + ", " + plate + "}";
    }
}

// Simple array-based queue with overflow/underflow checks
class VehicleQueue {
    private Vehicle[] arr;
    private int front;
    private int rear;
    private int size;
    private final int capacity;

    VehicleQueue(int capacity) {
        this.capacity = capacity;
        this.arr = new Vehicle[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(Vehicle v) {
        if (isFull()) {
            System.out.println("Queue overflow: cannot add " + v);
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = v;
        size++;
        System.out.println(v + " joined waiting queue.");
    }

    public Vehicle dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow: no waiting vehicles.");
            return null;
        }
        Vehicle v = arr[front];
        front = (front + 1) % capacity;
        size--;
        return v;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Waiting Queue: EMPTY");
            return;
        }
        System.out.print("Waiting Queue: ");
        for (int i = 0; i < size; i++) {
            int idx = (front + i) % capacity;
            System.out.print(arr[idx] + (i < size - 1 ? " <- " : ""));
        }
        System.out.println();
    }
}

// Roundabout implemented as a circular singly linked list
class Roundabout {
    private Vehicle last;         // reference to last node in circular list
    private int size;
    private final int maxCapacity;      // max cars allowed in roundabout

    Roundabout(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public boolean isFull() {
        return size == maxCapacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // low-level: insert car into circular list at "end"
    private void addCarInternal(Vehicle v) {
        if (last == null) { // empty list
            last = v;
            v.next = v; // points to itself
        } else {
            v.next = last.next; // new car points to first
            last.next = v;      // old last points to new
            last = v;           // new last
        }
        size++;
    }

    // car exits from "front" (node after last)
    private Vehicle removeCarInternal() {
        if (isEmpty()) {
            return null;
        }
        Vehicle first = last.next;
        if (first == last) { // only one car
            last = null;
        } else {
            last.next = first.next; // skip the first
        }
        first.next = null; // detach
        size--;
        return first;
    }

    // API used by TrafficManager
    public boolean tryEnter(Vehicle v) {
        if (isFull()) {
            return false;
        }
        addCarInternal(v);
        System.out.println(v + " entered roundabout.");
        return true;
    }

    public Vehicle exit() {
        Vehicle v = removeCarInternal();
        if (v != null) {
            System.out.println(v + " exited roundabout.");
        } else {
            System.out.println("No car inside roundabout to exit.");
        }
        return v;
    }

    public void printState() {
        if (isEmpty()) {
            System.out.println("Roundabout: EMPTY");
            return;
        }
        System.out.print("Roundabout: ");
        Vehicle curr = last.next; // first car
        do {
            System.out.print(curr + " -> ");
            curr = curr.next;
        } while (curr != last.next);
        System.out.println("(back to start)");
    }
}

// Traffic manager: coordinates roundabout + waiting queue
public class TrafficManager {
    private Roundabout roundabout;
    private VehicleQueue waitingQueue;

    public TrafficManager(int roundaboutCapacity, int queueCapacity) {
        this.roundabout = new Roundabout(roundaboutCapacity);
        this.waitingQueue = new VehicleQueue(queueCapacity);
    }

    // Car arrives: try to enter roundabout; if full, go to queue
    public void arrive(Vehicle v) {
        if (!roundabout.tryEnter(v)) {
            waitingQueue.enqueue(v);
        }
    }

    // One car exits; if space becomes free, pull one from queue
    public void processExit() {
        roundabout.exit();
        if (!roundabout.isFull() && !waitingQueue.isEmpty()) {
            Vehicle next = waitingQueue.dequeue();
            if (next != null) {
                roundabout.tryEnter(next);
            }
        }
    }

    public void printState() {
        roundabout.printState();
        waitingQueue.printQueue();
        System.out.println("-----------------------------");
    }

    // Simple demo
    public static void main(String[] args) {
        TrafficManager tm = new TrafficManager(3, 5); // 3 cars inside max, 5 in waiting queue

        tm.arrive(new Vehicle(1, "UP01-AA-1111"));
        tm.arrive(new Vehicle(2, "UP01-AA-2222"));
        tm.arrive(new Vehicle(3, "UP01-AA-3333"));
        tm.arrive(new Vehicle(4, "UP01-AA-4444")); // goes to queue
        tm.arrive(new Vehicle(5, "UP01-AA-5555")); // goes to queue
        tm.arrive(new Vehicle(6, "UP01-AA-6666")); // goes to queue
        tm.arrive(new Vehicle(7, "UP01-AA-7777")); // goes to queue
        tm.arrive(new Vehicle(8, "UP01-AA-8888")); // overflow in queue

        tm.printState();

        tm.processExit(); // one exits, one from queue enters
        tm.printState();

        tm.processExit();
        tm.printState();

        tm.processExit();
        tm.printState();

        // extra exits to show underflow inside + queue empty
        tm.processExit();
        tm.processExit();
    }
}
