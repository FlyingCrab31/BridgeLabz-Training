
import java.util.*;

class HistoryNode {

    String url;
    HistoryNode prev, next;

    HistoryNode(String url) {
        this.url = url;
    }
}

class Tab {

    private String id;
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

class BrowserBuddy {

    private Map<String, Tab> openTabs = new HashMap<>();
    private Deque<Tab> closedTabs = new ArrayDeque<>(); // stack (LIFO)

    public Tab openTab(String id, String homepage) {
        Tab tab = new Tab(id, homepage);
        openTabs.put(id, tab);
        return tab;
    }

    public void closeTab(String id) {
        Tab tab = openTabs.remove(id);
        if (tab != null) {
            closedTabs.push(tab); // push to stack for restore
            System.out.println("Closed tab: " + id);
        }
    }

    public void restoreLastClosed() {
        if (closedTabs.isEmpty()) {
            System.out.println("No recently closed tab to restore");
            return;
        }
        Tab tab = closedTabs.pop(); // LIFO restore
        openTabs.put(tab.getId(), tab);
        System.out.println("Restored tab: " + tab.getId()
                + " at URL: " + tab.getCurrentUrl());
    }

    public Tab getTab(String id) {
        return openTabs.get(id);
    }

    public static void main(String[] args) {
        BrowserBuddy browser = new BrowserBuddy();

        Tab t1 = browser.openTab("tab1", "homepage.com");
        t1.visit("google.com");
        t1.visit("facebook.com");
        t1.visit("youtube.com");

        t1.back(1);      // facebook
        t1.back(1);      // google
        t1.forward(1);   // facebook

        browser.closeTab("tab1");
        browser.restoreLastClosed(); // brings back tab1 at facebook.com
    }
}
