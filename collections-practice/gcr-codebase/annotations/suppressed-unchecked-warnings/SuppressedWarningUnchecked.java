import java.util.*;

public class SuppressedWarningUnchecked{

    @SuppressWarnings("Unchecked")

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        ArrayList list=new ArrayList();

        System.out.println("Enter the number of elements to add: ");
        int n=sc.nextInt();

        System.out.println("Enter the elements: ");
        for(int i=0;i<n;i++){
            System.out.println("Enter element "+(i+1)+" : ");
            String input=sc.nextLine();

            try{

                list.add(Integer.parseInt(input));
            }
            catch(NumberFormatException e){
                try{
                    list.add(Double.parseDouble(input));
                }
                catch(NumberFormatException e1){
                    list.add(input);    
                }

            }
           
        }

        System.out.println("Contents of the list: ");
        for(Object obj:list){
            System.out.println(obj);
        }
    }
}