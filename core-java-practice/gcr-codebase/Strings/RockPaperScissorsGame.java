import java.util.Scanner;

public class RockPaperScissorsGame {

    // 0 = Rock, 1 = Paper, 2 = Scissors
    public static int getComputerChoice() {
        return (int) (Math.random() * 3);
    }

    // 1 = user wins, -1 = computer wins, 0 = draw
    public static int findWinner(int user, int comp) {
        if (user == comp) {
            return 0;
        }
        if ((user == 0 && comp == 2) ||
            (user == 1 && comp == 0) ||
            (user == 2 && comp == 1)) {
            return 1;
        }
        return -1;
    }

    // stats[0] -> {"Player", wins, percent}
    // stats[1] -> {"Computer", wins, percent}
    public static String[][] computeStats(int totalGames, int userWins, int compWins) {
        String[][] stats = new String[2][3];

        double userPercent = (totalGames == 0) ? 0 : (userWins * 100.0 / totalGames);
        double compPercent = (totalGames == 0) ? 0 : (compWins * 100.0 / totalGames);

        stats[0][0] = "Player";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.format("%.2f", userPercent);

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(compWins);
        stats[1][2] = String.format("%.2f", compPercent);

        return stats;
    }

    // perGame[i] -> { gameNo, userChoice, compChoice, result }
    public static void displayResults(String[][] perGame, String[][] stats) {
        System.out.println("\nGame Results:");
        System.out.println("Game\tUser\tComputer\tResult");
        for (int i = 0; i < perGame.length; i++) {
            System.out.println(perGame[i][0] + "\t" +
                               perGame[i][1] + "\t" +
                               perGame[i][2] + "\t\t" +
                               perGame[i][3]);
        }

        System.out.println("\nWin Statistics:");
        System.out.println("Player\tWins\tPercent");
        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t" +
                               stats[i][1] + "\t" +
                               stats[i][2] + "%");
        }
    }

    public static String choiceToText(int choice) {
        switch (choice) {
            case 0: return "Rock";
            case 1: return "Paper";
            case 2: return "Scissors";
            default: return "Unknown";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of games to play: ");
        int n = sc.nextInt();

        String[][] perGame = new String[n][4];

        int userWins = 0;
        int compWins = 0;
        int draws = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("\nGame " + (i + 1));
            System.out.println("Enter your choice: 0 = Rock, 1 = Paper, 2 = Scissors");
            int userChoice = sc.nextInt();

            while (userChoice < 0 || userChoice > 2) {
                System.out.println("Invalid choice. Please enter 0, 1, or 2.");
                userChoice = sc.nextInt();
            }

            int compChoice = getComputerChoice();
            int result = findWinner(userChoice, compChoice);

            String resultText;
            if (result == 1) {
                resultText = "Player Wins";
                userWins++;
            } else if (result == -1) {
                resultText = "Computer Wins";
                compWins++;
            } else {
                resultText = "Draw";
                draws++;
            }

            perGame[i][0] = String.valueOf(i + 1);
            perGame[i][1] = choiceToText(userChoice);
            perGame[i][2] = choiceToText(compChoice);
            perGame[i][3] = resultText;
        }

        String[][] stats = computeStats(n, userWins, compWins);
        displayResults(perGame, stats);

        System.out.println("\nTotal draws: " + draws);

        sc.close();
    }
}
