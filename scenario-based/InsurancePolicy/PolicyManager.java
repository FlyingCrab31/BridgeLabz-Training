package InsurancePolicy;

import java.time.LocalDate;
import java.util.*;

public class PolicyManager {

    // quick lookup + uniqueness
    private Set<Policy> hashSet = new HashSet<>();

    // maintain insertion order
    private Set<Policy> linkedHashSet = new LinkedHashSet<>();

    // sorted by expiry date
    private Set<Policy> treeSet = new TreeSet<>(
            Comparator.comparing(Policy::getExpiryDate)
                    .thenComparing(Policy::getPolicyNumber)
    );

    // optional: to detect duplicates by policy number
    private Map<String, Integer> policyNumberCount = new HashMap<>();

    public boolean addPolicy(Policy policy) {
        boolean added = hashSet.add(policy);              // uniqueness by policyNumber
        linkedHashSet.add(policy);
        treeSet.add(policy);

        // track duplicates
        policyNumberCount.merge(policy.getPolicyNumber(), 1, Integer::sum);
        return added; // false means duplicate policyNumber
    }

    public boolean removePolicy(Policy policy) {
        boolean removed = hashSet.remove(policy);
        linkedHashSet.remove(policy);
        treeSet.remove(policy);

        policyNumberCount.computeIfPresent(policy.getPolicyNumber(), (k, v) ->
                v > 1 ? v - 1 : null);
        return removed;
    }

    // 2.a All unique policies (any set will do; LinkedHashSet gives insertion order)
    public Set<Policy> getAllUniquePolicies() {
        return new LinkedHashSet<>(linkedHashSet);
    }

    // 2.b Policies expiring within the next 30 days
    public List<Policy> getPoliciesExpiringSoon() {
        LocalDate now = LocalDate.now();
        LocalDate limit = now.plusDays(30);

        List<Policy> result = new ArrayList<>();
        for (Policy p : treeSet) { // already sorted by expiry
            if (!p.getExpiryDate().isBefore(now) &&
                    !p.getExpiryDate().isAfter(limit)) {
                result.add(p);
            }
            if (p.getExpiryDate().isAfter(limit)) break; // the rest will be later
        }
        return result;
    }

    // 2.c Policies with a specific coverage type
    public List<Policy> getPoliciesByCoverageType(String coverageType) {
        List<Policy> result = new ArrayList<>();
        for (Policy p : hashSet) { // O(1) membership and iteration
            if (p.getCoverageType().equalsIgnoreCase(coverageType)) {
                result.add(p);
            }
        }
        return result;
    }

    // 2.d Duplicate policies based on policy numbers
    public List<String> getDuplicatePolicyNumbers() {
        List<String> duplicates = new ArrayList<>();
        for (Map.Entry<String, Integer> e : policyNumberCount.entrySet()) {
            if (e.getValue() > 1) {
                duplicates.add(e.getKey());
            }
        }
        return duplicates;
    }

    // helper: print a collection of policies
    public static void printPolicies(Collection<Policy> policies, String title) {
        System.out.println("=== " + title + " ===");
        for (Policy p : policies) {
            System.out.println(p);
        }
        System.out.println();
    }

}

