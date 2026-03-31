
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Product {

    String name;
    double price;
    double rating;
    double discount;

    public Product(String name, double price, double rating, double discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return name + " [price=" + price
                + ", rating=" + rating
                + ", discount=" + discount + "]";
    }

}

public class CustomSorting {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();
        list.add(new Product("Phone", 50000, 4.8, 5));
        list.add(new Product("TV", 450000, 4.9, 15));
        list.add(new Product("Laptop", 800000, 4.8, 10));
        list.add(new Product("HeadPhone", 5000, 4.5, 15));

        System.out.println("Original List : ");
        list.forEach(System.out::println);

        System.out.println("--------------------");

        // System.out.println("---------------------");
        // // Sorting based on Prices...
        // list.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        // System.out.println("Ascending Order Sorting on the basis of price");
        // list.forEach(System.out::println);
        // System.out.println("---------------------");
        // // Sorting based on ratings
        // list.sort((r1, r2) -> Double.compare(r1.getRating(), r2.getRating()));
        // System.out.println("Ascending order sorting on the basis of rating");
        // list.forEach(System.out::println);
        // System.out.println("---------------------");
        // // Sorting based on Discounts..
        // list.sort((d1, d2) -> Double.compare(d1.getDiscount(), d2.getDiscount()));
        // System.out.println("Ascending order sorting ont the basis of discount");
        // list.forEach(System.out::println);
        //----------------------------------------------------------
        // Sorting based on Prices...
        list.sort(Comparator.comparingDouble(Product::getPrice));
        System.out.println("Sorting based on Prices");
        list.forEach(System.out::println);

        System.out.println("---------------------");

        // Sorting based on ratings...
        list.sort(Comparator.comparingDouble(Product::getRating));
        System.out.println("Sorting based on ratings");
        list.forEach(System.out::println);

        System.out.println("---------------------");

        // Sorting based on discounts...
        list.sort(Comparator.comparingDouble(Product::getDiscount));
        System.out.println("Sorting based on discounts");
        list.forEach(System.out::println);

        System.out.println("---------------------");

        // Sorting based on names...
        list.sort(Comparator.comparing(Product::getName));
        System.out.println("Sorting based on names");
        list.forEach(System.out::println);

    }

}
