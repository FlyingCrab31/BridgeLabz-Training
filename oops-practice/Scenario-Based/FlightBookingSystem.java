import java.util.*;

class Flight{
    int flightId;
    String source;
    String destination;
    int seats;


    public Flight(int flightId, String source, String destination, int seats){
        this.flightId=flightId;
        this.source=source;
        this.destination=destination;
        this.seats=seats;
    }
}


class Booking{

    int bookingId;
    String passengerName;
    Flight flight;
    String status;

    public Booking(int bookingId, String passengerName, Flight flight){
        this.bookingId=bookingId;
        this.passengerName=passengerName;
        this.flight=flight;
        this.status="confirmed";
    }



}


//main

public class FlightBookingSystem{
//array banaya flight ki info store karne ke liye
    static Flight[] flight={
        new Flight(101,"delhi","mumbai",10),
        new Flight(102,"delhi","hyderabad",12),
        new Flight(103,"prayagraj","hyderabad",15),
        new Flight(104,"lucknow","bangalore",29),
        new Flight(105,"delhi","praygraj",12)

    };





    static List<Booking> bookings=new ArrayList<>();

    static int bookingCounter=1;

    static void searchFlight(String src, String dest){
        
        boolean found=false;
        for(Flight f:flight){
            if(f.source.equalsIgnoreCase(src) && f.destination.equalsIgnoreCase(dest)){
                System.out.println("flight id: "+f.flightId+" seats available: "+f.seats);
                found =true;
            }

        }

        if(!found){
            System.out.println("no flight found on this route...");
        }
    }



    static void bookFlight(int flightId,String name){
        for(Flight f:flight){
            if(f.flightId==flightId && f.seats>0){
                f.seats--;
                bookings.add(new Booking(bookingCounter++,name,f));
                System.out.println("booking sucessfull");
                return ;
            }
        }

        System.out.println("no seats available...");
    }



    static void viewBookings(){

        if(bookings.isEmpty()) {
            System.out.println("no boookings found...");
            return;
        }
        for(Booking b:bookings){
            System.out.println("booking id: "+b.bookingId+" passenger name: "+b.passengerName+" flight id: "+b.flight.flightId+" route: "+b.flight.source+" to "+b.flight.destination+" status: "+b.status);

        }
    }


    static void cancelBooking(int bookingId){
        for(Booking b:bookings){
            if(b.bookingId==bookingId && b.status.equalsIgnoreCase("confirmed")){
                b.status="cancelled";
                b.flight.seats++;
                System.out.println("booking cancelled");
                return;
            }
        }
        System.out.println("booking not found or already cancelled...");
    }


    public static void trackstatus(int bookingId){
        for(Booking b:bookings){
            if(b.bookingId==bookingId){
                System.out.println("booking id:"+bookingId+"status: "+b.status);
                return;
            }
        }
        System.out.println("booking not found...");
    }


    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int choice;

        do{

        System.out.println("----flight booking system----");
        System.out.println("1. search flight");
        System.out.println("2. book flight");
        System.out.println("3. view bookings");
        System.out.println("4. cancel booking");
        System.out.println("5. track booking status");
        System.out.println("0. exit");
        System.out.println("enter choice");
        choice=sc.nextInt();
        sc.nextLine();

        switch (choice){
            case 1:
                System.out.print("enter source: ");
                String src=sc.nextLine();
               

                System.out.print("enter destination: ");
                String dest=sc.nextLine();

                searchFlight(src,dest);
                break;
        

        case 2:
            System.out.print("enter flight id: ");
            int flightId=sc.nextInt();
            sc.nextLine();

            System.out.print("enter passenger name: ");
            String name=sc.nextLine();

            bookFlight(flightId,name);
            break;

        case 3:
            viewBookings();
            break;

        case 4:
            System.out.print("enter booking id: ");
            int bookingId=sc.nextInt();
            sc.nextLine();

            cancelBooking(bookingId);
            break;

        case 5:
            System.out.print("enter booking id: ");
            int trackId=sc.nextInt();
            sc.nextLine();

            trackstatus(trackId);
            break;

        case 0:
            System.out.println("thank you for using our services");
            break;

        default:
            System.out.println("invalid choice");
            break;

            
        }


    }while(choice!=0);
}
    
    
}