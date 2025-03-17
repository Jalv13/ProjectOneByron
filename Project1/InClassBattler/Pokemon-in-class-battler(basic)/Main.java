public class Main {
    public static void main(String[] args) {
        Pikachu pikachu = new Pikachu();
        Charmander charmander = new Charmander();

        Stadium stadium = new Stadium();
        stadium.battle(pikachu, charmander);
    }
}