public class Squirtle extends Pokemon {

    public Squirtle() {
        this.setHp(44);
        this.setAttack(48);
        this.setDefense(65);
        this.setSpAttack(50);
        this.setSpDefense(64);
        this.setSpeed(43);
    }

    @Override
    public void displayStats() {
        System.out.println("Squirtle Stats:");
        super.displayStats();
    }
}