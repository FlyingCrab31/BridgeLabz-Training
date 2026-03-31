import java.util.Scanner;

class LeapYearLogical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int year = sc.nextInt();

        if (year >= 1582 &&
            ( (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0) )) {
            System.out.println(year + " is a Leap Year");
        } else if (year >= 1582) {
            System.out.println(year + " is NOT a Leap Year");
        } else {
            System.out.println("Year must be >= 1582 (Gregorian calendar).");
        }

        sc.close();
    }
}
