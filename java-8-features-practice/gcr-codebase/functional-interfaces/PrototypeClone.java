import java.util.*;

class Product implements Cloneable{
    int id;
    String name;

    Product(int id, String name){
        this.id=id;
        this.name=name;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}

public class PrototypeClone{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter Product Id: ");
        int id=sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Product name: ");
        String name=sc.nextLine();

        Product original=new Product(id,name);

        try{
            Product copy=(Product) original.clone();
            System.out.println("Object cloned successfully");
            System.out.println("Cloned Product: "+copy.id+" "+copy.name);

        }
        catch(CloneNotSupportedException e){
            System.out.println("Cloning not supported");

        }
    }
}