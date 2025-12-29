import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

//Time Zones and ZonedDateTime-- a program that displays the current
//time in different time zones:
//-➢ GMT (Greenwich Mean Time)
//-➢ IST (Indian Standard Time)
//-➢ PST (Pacific Standard Time)
public class ZonedDataTime {
    public static void main(String[] args) {
        // Get the current date and time in the system's default time zone
        ZonedDateTime now = ZonedDateTime.now();

        // Define the desired time zones
        ZoneId gmtZone = ZoneId.of("GMT");
        ZoneId istZone = ZoneId.of("Asia/Kolkata");
        ZoneId pstZone = ZoneId.of("America/Los_Angeles");

        // Convert the current time to the specified time zones
        ZonedDateTime gmtTime = now.withZoneSameInstant(gmtZone);
        ZonedDateTime istTime = now.withZoneSameInstant(istZone);
        ZonedDateTime pstTime = now.withZoneSameInstant(pstZone);

        // Define a formatter for displaying the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");

        // Print the current time in each time zone
        System.out.println("Current Time in GMT: " + gmtTime.format(formatter));
        System.out.println("Current Time in IST: " + istTime.format(formatter));
        System.out.println("Current Time in PST: " + pstTime.format(formatter));
    }

}