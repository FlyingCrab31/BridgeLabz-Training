public class WatchSimulation {
    public static void main(String[] args) {
        for (int hour = 0; hour < 24; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                System.out.printf("%02d:%02d%n", hour, minute);
                // Simulate power cut at 13:00
                if (hour == 13 && minute == 0) {
                    System.out.println("Power cut! Watch stopped at 13:00.");
                    break;
                }
            }
            // Break outer loop if power cut occurred
            if (hour == 13) {
                break;
            }
        }
    }
}