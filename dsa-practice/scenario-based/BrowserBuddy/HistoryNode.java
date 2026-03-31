package BrowserBuddy;

class HistoryNode {

    String url;
    HistoryNode prev, next;

    HistoryNode(String url) {
        this.url = url;
    }
}
