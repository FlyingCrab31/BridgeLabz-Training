import java.util.*;

public class ArrayException{

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Enter size: ");
            int size = sc.nextInt();

            int arr[] = new int[size];

            System.out.println("Enter elements: ");
            for(int i = 0; i<size; i++){
                arr[i] = sc.nextInt();
            }


            System.out.println("Enter index: ");
            int index = sc.nextInt();

            System.out.println("Value at index "+index+" is "+arr[index]);


        }

        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid index ");
        }

        catch(NullPointerException e){
            System.out.println("Array is not initialized!");
            }

       
    }
}
