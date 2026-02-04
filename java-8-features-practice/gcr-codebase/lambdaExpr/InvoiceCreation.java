
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InvoiceCreation {

    // Invoice class with a constructor that accepts a transactionId
    static class Invoice {

        private String transactionId;

        public Invoice(String transactionId) {
            this.transactionId = transactionId;
        }

        public String getTransactionId() {
            return transactionId;
        }

        @Override
        public String toString() {
            return "Invoice{transactionId='" + transactionId + "'}";
        }
    }

    public static void main(String[] args) {

        // Sample list of transaction IDs
        List<String> transactionIds = Arrays.asList(
                "TXN-1001",
                "TXN-1002",
                "TXN-1003",
                "TXN-1004"
        );

        // Use constructor reference to create Invoice objects from transaction IDs
        List<Invoice> invoices = transactionIds.stream()
                .map(Invoice::new) // constructor reference instead of id -> new Invoice(id)
                .collect(Collectors.toList());

        // Print generated invoices for verification
        System.out.println("Generated invoices:");
        invoices.forEach(System.out::println);
    }
}
