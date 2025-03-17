/**
 * Main class to run the Birthday Paradox Simulation.
 * 
 * This class demonstrates the Birthday Paradox (or Birthday Problem)
 * by running a simulation to calculate the probability of a shared
 * birthday in a group of people.
 * 
 * The Birthday Paradox is a non-intuitive probability problem that
 * shows the likelihood of two people sharing a birthday is much higher
 * than most people expect, especially in larger groups.
 * 
 * @author Joshua Alvarez
 * @version 1.0
 */
public class Main {
    /**
     * The main method that runs the birthday simulation.
     * 
     * 
     * @param args Command line arguments (not used in this program)
     */
    public static void main(String[] args) {
        // Number of times to run the simulation for statistical accuracy
        int amountOfRuns = 10000;

        // Number of persons in the group (class size)
        int amountOfPersons = 30;

        // Create an instance of the birthday simulator
        birthdaySimulator run = new birthdaySimulator();

        // Run the simulation and get the probability of shared birthdays
        double probability = run.RunSimulation(amountOfRuns, amountOfPersons);

        // Print the results
        System.out.println("Probability = " + probability + "%\n");
    }
}