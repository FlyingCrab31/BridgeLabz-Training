import java.util.*;

public class AreaOfTri{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt();
        int height = sc.nextInt();
        int areaInCm = (1/2) * base * height;
        double areaInInches = (areaInCm/2.54);
        double areaInFeet = (areaInInches / 12);
        System.out.println("Area in cm" + areaInCm) ;
        System.out.println("Area in Inc" + areaInInches) ;
        System.out.println("Area in feet" + areaInFeet) ;
    }
}