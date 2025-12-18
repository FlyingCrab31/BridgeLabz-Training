import java.util.Scanner;

public class profitNloss {

    static int profit(int cp,int sp){
        int prof = sp -cp;
        return prof;
    }
    static int loss(int cp,int sp){
        int l = cp - sp;
        return l;
    }
    static int profitPercent (int cp , int sp){
        int prof = sp -cp;
        int profPercent = (prof/cp) *100;
        return profPercent;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cp = sc.nextInt();
        int sp = sc.nextInt();
        System.out.println(profit(cp,sp));
        System.out.println(loss(cp,sp));
        System.out.println(profitPercent(cp, sp));

    }
}