import java.util.Random;

/**
 * The PrizeGame class simulates a simple game where a player selects one of several doors
 * to find a hidden prize. The game is played multiple times to track the number of wins and losses.
 */
public class PrizeGame {
    /** The total number of doors in the game. */
    protected final int doorCount;
    
    /** The total number of game rounds to run. */
    protected final int testsToRun;
    
    /** The count of rounds where the player found the prize. */
    protected int winnerCount = 0;
    
    /** The count of rounds where the player did not find the prize. */
    protected int loserCount = 0;
    
    /** Random instance to handle door and prize selection. */
    protected final Random random = new Random();

    /**
     * Constructs a new PrizeGame with the specified number of rounds and doors.
     *
     * @param testsToRun The number of game rounds to simulate.
     * @param doorCount The number of doors to choose from in each game round.
     */
    public PrizeGame(int testsToRun, int doorCount) {
        this.testsToRun = testsToRun;
        this.doorCount = doorCount;
    }

    /**
     * Runs the game for the specified number of rounds, simulating a player's attempt
     * to select the door with the hidden prize.
     */
    public void runGame() {
        for (int i = 0; i < testsToRun; i++) {
            runGameRound();
        }
    }

    /**
     * Simulates a single round of the game, where a door is randomly chosen by the player
     * and compared against a randomly selected door with the prize.
     * Increments the winnerCount if the player wins, otherwise increments the loserCount.
     */
    protected void runGameRound() {
        int doorNumber = random.nextInt(doorCount) + 1;  // Player's chosen door
        int prizeLocation = random.nextInt(doorCount) + 1;  // Prize location

        if (doorNumber == prizeLocation) {
            winnerCount++;
        } else {
            loserCount++;
        }
    }

    /**
     * Returns the number of times the player found the prize.
     *
     * @return The count of wins.
     */
    public int getWinnerCount() {
        return winnerCount;
    }

    /**
     * Returns the number of times the player did not find the prize.
     *
     * @return The count of losses.
     */
    public int getLoserCount() {
        return loserCount;
    }

    /**
     * Returns the total number of games played, which is the sum of wins and losses.
     *
     * @return The total number of games played.
     */
    public int getTotalGames() {
        return winnerCount + loserCount;
    }
}
