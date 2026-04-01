import java.util.*;

public class NestedTryCatch{

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter size: ");
        int size = sc.nextInt();


        int[] arr = new int[size];

        System.out.println("Enter elements:");
        for(int i = 0;i<size;i++){
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter index: ");
        int index = sc.nextInt();


        System.out.print("Enter divisor: ");
        int divisor = sc.nextInt();

        try{
            try{
                int value = arr[index];

                try{
                    int result = value/divisor;

                    System.out.println("Result: "+result);
                }
                catch(ArithmeticException e){
                    System.out.println("Cannot divide by zero");
                }
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Invalid array index");
            }
            
        }
        finally{
            sc.close();
        }
    }
}