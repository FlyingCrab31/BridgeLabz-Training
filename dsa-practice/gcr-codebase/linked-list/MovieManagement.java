class MovieNode {
    String title;
    String director;
    int year;
    double rating;

    MovieNode prev;
    MovieNode next;

    MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}

class MovieManagement {
    private MovieNode head;
    private MovieNode tail;
    private int size;
    public void addAtBeginning(String title, String director, int year, double rating) {
    MovieNode node = new MovieNode(title, director, year, rating);
    if (head == null) {
        head = tail = node;
    } else {
        node.next = head;
        head.prev = node;
        head = node;
    }
    size++;
}

public void addAtEnd(String title, String director, int year, double rating) {
    MovieNode node = new MovieNode(title, director, year, rating);
    if (tail == null) {
        head = tail = node;
    } else {
        tail.next = node;
        node.prev = tail;
        tail = node;
    }
    size++;
}

// position is 1-based: 1 = beginning
public void addAtPosition(int position, String title, String director, int year, double rating) {
    if (position <= 1) {
        addAtBeginning(title, director, year, rating);
        return;
    }
    if (position > size) {
        addAtEnd(title, director, year, rating);
        return;
    }

    MovieNode node = new MovieNode(title, director, year, rating);
    MovieNode current = head;
    int index = 1;
    while (index < position - 1) {
        current = current.next;
        index++;
    }
    // insert after current
    node.next = current.next;
    node.prev = current;
    current.next.prev = node;
    current.next = node;
    size++;
}
public void removeByTitle(String title) {
    if (head == null) return;

    MovieNode current = head;
    while (current != null && !current.title.equalsIgnoreCase(title)) {
        current = current.next;
    }
    if (current == null) {
        System.out.println("Movie not found: " + title);
        return;
    }

    // unlink current
    if (current == head) {
        head = head.next;
        if (head != null) head.prev = null;
    } else {
        current.prev.next = current.next;
    }

    if (current == tail) {
        tail = tail.prev;
        if (tail != null) tail.next = null;
    } else if (current.next != null) {
        current.next.prev = current.prev;
    }

    size--;
}

public void updateRatingByTitle(String title, double newRating) {
    MovieNode current = head;
    while (current != null) {
        if (current.title.equalsIgnoreCase(title)) {
            current.rating = newRating;
            return;
        }
        current = current.next;
    }
    System.out.println("Movie not found for rating update: " + title);
}
public void searchByDirector(String director) {
    MovieNode current = head;
    boolean found = false;
    while (current != null) {
        if (current.director.equalsIgnoreCase(director)) {
            printMovie(current);
            found = true;
        }
        current = current.next;
    }
    if (!found) System.out.println("No movies found for director: " + director);
}

public void searchByRating(double rating) {
    MovieNode current = head;
    boolean found = false;
    while (current != null) {
        if (current.rating == rating) {
            printMovie(current);
            found = true;
        }
        current = current.next;
    }
    if (!found) System.out.println("No movies found with rating: " + rating);
}

private void printMovie(MovieNode m) {
    System.out.println("Title: " + m.title +
            ", Director: " + m.director +
            ", Year: " + m.year +
            ", Rating: " + m.rating);
}
public void displayForward() {
    if (head == null) {
        System.out.println("No movies in list");
        return;
    }
    System.out.println("Movies (forward):");
    MovieNode current = head;
    while (current != null) {
        printMovie(current);
        current = current.next;
    }
}

public void displayReverse() {
    if (tail == null) {
        System.out.println("No movies in list");
        return;
    }
    System.out.println("Movies (reverse):");
    MovieNode current = tail;
    while (current != null) {
        printMovie(current);
        current = current.prev;
    }
}
    public static void main(String[] args) {

        MovieManagement movies = new MovieManagement();

        // 1. Add movies at beginning, end, and specific positions
        movies.addAtBeginning("Inception", "Christopher Nolan", 2010, 9.0);
        movies.addAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        movies.addAtEnd("The Dark Knight", "Christopher Nolan", 2008, 9.1);

        // insert at position 2 (between Inception and Interstellar)
        movies.addAtPosition(2, "Tenet", "Christopher Nolan", 2020, 7.5);

        // 2. Display forward
        System.out.println("All movies (forward):");
        movies.displayForward();

        // 3. Display reverse
        System.out.println("\nAll movies (reverse):");
        movies.displayReverse();

        // 4. Search by director
        System.out.println("\nSearch by director 'Christopher Nolan':");
        movies.searchByDirector("Christopher Nolan");

        // 5. Search by rating
        System.out.println("\nSearch by rating 9.0:");
        movies.searchByRating(9.0);

        // 6. Update rating by title
        System.out.println("\nUpdating rating of 'Tenet' to 8.0");
        movies.updateRatingByTitle("Tenet", 8.0);
        System.out.println("After update:");
        movies.displayForward();

        // 7. Remove movie by title
        System.out.println("\nRemoving 'Interstellar':");
        movies.removeByTitle("Interstellar");
        System.out.println("After removal:");
        movies.displayForward();
    }
}

