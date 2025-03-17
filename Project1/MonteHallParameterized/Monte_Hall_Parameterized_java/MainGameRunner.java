/**
 * The MainGameRunner class orchestrates multiple rounds of the Monty Hall problem
 * with varying numbers of doors and simulation strategies. It allows users to observe
 * the effects of the "stay" and "switch" strategies on winning probabilities.
 */
public class MainGameRunner {
    
    // ANSI color codes for console output styling
    private final String ANSI_GREEN = "\u001B[32m";
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_BLUE = "\u001B[34m";
    private final String ANSI_PURPLE = "\u001B[35m";
    private final String ANSI_CYAN = "\u001B[36m";
    private final String ANSI_BLACK = "\u001B[30m";

    private final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    /**
     * Runs simulations of the Monty Hall game for a range of door counts and outputs
     * a comparison of the winning probabilities between "stay" and "switch" strategies.
     *
     * @param startDoors The starting number of doors for the simulations.
     * @param endDoors   The ending number of doors for the simulations.
     * @param simulations The number of game simulations to run per door count.
     */
    public void RunGames(int startDoors, int endDoors, int simulations) {
        System.out.println(ANSI_CYAN + "\n=== Monty Hall Problem Analysis ===" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "Testing door counts from " + startDoors + " to " + endDoors);
        System.out.println("Running " + simulations + " simulations per door count\n" + ANSI_RESET);

        // Run simulations for each door count
        for (int doorCount = startDoors; doorCount <= endDoors; doorCount++) {
            System.out.println(ANSI_CYAN + "\n=== Testing with " + doorCount + " doors ===" + ANSI_RESET);
            
            // Initialize games for both strategies
            PrizeGameWithSwitch gameWithSwitch = new PrizeGameWithSwitch(simulations, doorCount);
            PrizeGame regularGame = new PrizeGame(simulations, doorCount);
            
            gameWithSwitch.runGame();
            regularGame.runGame();
            
            // Compare and display results
            compareResults(gameWithSwitch, regularGame, doorCount);
        }
    }

    /**
     * Compares the results of the "stay" and "switch" strategies, calculates win percentages,
     * and displays the outcomes and improvement from switching.
     *
     * @param switchGame   The game instance where the player uses the "switch" strategy.
     * @param regularGame  The game instance where the player uses the "stay" strategy.
     * @param doorCount    The current number of doors in the game.
     */
    private void compareResults(PrizeGameWithSwitch switchGame, PrizeGame regularGame, int doorCount) {
        // Calculate statistics for both strategies
        int switchWinners = switchGame.getWinnerCount();
        int totalSwitchGames = switchGame.getTotalGames();
        
        int regularWinners = regularGame.getWinnerCount();
        int totalRegularGames = regularGame.getTotalGames();

        // Calculate win percentages
        double switchWinPercentage = ((double) switchWinners / totalSwitchGames) * 100;
        double regularWinPercentage = ((double) regularWinners / totalRegularGames) * 100;
        double winDifference = switchWinPercentage - regularWinPercentage;

        // Display results
        System.out.println(ANSI_BLUE + "\nResults with " + doorCount + " doors:" + ANSI_RESET);
        
        // Stay Strategy
        System.out.print("  Stay Strategy:    ");
        System.out.println(ANSI_RED + String.format("%.2f%%", regularWinPercentage) + ANSI_RESET);
        
        // Switch Strategy
        System.out.print("  Switch Strategy:  ");
        System.out.println(ANSI_GREEN + String.format("%.2f%%", switchWinPercentage) + ANSI_RESET);
        
        // Improvement
        System.out.print(ANSI_CYAN + "  Improvement:     ");
        System.out.print(ANSI_GREEN_BACKGROUND + ANSI_BLACK + String.format("%.2f%%", winDifference));
        System.out.println(ANSI_RESET);
    }
}
