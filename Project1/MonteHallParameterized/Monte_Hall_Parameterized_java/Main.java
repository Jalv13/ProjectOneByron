/**
 * The entry point for the Monty Hall simulation.
 */
public class Main {
    /**
     * Runs the Monty Hall simulation with a range of door counts.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Start the simulation with door counts ranging from 3 to 10,
        // running 100,000 simulations for each door count.
        new MainGameRunner().RunGames(3, 10, 100000);
    }
}
