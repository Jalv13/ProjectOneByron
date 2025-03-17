public class Card {
    private String name;
    private String type;
    private String rarity;

    // Default constructor
    public Card() {
        this.name = "Unknown";
        this.type = "Normal";
        this.rarity = "Common";
    }

    // Parameterized constructor
    public Card(String name, String type, String rarity) {
        this.name = name;
        this.type = type;
        this.rarity = rarity;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    // Display card information
    public void displayInfo() {
        System.out.println("Card: " + name);
        System.out.println("Type: " + type);
        System.out.println("Rarity: " + rarity);
    }

    @Override
    public String toString() {
        return name + " (" + type + " - " + rarity + ")";
    }
}