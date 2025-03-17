public class Energy extends Card {
    public enum EnergyType {
        GRASS, FIRE, WATER, LIGHTNING, PSYCHIC, FIGHTING, DARKNESS, METAL, FAIRY, DRAGON, COLORLESS, POISON, GROUND,
        ROCK, BUG
    }

    private EnergyType energyType;

    public Energy(EnergyType energyType) {
        super("Energy", energyType.name(), "Basic");
        this.energyType = energyType;
    }

    public EnergyType getEnergyType() {
        return energyType;
    }

    public void setEnergyType(EnergyType energyType) {
        this.energyType = energyType;
    }

    @Override
    public void displayInfo() {
        System.out.println("Energy Type: " + energyType);
    }
}