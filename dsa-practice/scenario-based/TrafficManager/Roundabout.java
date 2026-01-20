package TrafficManager;

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
