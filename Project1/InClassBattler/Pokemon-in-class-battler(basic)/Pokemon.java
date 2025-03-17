public class Pokemon {
    private int pokeHp;
    private int pokeAttack;
    private int pokeDefense;
    private int pokeSpAttack;
    private int pokeSpDefense;
    private int pokeSpeed;

    // Getter and Setter for HP
    public int getHp() {
        return pokeHp;
    }

    public void setHp(int newHp) {
        pokeHp = newHp;
    }

    // Getter and Setter for Attack
    public int getAttack() {
        return pokeAttack;
    }

    public void setAttack(int newAttack) {
        pokeAttack = newAttack;
    }

    // Getter and Setter for Defense
    public int getDefense() {
        return pokeDefense;
    }

    public void setDefense(int newDefense) {
        pokeDefense = newDefense;
    }

    // Getter and Setter for Special Attack
    public int getSpAttack() {
        return pokeSpAttack;
    }

    public void setSpAttack(int newSpAttack) {
        pokeSpAttack = newSpAttack;
    }

    // Getter and Setter for Special Defense
    public int getSpDefense() {
        return pokeSpDefense;
    }

    public void setSpDefense(int newSpDefense) {
        pokeSpDefense = newSpDefense;
    }

    // Getter and Setter for Speed
    public int getSpeed() {
        return pokeSpeed;
    }

    public void setSpeed(int newSpeed) {
        pokeSpeed = newSpeed;
    }

    // Display Pokemon stats
    public void displayStats() {
        System.out.println("HP: " + pokeHp);
        System.out.println("Attack: " + pokeAttack);
        System.out.println("Defense: " + pokeDefense);
        System.out.println("Special Attack: " + pokeSpAttack);
        System.out.println("Special Defense: " + pokeSpDefense);
        System.out.println("Speed: " + pokeSpeed);
    }
}