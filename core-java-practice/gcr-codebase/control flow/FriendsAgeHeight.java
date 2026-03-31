import java.util.Scanner;

class FriendsAgeHeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ageAmar = sc.nextInt();
        double heightAmar = sc.nextDouble();

        int ageAkbar = sc.nextInt();
        double heightAkbar = sc.nextDouble();

        int ageAnthony = sc.nextInt();
        double heightAnthony = sc.nextDouble();

        // Youngest
        String youngest = "Amar";
        int youngestAge = ageAmar;

        if (ageAkbar < youngestAge) {
            youngest = "Akbar";
            youngestAge = ageAkbar;
        }
        if (ageAnthony < youngestAge) {
            youngest = "Anthony";
            youngestAge = ageAnthony;
        }

        // Tallest
        String tallest = "Amar";
        double tallestHeight = heightAmar;

        if (heightAkbar > tallestHeight) {
            tallest = "Akbar";
            tallestHeight = heightAkbar;
        }
        if (heightAnthony > tallestHeight) {
            tallest = "Anthony";
            tallestHeight = heightAnthony;
        }

        System.out.println("Youngest friend: " + youngest + " (age " + youngestAge + ")");
        System.out.println("Tallest friend: " + tallest + " (height " + tallestHeight + ")");

        sc.close();
    }
}
