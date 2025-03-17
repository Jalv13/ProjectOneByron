/**
 * extends the PrizeGame class to simulate a version of the game
 * where the player always switches their initial door choice after the host reveals a non-prize door.
 * This demonstrates the "switch" strategy in the Monty Hall problem.
 */
public class PrizeGameWithSwitch extends PrizeGame {
    
    /**
     * Constructs a new PrizeGameWithSwitch instance with the specified number of rounds and doors.
     *
     * @param testsToRun The number of game rounds to simulate.
     * @param doorCount The number of doors in each round of the game.
     */
    public PrizeGameWithSwitch(int testsToRun, int doorCount) {
        super(testsToRun, doorCount);
    }

    /**
     * Runs a single round of the game where the player initially selects a door, the host reveals a non-prize door,
     * and the player switches their choice to the remaining unopened door. Updates win/loss counts based on the outcome.
     */
    @Override
    protected void runGameRound() {
        int prizeDoor = getRandomDoor();             // The door hiding the prize
        int playerChoice = getRandomDoor();          // The player's initial choice
        int hostReveal = getHostReveal(prizeDoor, playerChoice);  // Host reveals a non-prize door
        int playerSwitch = getRemainingDoor(playerChoice, hostReveal);  // Player switches to remaining door

        if (playerSwitch == prizeDoor) {
            winnerCount++;
        } else {
            loserCount++;
        }
    }

    /**
     * Randomly selects a door number from 1 to the total number of doors.
     *
     * @return A randomly chosen door number.
     */
    private int getRandomDoor() {
        return random.nextInt(doorCount) + 1;
    }

    /**
     * Determines a door for the host to reveal that does not contain the prize and was not chosen by the player.
     *
     * @param prizeDoor The door hiding the prize.
     * @param playerChoice The door initially chosen by the player.
     * @return The door revealed by the host.
     */
    private int getHostReveal(int prizeDoor, int playerChoice) {
        int hostReveal;
        do {
            hostReveal = getRandomDoor();
        } while (hostReveal == prizeDoor || hostReveal == playerChoice);
        return hostReveal;
    }

    /**
     * Determines the remaining unopened door after the player's initial choice and the host's reveal.
     *
     * @param playerChoice The door initially chosen by the player.
     * @param hostReveal The door revealed by the host.
     * @return The door remaining for the player to switch to.
     * @throws IllegalStateException If no remaining door is found, which should not occur in typical scenarios.
     */
    private int getRemainingDoor(int playerChoice, int hostReveal) {
        for (int i = 1; i <= doorCount; i++) {
            if (i != playerChoice && i != hostReveal) {
                return i;
            }
        }
        throw new IllegalStateException("No remaining door found");
    }
}
