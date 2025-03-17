public class Charmander extends Pokemon {

    public Charmander() {
        this.setHp(39);
        this.setAttack(52);
        this.setDefense(43);
        this.setSpAttack(60);
        this.setSpDefense(50);
        this.setSpeed(65);
    }

    @Override
    public void displayStats() {
        System.out.println("Charmander Stats:");
        super.displayStats();
    }
}