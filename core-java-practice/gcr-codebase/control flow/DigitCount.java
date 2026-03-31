import java.util.Scanner;

class DigitCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int count = 0;
        int temp = n;

        if (temp == 0) {
            count = 1;
        } else {
            if (temp < 0) {
                temp = -temp;
            }
            while (temp != 0) {
                temp = temp / 10;
                count++;
            }
        }

        System.out.println("digits in  " + n + " is " + count);

        sc.close();
    }
}
