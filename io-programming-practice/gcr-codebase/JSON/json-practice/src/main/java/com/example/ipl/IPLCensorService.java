package com.example.ipl;

public class IPLCensorService {

    public static String maskTeam(String team) {
        if(team == null || team.isEmpty()) return team;
        String[] parts = team.split(" ");
        parts[parts.length - 1] = "***";
        return String.join(" ", parts);
    }

    public static void censorMatch(IPLMatch match) {
        if(match == null) return;

        match.team1 = maskTeam(match.team1);
        match.team2 = maskTeam(match.team2);
        match.winner = maskTeam(match.winner);
        match.player_of_match = "REDACTED";

        // Optional: remove original scores for JSON
        // match.score = null; // If you want to hide scores too
    }
}
