public class Jigglypuff extends Pokemon {

    public Jigglypuff() {
        this.setHp(115);
        this.setAttack(45);
        this.setDefense(20);
        this.setSpAttack(45);
        this.setSpDefense(25);
        this.setSpeed(20);
    }

    @Override
    public void displayStats() {
        System.out.println("Jigglypuff Stats:");
        super.displayStats();
    }
}