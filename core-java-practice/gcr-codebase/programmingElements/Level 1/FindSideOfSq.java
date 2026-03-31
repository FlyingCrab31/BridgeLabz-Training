import java.util.Scanner;

public class FindSideOfSq {
    static int side (int perimeter){
        int sideLength = perimeter / 4;
        return sideLength;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int perimeter = sc.nextInt();
        System.out.println(side(perimeter));
    }

}