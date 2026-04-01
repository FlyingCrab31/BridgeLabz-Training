package InsurancePolicy;

import java.time.LocalDate;

import static InsurancePolicy.PolicyManager.printPolicies;

public class Main {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        manager.addPolicy(new Policy("P1", "Alice",
                LocalDate.now().plusDays(10), "Health", 5000));
        manager.addPolicy(new Policy("P2", "Bob",
                LocalDate.now().plusDays(40), "Auto", 3000));
        manager.addPolicy(new Policy("P3", "Carol",
                LocalDate.now().plusDays(20), "Home", 7000));
        manager.addPolicy(new Policy("P1", "Alice DUP",
                LocalDate.now().plusDays(15), "Health", 6000)); // duplicate number

        printPolicies(manager.getAllUniquePolicies(), "All unique (LinkedHashSet order)");

        printPolicies(manager.getPoliciesExpiringSoon(),
                "Expiring within 30 days");

        printPolicies(manager.getPoliciesByCoverageType("Health"),
                "Health policies");

        System.out.println("Duplicate policy numbers: " +
                manager.getDuplicatePolicyNumbers());
    }
}
