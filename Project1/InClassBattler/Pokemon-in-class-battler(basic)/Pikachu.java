public class Pikachu extends Pokemon {

    public Pikachu() {
        this.setHp(35);
        this.setAttack(55);
        this.setDefense(30);
        this.setSpAttack(50);
        this.setSpDefense(40);
        this.setSpeed(90);
    }

    @Override
    public void displayStats() {
        System.out.println("Pikachu Stats:");
        super.displayStats();
    }
}