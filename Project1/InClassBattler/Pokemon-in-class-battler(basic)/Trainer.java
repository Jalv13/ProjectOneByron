public class Trainer extends Card {
    private String trainerClass;
    private int experiencePoints;

    public Trainer(String name, String trainerClass) {
        super(name, "Trainer", "Common");
        this.trainerClass = trainerClass;
        this.experiencePoints = 0;
    }

    public String getTrainerClass() {
        return trainerClass;
    }

    public void setTrainerClass(String trainerClass) {
        this.trainerClass = trainerClass;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void gainExperience(int points) {
        this.experiencePoints += points;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Trainer Class: " + trainerClass);
        System.out.println("Experience Points: " + experiencePoints);
    }
}