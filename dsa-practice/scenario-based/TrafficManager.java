
class Vehicle {

    private String number;
    private String type;

    public Vehicle(String number, String type) {
        this.number = number;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number + "(" + type + ")";
    }
}

class Roundabout {

    private static class Node {

        Vehicle data;
        Node next;

        Node(Vehicle data) {
            this.data = data;
        }
    }

    private Node tail; // tail.next is head

    public boolean isEmpty() {
        return tail == null;
    }

    // Add car at end of circular list
    public void addCar(Vehicle v) {
        Node newNode = new Node(v);
        if (tail == null) {          // first node
            tail = newNode;
            tail.next = tail;        // circular link
        } else {
            newNode.next = tail.next; // head
            tail.next = newNode;
            tail = newNode;           // new tail
        }
    }

    // Remove by vehicle number
    public boolean removeCar(String vehicleNumber) {
        if (tail == null) {
            return false;
        }

        Node curr = tail.next; // head
        Node prev = tail;

        do {
            if (curr.data.getNumber().equals(vehicleNumber)) {
                // Only one node
                if (curr == tail && curr.next == tail) {
                    tail = null;
                } else {
                    prev.next = curr.next;
                    if (curr == tail) {
                        tail = prev; // deleted tail
                    }
                }
                return true;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != tail.next);

        return false; // not found
    }

    public void printState() {
        if (tail == null) {
            System.out.println("Roundabout is empty");
            return;
        }
        Node temp = tail.next; // head
        System.out.print("Roundabout: ");
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != tail.next);
        System.out.println("(back to start)");
    }
}

class WaitingQueue {

    private Vehicle[] arr;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public WaitingQueue(int capacity) {
        this.capacity = capacity;
        this.arr = new Vehicle[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(Vehicle v) {
        if (isFull()) {
            System.out.println("Queue Overflow: Cannot add " + v);
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = v;
        size++;
    }

    public Vehicle dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow: No vehicles waiting");
            return null;
        }
        Vehicle v = arr[front];
        front = (front + 1) % capacity;
        size++;
        size--;
        return v;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Waiting Queue is empty");
            return;
        }
        System.out.print("Waiting Queue: ");
        for (int i = 0; i < size; i++) {
            int idx = (front + i) % capacity;
            System.out.print(arr[idx] + " <- ");
        }
        System.out.println("END");
    }
}

class TrafficManager {

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
            System.out.println("Vehicle " + vehicleNumber + " not found on roundabout");
        }
    }

    public void printSystemState() {
        roundabout.printState();
        queue.printQueue();
    }

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
