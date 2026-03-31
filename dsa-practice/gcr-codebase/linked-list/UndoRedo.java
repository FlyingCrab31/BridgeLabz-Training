class TextStateNode {
    String text;
    TextStateNode prev;
    TextStateNode next;

    TextStateNode(String text) {
        this.text = text;
        this.prev = null;
        this.next = null;
    }
}

public class UndoRedo {
    private TextStateNode head;      // oldest state
    private TextStateNode tail;      // newest state
    private TextStateNode current;   // current state
    private int size;                // number of stored states
    private final int LIMIT;         // max history size

    public UndoRedo(int limit) {
        this.LIMIT = limit;
        this.head = this.tail = this.current = null;
        this.size = 0;
    }

public void addState(String newText) {
    // 1. If we are in the middle (after some undo), drop all redo history
    if (current != null && current.next != null) {
        TextStateNode temp = current.next;
        while (temp != null) {
            TextStateNode next = temp.next;
            temp.prev = temp.next = null;
            temp = next;
            size--;                // we are removing states
        }
        current.next = null;
        tail = current;
    }

    // 2. Create new node and append at end
    TextStateNode node = new TextStateNode(newText);

    if (head == null) {            // first state
        head = tail = current = node;
        size = 1;
    } else {
        tail.next = node;
        node.prev = tail;
        tail = node;
        current = node;
        size++;
    }

    // 3. Enforce fixed history size
    while (size > LIMIT) {
        // remove node from head
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        size--;
        // if current was also shifted out (only possible if limit is 0 in weird cases),
        // adjust, but with positive LIMIT current will still be in the list
    }
}
public void undo() {
    if (current != null && current.prev != null) {
        current = current.prev;  // move one step back
    } else {
        System.out.println("Nothing to undo");
    }
}

public void redo() {
    if (current != null && current.next != null) {
        current = current.next;  // move one step forward
    } else {
        System.out.println("Nothing to redo");
    }
}
public String getCurrentText() {
    if (current == null) return "";
    return current.text;
}

public void printCurrentState() {
    System.out.println("Current text: \"" + getCurrentText() + "\"");
}

    public static void main(String[] args) {
        UndoRedo editor = new UndoRedo(10); // limit last 10 states

        editor.addState("");              // initial empty state
        editor.addState("H");
        editor.addState("He");
        editor.addState("Hel");
        editor.addState("Hell");
        editor.addState("Hello");

        editor.printCurrentState();       // Hello

        editor.undo();
        editor.printCurrentState();       // Hell

        editor.undo();
        editor.printCurrentState();       // Hel

        editor.redo();
        editor.printCurrentState();       // Hell

        // New typing after undo: breaks redo chain
        editor.addState("Hello!");
        editor.printCurrentState();       // Hello!

        // multiple undos, redos as needed...
    }
}


