
public class MultipleValueArray {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        double[] array = new double[10];
        double total = 0;
        int index = 0;
        
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double num = sc.nextDouble();
            if (num <= 0) {
                break;
            }
            if(index < 10 ) {
                array[index] = num;
                total += num;
                index++;
            } else {
                System.out.println("Array is full. Cannot add more numbers.");
                break;
            }
            
            }
            System.out.println("Elements in the array:");
            for (int i = 0; i < index; i++) {
                System.out.println(array[i]);
            }

            System.out.println("Total sum: " + total);

}}