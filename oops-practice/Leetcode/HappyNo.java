import java.util.*;
public class HappyNo {

    public static boolean isHappy(int n) {
        int s = n;

        while (s != 1 && s!=4 ) {
            int t = s;
            s = 0;

            while (t != 0 ) {
                int d = t % 10;
                s += d * d;
                t =t/ 10;
            }
        }
        return s == 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isHappy(n));
    }
}
       