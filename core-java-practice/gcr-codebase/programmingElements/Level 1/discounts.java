public class Discounts{
    public static void main(String[] args) {
        int fee = 125000;
        int discountPercent = 10; //discount should be entered in percentage.
        int discount = (discountPercent/100)*fee;
        int lastPrice = fee - discount;
        System.out.println(lastPrice);
    }
}