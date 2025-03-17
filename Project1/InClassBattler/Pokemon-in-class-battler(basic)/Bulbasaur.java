
public class Bulbasaur extends Pokemon {

    public Bulbasaur() {
        this.setHp(45);
        this.setAttack(49);
        this.setDefense(49);
        this.setSpAttack(65);
        this.setSpDefense(65);
        this.setSpeed(45);
    }

    @Override
    public void displayStats() {
        System.out.println("Bulbasaur Stats:");
        super.displayStats();
    }
}