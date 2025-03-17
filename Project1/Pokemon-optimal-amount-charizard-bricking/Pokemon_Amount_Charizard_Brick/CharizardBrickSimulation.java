import java.util.ArrayList;
import java.util.Random;

/**
 * Simulates the probability of "bricking" a Charizard deck by having all Rare
 * Candy cards
 * in the prize cards, making it impossible to evolve Charmeleon to Charizard.
 * This simulator runs multiple tests with varying numbers of Rare Candy cards
 * to analyze
 * how deck composition affects the probability of bricking.
 */
public class CharizardBrickSimulation {
    /** ANSI escape code for resetting text color */
    final String ANSI_RESET = "\u001B[0m";

    /** ANSI escape code for green text */
    final String ANSI_GREEN = "\u001B[32m";

    /** ANSI escape code for red text */
    final String ANSI_RED = "\u001B[31m";

    /** The total size of the deck */
    private int deckSize = 60;

    /** Counter for how many times the deck bricked (all Rare Candies prized) */
    private int brickCount = 0;

    /** The deck of cards */
    private ArrayList<Card> deck;

    /** The six prize cards set aside at the beginning of a game */
    private ArrayList<Card> prizeCards;

    /**
     * Default constructor for CharizardBrickSimulation.
     */
    public CharizardBrickSimulation() {
    }

    /**
     * Fills the deck with a specified number of Rare Candy cards and fills
     * the remainder with Energy cards as placeholders.
     * 
     * @param rareCandyCount The number of Rare Candy cards to include in the deck
     */
    public void fillDeck(int rareCandyCount) {
        deck = new ArrayList<>();
        // Add Rare Candies
        for (int i = 0; i < rareCandyCount; i++) {
            deck.add(new RareCandy());
        }
        // Fill rest with other cards
        for (int i = 0; i < deckSize - rareCandyCount; i++) {
            deck.add(new Energy()); // Using Energy as filler cards
        }
    }

    /**
     * Randomly selects 6 cards from the deck to be set aside as prize cards.
     * These cards are removed from the deck.
     */
    public void drawPrizeCards() {
        prizeCards = new ArrayList<>();
        Random rng = new Random();
        for (int i = 0; i < 6; i++) {
            int cardToTakeIndex = rng.nextInt(deck.size());
            prizeCards.add(deck.get(cardToTakeIndex));
            deck.remove(cardToTakeIndex);
        }
    }

    /**
     * Checks if all Rare Candy cards in the deck are in the prize cards,
     * which would make it impossible to evolve Charmeleon to Charizard.
     * 
     * @return true if all Rare Candy cards are in the prize cards, false otherwise
     */
    public boolean isAllRareCandyPrized() {
        int rareCandyInPrizes = 0;
        for (Card card : prizeCards) {
            if (card instanceof RareCandy) {
                rareCandyInPrizes++;
            }
        }
        // Compare with total Rare Candy count in deck
        int totalRareCandy = 0;
        for (Card card : deck) {
            if (card instanceof RareCandy) {
                totalRareCandy++;
            }
        }
        for (Card card : prizeCards) {
            if (card instanceof RareCandy) {
                totalRareCandy++;
            }
        }
        return rareCandyInPrizes == totalRareCandy;
    }

    /**
     * Runs the brick simulation multiple times for varying amounts of Rare Candy
     * cards.
     * For each Rare Candy count (from 1 to 4), the simulation:
     * 1. Creates a deck with the specified number of Rare Candy cards
     * 2. Draws prize cards multiple times and counts how often all Rare Candies are
     * prized
     * 3. Calculates and displays the probability of the deck bricking
     * 
     * @param amountOfRuns The number of simulations to run for each Rare Candy
     *                     count
     */
    public void runBrickSimulation(int amountOfRuns) {
        System.out.println("Running Charizard deck brick simulations...\n");

        // Loop through incrementing numbers of Rare Candy
        for (int rareCandyCount = 1; rareCandyCount <= 4; rareCandyCount++) {
            brickCount = 0; // Reset for each new rareCandyCount

            // Run the simulation for the current number of Rare Candy
            for (int i = 0; i < amountOfRuns; i++) {
                fillDeck(rareCandyCount);
                drawPrizeCards();
                if (isAllRareCandyPrized()) {
                    brickCount++;
                }
            }

            // Calculate and display the probability
            double probability = (double) brickCount / (double) amountOfRuns * 100;
            System.out.println("\nWith " + ANSI_RED + rareCandyCount + ANSI_RESET + " Rare Candy in deck:");
            System.out.println("Probability of all Rare Candy being prized: " + ANSI_GREEN +
                    String.format("%.2f", probability) + ANSI_RESET + "%");
            System.out.println("***************************************");
        }
    }
}