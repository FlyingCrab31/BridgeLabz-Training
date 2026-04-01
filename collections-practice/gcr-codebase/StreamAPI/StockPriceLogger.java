
import java.util.Arrays;
import java.util.List;

public class StockPriceLogger {

    public static void main(String[] args) {

        // Simulated live feed of stock prices
        List<Double> stockPrices = Arrays.asList(
                101.25,
                102.70,
                100.90,
                103.15,
                102.05
        );

        // Use forEach() to print each stock price update
        stockPrices.stream()
                .forEach(price -> System.out.println("Stock price update: " + price));
        // Or with method reference if you just want the value:
        // stockPrices.stream().forEach(System.out::println);
    }
}
