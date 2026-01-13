import java.util.*;

// Custom exception: thrown when same voter tries to vote twice
class DuplicateVoteException extends Exception {
    public DuplicateVoteException(String message) {
        super(message);
    }
}

// Voter entity
class Voter {
    private final int id;
    private final String name;
    private boolean hasVoted;

    public Voter(int id, String name) {
        this.id = id;
        this.name = name;
        this.hasVoted = false;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public boolean hasVoted() { return hasVoted; }
    public void markVoted() { this.hasVoted = true; }

    @Override
    public String toString() {
        return "Voter{" + id + ", " + name + ", hasVoted=" + hasVoted + "}";
    }
}

// Candidate entity
class Candidate {
    private final int id;
    private final String name;
    private int voteCount;

    public Candidate(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getVoteCount() { return voteCount; }
    public void incrementVote() { voteCount++; }

    @Override
    public String toString() {
        return "Candidate{" + id + ", " + name + ", votes=" + voteCount + "}";
    }
}

// Vote entity
class Vote {
    private final int voterId;
    private final int candidateId;

    public Vote(int voterId, int candidateId) {
        this.voterId = voterId;
        this.candidateId = candidateId;
    }

    public int getVoterId() { return voterId; }
    public int getCandidateId() { return candidateId; }
}

// Abstraction for election operations
interface ElectionService {
    void registerVoter(Voter voter);
    void registerCandidate(Candidate candidate);
    void castVote(int voterId, int candidateId) throws DuplicateVoteException;
    Map<Candidate, Integer> getResults();
    Candidate getWinner();
}

class SimpleElectionService implements ElectionService {

    private final Map<Integer, Voter> voters = new HashMap<>();
    private final Map<Integer, Candidate> candidates = new HashMap<>();
    private final Map<Integer, Vote> votesByVoter = new HashMap<>(); // voterId -> Vote

    @Override
    public void registerVoter(Voter voter) {
        voters.put(voter.getId(), voter);
    }

    @Override
    public void registerCandidate(Candidate candidate) {
        candidates.put(candidate.getId(), candidate);
    }

    @Override
    public void castVote(int voterId, int candidateId) throws DuplicateVoteException {
        Voter voter = voters.get(voterId);
        if (voter == null) {
            throw new IllegalArgumentException("Voter not found: " + voterId);
        }
        Candidate candidate = candidates.get(candidateId);
        if (candidate == null) {
            throw new IllegalArgumentException("Candidate not found: " + candidateId);
        }

        // prevent duplicate vote
        if (voter.hasVoted() || votesByVoter.containsKey(voterId)) {
            throw new DuplicateVoteException("Voter " + voterId + " has already cast a vote.");
        }

        // record vote
        Vote vote = new Vote(voterId, candidateId);
        votesByVoter.put(voterId, vote);
        voter.markVoted();
        candidate.incrementVote();
        System.out.println("Vote recorded: " + voter.getName() +
                           " -> " + candidate.getName());
    }

    @Override
    public Map<Candidate, Integer> getResults() {
        Map<Candidate, Integer> results = new LinkedHashMap<>();
        // sort candidates by id for stable output
        List<Candidate> list = new ArrayList<>(candidates.values());
        list.sort(Comparator.comparingInt(Candidate::getId));
        for (Candidate c : list) {
            results.put(c, c.getVoteCount());
        }
        return results;
    }

    @Override
    public Candidate getWinner() {
        Candidate winner = null;
        int max = -1;
        for (Candidate c : candidates.values()) {
            if (c.getVoteCount() > max) {
                max = c.getVoteCount();
                winner = c;
            }
        }
        return winner;
    }
}

public class OnlineVoting {
    public static void main(String[] args) {
        ElectionService election = new SimpleElectionService();

        // Voter registration
        election.registerVoter(new Voter(1, "Rishabh"));
        election.registerVoter(new Voter(2, "Aman"));
        election.registerVoter(new Voter(3, "Priya"));

        // Candidate management
        election.registerCandidate(new Candidate(101, "Alice"));
        election.registerCandidate(new Candidate(102, "Bob"));

        try {
            // Vote casting
            election.castVote(1, 101);
            election.castVote(2, 102);
            election.castVote(3, 101);

            // Duplicate vote attempt
            election.castVote(1, 102); // should throw DuplicateVoteException

        } catch (DuplicateVoteException e) {
            System.out.println("Duplicate vote blocked: " + e.getMessage());
        }

        // Result declaration
        System.out.println("\n=== Election Results ===");
        for (Map.Entry<Candidate, Integer> entry : election.getResults().entrySet()) {
            System.out.println(entry.getKey().getName() + " -> " + entry.getValue() + " votes");
        }

        Candidate winner = election.getWinner();
        if (winner != null) {
            System.out.println("\nWinner: " + winner.getName()
                    + " with " + winner.getVoteCount() + " votes");
        } else {
            System.out.println("\nNo winner (no votes cast).");
        }
    }
}
