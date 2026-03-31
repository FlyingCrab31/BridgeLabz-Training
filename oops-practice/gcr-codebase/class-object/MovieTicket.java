class MovieTicket {
    // Attributes
    String movieName;
    String seatNumber;
    double price;
    boolean isBooked;
    
    // Constructor to initialize the MovieTicket object
    public MovieTicket() {
        this.movieName = "";
        this.seatNumber = "";
        this.price = 0.0;
        this.isBooked = false;
    }
    
    // Method to book a ticket (assign seat and update price)
    public void bookTicket(String movieName, String seatNumber, double price) {
        if (!isBooked) {
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.price = price;
            this.isBooked = true;
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
        } else {
            System.out.println("House full!!! sorry..... Ticket already booked");
        }
    }
    
    // Method to display ticket details
    public void displayTicketDetails() {
        if (!isBooked) {
            System.out.println("Ticket have not booked yet....");
        } else {
            System.out.println("\nTicket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        }
    }
}

class Main {
    public static void main(String[] args) {
        // Create a movie ticket object
        MovieTicket ticket = new MovieTicket();
        
        // Try to display details before booking
        ticket.displayTicketDetails();
        
        // Book the ticket
        ticket.bookTicket("Dragon", "A10", 120.0);
        
        // Try to book the same ticket again (should show error)
        ticket.bookTicket("Dragon", "B15", 120.0);
        
        // Try to book the same ticket again (should show error)
        ticket.bookTicket("Avatar", "C20", 150.0);
        
        // Display price
        System.out.println("Price: $" + ticket.price);
        
        // Display complete ticket details
        ticket.displayTicketDetails();
    }
}
