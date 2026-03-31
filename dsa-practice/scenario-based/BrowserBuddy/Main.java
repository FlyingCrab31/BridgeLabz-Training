package BrowserBuddy;

public class Main {
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
