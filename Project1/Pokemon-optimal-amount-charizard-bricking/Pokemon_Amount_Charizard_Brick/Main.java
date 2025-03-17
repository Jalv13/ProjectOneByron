/**
 * Main class that serves as the entry point for the Pokemon card game
 * simulations.
 */
public class Main {
    /**
     * The main method that executes the Pokemon card game simulations.
     * This method runs two separate simulations:
     * 1. An optimal Pokemon count simulation that tests different Pokemon counts in
     * a deck
     * 2. A Charizard deck brick analysis that examines how often the Charizard deck
     * fails to start properly
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        CardGame game = new CardGame();
        int maxPokemon = 60;
        int amountOfRuns = 10000;
        game.runOptimalPokemonSimulation(maxPokemon, amountOfRuns);

        CharizardBrickSimulation brickSim = new CharizardBrickSimulation();
        brickSim.runBrickSimulation(amountOfRuns);
    }
}