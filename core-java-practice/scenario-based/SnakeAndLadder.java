import java.util.Random;
 public class SnakeAndLadder{

    private static final int WINNING_POSITION = 100;
    private static final int START_POSITION = 0;
    
    // Options for the game
    private static final int NO_PLAY = 0;
    private static final int LADDER = 1;
    private static final int SNAKE = 2;
    
    // Random number generator
    private static Random random = new Random();
    
    // Player position and dice roll count
    private int playerPosition;
    private int diceRollCount;
    
    // Constructor - UC1: Initialize player at start position 0.
    public SnakeAndLadder() {
        this.playerPosition = START_POSITION;
        this.diceRollCount = 0;
    }

    // UC2: Roll the die to get a number between 1 to 6
    public int rollDie() {
        return random.nextInt(6) + 1;
    }

    // UC3: Check for option 
    public int checkOption() {
        return random.nextInt(3); // Returns 0, 1, or 2
    }

    // UC3, UC4, UC5: Move player based on die roll and option
    public void movePlayer(int dieNumber, int option) {
        int previousPosition = playerPosition;
        
        switch (option) {
            case NO_PLAY:
                // UC3: Player stays in the same position
                System.out.println("No Play " + playerPosition);
                break;
            
            case LADDER:
                // UC3: Player moves ahead by the die number
                playerPosition += dieNumber;
                // UC5: Ensure player doesn't exceed 100
                if (playerPosition > WINNING_POSITION) {
                    playerPosition = previousPosition;
                    System.out.println("Ladder - Cannot move beyond 100. " + playerPosition);
                } else {
                    System.out.println("Ladder - Player moves " + playerPosition);
                }
                break;

            case SNAKE:
                // UC3: Player moves behind by the die number
                playerPosition -= dieNumber;

                // UC4: player doesn't go below 0, restart from 0

                if (playerPosition < START_POSITION) {

                    playerPosition = START_POSITION;
                    System.out.println("Snake - Player moves below 0. " + playerPosition);
                } else {
                    System.out.println("Snake - Player moves " + playerPosition);
                }
                break;

        }
    }
    // UC4, UC5, UC6: Play the complete game
    public void playGame() {
        System.out.println(" Game Start");
        System.out.println(" starting position: " + playerPosition);
        System.out.println();
        // UC4: Repeat until player reaches winning position 100
        while (playerPosition != WINNING_POSITION) {
            diceRollCount++;
            
            // UC2: Roll the die
            int dieNumber = rollDie();
            System.out.println("Roll no." + diceRollCount + ": Die no. " + dieNumber);

            // UC3: Check for option
            int option = checkOption();

            // Move player
            movePlayer(dieNumber, option);
            System.out.println();
        }
        // UC6: Report the number of times dice was played
        System.out.println("Game Over ");
        System.out.println("Player won " + playerPosition);
        System.out.println("Total number of dice rolls: " + diceRollCount);
    }
    // Main method to run the game
    public static void main(String[] args) {
        System.out.println("Snake And Ladder Game!");
        System.out.println();
        
        SnakeAndLadder game = new SnakeAndLadder();
        game.playGame();
    }
}