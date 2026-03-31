package BrowserBuddy;

public class Tab {
    private final String id;
    private HistoryNode current;

    public Tab(String id, String homepage) {
        this.id = id;
        this.current = new HistoryNode(homepage);
    }

    public String getId() {
        return id;
    }

    // visit new URL: cut off forward history then append new node
    public void visit(String url) {
        HistoryNode newNode = new HistoryNode(url);
        // break any forward chain
        if (current != null) {
            current.next = null;
            newNode.prev = current;
        }
        current.next = newNode;
        current = newNode;
    }

    public void back(int steps) {
        while (steps > 0 && current.prev != null) {
            current = current.prev;
            steps--;
        }
        System.out.println("Current after back: " + current.url);
    }

    public void forward(int steps) {
        while (steps > 0 && current.next != null) {
            current = current.next;
            steps--;
        }
        System.out.println("Current after forward: " + current.url);
    }

    public String getCurrentUrl() {
        return current != null ? current.url : null;
    }

}
