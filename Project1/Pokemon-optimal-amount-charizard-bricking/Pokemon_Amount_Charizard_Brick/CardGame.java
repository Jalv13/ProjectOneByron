import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a card game simulator that analyzes Pokemon card drawing
 * probabilities.
 * This class provides functionality to simulate drawing hands and calculating
 * the probability of drawing Pokemon cards based on deck composition.
 */
public class CardGame {

    /** ANSI escape code for resetting text color */
    final String ANSI_RESET = "\u001B[0m";

    /** ANSI escape code for green text */
    final String ANSI_GREEN = "\u001B[32m";

    /** ANSI escape code for red text */
    final String ANSI_RED = "\u001B[31m";

    /** The total size of the deck */
    private int deckSize = 60;

    /** Counter for how many times a Pokemon was found in a hand */
    private int pokemonFound = 0;

    /** The deck of cards */
    private ArrayList<Card> deck;

    /** The player's hand */
    private ArrayList<Card> hand;

    /**
     * Default constructor for CardGame.
     */
    public CardGame() {
    }

    /**
     * Fills the deck with specified numbers of Pokemon and non-Pokemon cards.
     * 
     * @param pokemonCount The number of Pokemon cards to add to the deck
     * @param nonPokemon   The number of Energy cards to add to the deck
     */
    public void fillDeck(int pokemonCount, int nonPokemon) {
        for (int i = 0; i < nonPokemon; i++) {
            deck.add(new Energy());
        }
        for (int i = 0; i < pokemonCount; i++) {
            deck.add(new Charmander());
        }
    }

    /**
     * Draws a hand of 7 cards randomly from the deck.
     * Cards are removed from the deck as they are drawn.
     */
    public void drawHand() {
        Random rng = new Random();
        for (int i = 0; i < 7; i++) {
            int cardToTakeIndex = rng.nextInt(deck.size());
            hand.add(deck.get(cardToTakeIndex));
            deck.remove(cardToTakeIndex);
        }
    }

    /**
     * Checks if there is at least one Pokemon card in the hand.
     * 
     * @return true if at least one Pokemon card is in the hand, false otherwise
     */
    public boolean isPokemonInHand() {
        for (Card singleCard : hand) {
            if (singleCard instanceof Pokemon) {
                return true;
            }
        }
        return false;
    }

    /**
     * Runs the simulation multiple times for varying amounts of Pokemon in the
     * deck.
     * For each number of Pokemon (from 1 to maxPokemon), the simulation:
     * 1. Creates a deck with the specified number of Pokemon
     * 2. Draws hands multiple times and counts how often a Pokemon is found
     * 3. Calculates and displays the probability of drawing at least one Pokemon
     * 
     * @param maxPokemon   The maximum number of Pokemon to test in the deck
     * @param amountOfRuns The number of simulations to run for each Pokemon count
     */
    public void runOptimalPokemonSimulation(int maxPokemon, int amountOfRuns) {
        System.out.println("Running simulations...\n");

        // Loop through incrementing numbers of Pokemon in the deck
        for (int pokemonCount = 1; pokemonCount <= maxPokemon; pokemonCount++) {
            pokemonFound = 0; // Reset for each new pokemonCount
            int nonPokemonCount = deckSize - pokemonCount;

            // Run the simulation for the current number of Pokemon
            for (int i = 0; i < amountOfRuns; i++) {
                deck = new ArrayList<>(); // Reset deck
                hand = new ArrayList<>(); // Reset hand
                fillDeck(pokemonCount, nonPokemonCount);
                drawHand();
                if (isPokemonInHand()) {
                    pokemonFound++;
                }
            }
            // Calculate the probability for this number of Pokemon
            double probability = (float) pokemonFound / (float) amountOfRuns * 100;
            System.out.println("\nWith " + ANSI_RED + pokemonCount + ANSI_RESET + " Pokemon in deck:");
            System.out.println("Probability of drawing a Pokemon:" + ANSI_GREEN + probability +
                    ANSI_RESET + "%\n");
            System.out.println("***************************************");
        }
    }
}