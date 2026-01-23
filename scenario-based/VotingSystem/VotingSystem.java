
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class VotingSystem {

    // Candidate -> Votes
    private Map<String, Integer> voteCount = new HashMap<>();

    // Order of votes (1st vote, 2nd vote, ...) -> Candidate
    private Map<Integer, String> voteOrder = new LinkedHashMap<>();

    private int voteIndex = 0;

    // Cast a vote for a candidate
    public void castVote(String candidate) {
        voteIndex++;
        // maintain order of votes
        voteOrder.put(voteIndex, candidate);

        // update total count in HashMap
        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
    }

    // Results in candidate-name sorted order (TreeMap)
    public Map<String, Integer> getResultsSortedByCandidate() {
        return new TreeMap<>(voteCount); // TreeMap from HashMap
    }

    // Results in insertion order of votes (LinkedHashMap view)
    public Map<Integer, String> getVoteOrder() {
        return new LinkedHashMap<>(voteOrder);
    }

    // Raw counts (HashMap)
    public Map<String, Integer> getRawCounts() {
        return new HashMap<>(voteCount);
    }

    public static void main(String[] args) {
        VotingSystem vs = new VotingSystem();

        // Simulate votes
        vs.castVote("Alice");
        vs.castVote("Bob");
        vs.castVote("Alice");
        vs.castVote("Charlie");
        vs.castVote("Bob");
        vs.castVote("Alice");

        // 1. Raw HashMap counts
        System.out.println("Raw counts (HashMap):");
        System.out.println(vs.getRawCounts());

        // 2. Sorted results (TreeMap)
        System.out.println("\nResults sorted by candidate (TreeMap):");
        for (Map.Entry<String, Integer> e : vs.getResultsSortedByCandidate().entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        // 3. Order of votes (LinkedHashMap)
        System.out.println("\nOrder of votes (LinkedHashMap):");
        for (Map.Entry<Integer, String> e : vs.getVoteOrder().entrySet()) {
            System.out.println("Vote #" + e.getKey() + " -> " + e.getValue());
        }
    }
}
