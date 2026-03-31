import java.util.Scanner;

public class BasicCalc{
    static float add (float  x,float y){
        return (x + y);

    }
    static float sub (float x,float y){
        return (x - y);

    }
    static float mul (float x,float  y){
        return (x * y);
    }
    static float  div (float  x,float y){
    if(y!=0) return (x/y);
    else return (-1);  // -1 indicates an error that comes, when we divide an int with 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float x = sc.nextInt();
        float y = sc.nextInt(); 
        add(x, y);
        sub(x, y);
        mul(x, y);
        div(x, y);
    }

}
