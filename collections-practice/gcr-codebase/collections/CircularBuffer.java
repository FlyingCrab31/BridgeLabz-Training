
public class CircularBuffer {

    private int[] buffer;
    private int head = 0;      // index of oldest element
    private int tail = 0;      // index for next writing
    private int size = 0;
    private int capacity;

    public CircularBuffer(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be > 0");
        }
        this.capacity = capacity;
        this.buffer = new int[capacity];
    }

    // insert element, overwriting oldest if full
    public void add(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % capacity;

        if (size < capacity) {
            size++;
        } else {
            // buffer full, move head forward (drop oldest)
            head = (head + 1) % capacity;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    // iterate current contents from oldest to newest
    public void printBuffer() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            int idx = (head + i) % capacity;
            System.out.print(buffer[idx]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);

        cb.add(1);
        cb.add(2);
        cb.add(3);
        cb.printBuffer();       // [1, 2, 3]

        cb.add(4);              // overwrites 1
        cb.printBuffer();       // [2, 3, 4]

        cb.add(5);              // overwrites 2
        cb.printBuffer();       // [3, 4, 5]
    }
}
