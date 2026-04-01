
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InsuranceClaimAnalysis {

    static class InsuranceClaim {

        final private String claimId;
        final private String claimType;   // e.g. "Health", "Vehicle", "Home"
        final private double amount;

        public InsuranceClaim(String claimId, String claimType, double amount) {
            this.claimId = claimId;
            this.claimType = claimType;
            this.amount = amount;
        }

        public String getClaimId() {
            return claimId;
        }

        public String getClaimType() {
            return claimType;
        }

        public double getAmount() {
            return amount;
        }

        @Override
        public String toString() {
            return "InsuranceClaim{"
                    + "claimId='" + claimId + '\''
                    + ", claimType='" + claimType + '\''
                    + ", amount=" + amount
                    + '}';
        }
    }

    public static void main(String[] args) {

        List<InsuranceClaim> claims = Arrays.asList(
                new InsuranceClaim("C1", "Health", 12000.0),
                new InsuranceClaim("C2", "Vehicle", 8000.0),
                new InsuranceClaim("C3", "Health", 15000.0),
                new InsuranceClaim("C4", "Home", 5000.0),
                new InsuranceClaim("C5", "Vehicle", 10000.0)
        );

        // Find the average claim amount for each claim type
        Map<String, Double> avgAmountByType
                = claims.stream()
                        .collect(Collectors.groupingBy(
                                InsuranceClaim::getClaimType,
                                Collectors.averagingDouble(InsuranceClaim::getAmount)
                        ));

        // Print result
        avgAmountByType.forEach((type, avg)
                -> System.out.println(type + " -> " + avg));
    }
}
