
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class LoggingTransactions {

    public static void main(String[] args) {

        List<String> transactionIds = Arrays.asList(
                "TXN-1001",
                "TXN-1002",
                "TXN-1003",
                "TXN-1004"
        );

        // Use forEach() to log each transaction with a timestamp
        transactionIds.forEach(id
                -> System.out.println(LocalDateTime.now() + " - Transaction: " + id)
        );
    }
}
