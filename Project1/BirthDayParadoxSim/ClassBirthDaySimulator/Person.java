import java.util.Random;

/**
 * Represents a person with a randomly generated birthday.
 * 
 * This class generates a random birthday between 1 and 365
 * to simulate a random day that a classmate was born(excluding leap years)
 * 
 * @author Joshua Alvarez
 * @version 1.0
 */
public class Person {

    /**
     * Generates a random birthday.
     * 
     * @return A randomly selected birthday number between 1 and 365
     */
    public int birthday() {
        int birthday;
        Random random = new Random();
        // Generate a random integer between 1 and 365
        birthday = random.nextInt(364) + 1;

        return birthday;
    }
}