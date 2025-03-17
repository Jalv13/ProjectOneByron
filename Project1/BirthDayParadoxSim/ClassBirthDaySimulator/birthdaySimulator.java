import java.util.ArrayList;

/**
 * A simulator class for the Birthday Paradox problem.
 * 
 * 
 * @author Joshua Alvarez
 * @version 1.0
 */
public class birthdaySimulator {
    /**
     * Runs a simulation to calculate the probability of birthday matches.
     * 
     * @param amountOfRuns    Number of times to run the simulation
     * @param amountOfPersons Number of persons in each simulation run
     * @return The probability of birthday matches as a percentage
     */
    public double RunSimulation(int amountOfRuns, int amountOfPersons) {
        // List to track birthdays in each simulation run
        ArrayList<Integer> birthdayList = new ArrayList<>();

        // Counter for birthday matches
        double birthdayMatches = 0;
        double probability;

        // Run simulation for specified number of times
        for (int z = 0; z < amountOfRuns; z++) {
            // Generate birthdays for each person in the group
            for (int i = 0; i < amountOfPersons; i++) {
                // Create a new person with a random birthday
                Person student = new Person();
                int birthday = student.birthday();

                // Check if birthday already exists in the list
                if (birthdayList.contains(birthday)) {
                    // Increment match counter if birthday is a duplicate
                    birthdayMatches++;
                    // Print details of each match
                    System.out.println("Match#:" + (int) birthdayMatches + "  |~|  " + birthday + " = " + birthday);
                } else {
                    // Add unique birthday to the list
                    birthdayList.add(birthday);
                }
            }
            // Clear birthday list for next simulation run
            birthdayList.clear();
        }

        // Calculate probability of birthday matches
        probability = (birthdayMatches / (amountOfPersons * amountOfRuns)) * 100;

        // Print detailed calculation
        System.out.println("\n((" + (int) birthdayMatches + " / (" + amountOfPersons +
                " * " + amountOfRuns + "))" + " * " + "100)\n");

        // Return probability as a percentage
        return probability;
    }
}