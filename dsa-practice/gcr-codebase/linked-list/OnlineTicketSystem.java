import java.util.Scanner;

class TicketNode{
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;


    TicketNode(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}
public class OnlineTicketSystem{
    private TicketNode head = null;
    private TicketNode tail = null;;


    //Add a new ticket
    public void addTicket(int id , String name , String movie , String seat , String time){
        TicketNode newNode = new TicketNode(id, name, movie, seat, time);
        if(head == null){
            head = newNode;
            tail = newNode;
            newNode.next = head;

        }else{
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        System.out.println("\nSuccess : Ticket booked for : " + name);
    }
    //Remove ticket by id 
    public void removeTicket(int id){
        if(head == null){
            System.out.println("Error : List is Empty");
            return;
        }
        TicketNode curr = head, prev = null;
        boolean found = false;

        do{
            if(curr.ticketID == id){
                if(curr == head && curr == tail){
                    head = null;
                    tail = null;


                }else if(curr == head){
                    head = head.next;
                    tail.next = head;

                }else if(curr == tail){
                    tail = prev;
                    tail.next = head;
                }else{
                    prev.next = curr.next;
                }
                found = true;
                break;
            }
            prev = curr;
            curr = curr.next;

        }while(curr != head);
        if(found)System.out.println("Ticked Id : " + id + "has been cancelled");
        else System.out.println("Error Ticket not found");

    }

    //Disply all tickets 
    public void displayTickets(){
        if(head == null){
            System.out.println("\n ---No Active Bookings ----");
            return;
        }
        TicketNode temp = head;
        System.out.println("\n Current Bookings");
        do { 
            System.out.println("[ " + temp.ticketID + " ] Name: " + temp.customerName + 
                               " | Movie: " +temp.movieName + " | Seat: " + temp.seatNumber) ;
            temp = temp.next;
            
        } while (temp != head);

    }

    //Search by name or movie 
    public void searchTicket(String query){
        if(head == null){
            System.out.println("List is Empty");
            return;
        }
        TicketNode temp = head;
        boolean found = false;

        do {
            if (temp.customerName.equalsIgnoreCase(query) || temp.movieName.equalsIgnoreCase(query)){
                System.out.println(" Result: ID " + temp.ticketID + " | Name: " + temp.customerName + " | Seat: " + temp.seatNumber ) ;
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No matching records found");
    }

        //Count tickets 
        public int countTickets(){
            if(head == null)
                return 0;
            int count = 0 ;
            TicketNode temp = head;
            do { 
                count++;
                temp = temp.next;
                
            } while(temp != head);
            return count;
        }

        public static void main(String[] args) {
            OnlineTicketSystem system = new OnlineTicketSystem();
            Scanner sc =new Scanner(System.in);
            int choice;
            System.out.println(" Welcome to Online Ticket Reservation System ");
            do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket (Remove by ID)");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search Ticket (by Name/Movie)");
            System.out.println("5. Show Total Count");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch(choice) {
                case 1:
                    System.out.print("Enter Ticket ID : ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Customer Name : ");
                    String name = sc.nextLine();
                    System.out.print("Enter Movie Name : ");
                    String movie = sc.nextLine();
                    System.out.print("Enter Seat Number : ");
                    String seat = sc.nextLine();
                    System.out.print("Enter Booking Time : ");
                    String time = sc.nextLine();
                    system.addTicket(id, name, movie, seat, time);
                    break;
                case 2:
                    System.out.print("Enter Ticket ID to cancel : ");
                    int delId = sc.nextInt();
                    system.removeTicket(delId) ;
                    break;

                case 3:
                    system.displayTickets();
                    break;

                case 4:
                    System.out.print("Search keyword (Name/Movie) : ");
                    String query = sc.nextLine();
                    system.searchTicket(query);
                    break;

                case 5:
                    System.out.println(" Total booked tickets : " + system.countTickets());
                    break;
                case 6:
                    System.out.println(" Exiting system Goodbye");
                    break;
                default:
                    System.out.println(" Invalid choice Try again");
            }
        } while (choice != 6);
            
        
    }

}