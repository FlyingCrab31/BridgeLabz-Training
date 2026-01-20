package BrowserBuddy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

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

}
