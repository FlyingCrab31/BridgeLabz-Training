package TrafficManager;

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
