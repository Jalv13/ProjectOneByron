public class Stadium {

    public void battle(Pokemon p1, Pokemon p2) {
        int p1Hp = p1.getHp();
        int p2Hp = p2.getHp();
        int p1Atk = p1.getAttack();
        int p2Atk = p2.getAttack();

        if (p1.getSpeed() >= p2.getSpeed()) {
            System.out.println(p1.getClass().getSimpleName() + " goes first");
            while (p1Hp > 0 && p2Hp > 0) {
                p2Hp -= p1Atk;
                if (p2Hp <= 0)
                    break;
                p1Hp -= p2Atk;
            }
        } else {
            System.out.println(p2.getClass().getSimpleName() + " goes first");
            while (p1Hp > 0 && p2Hp > 0) {
                p1Hp -= p2Atk;
                if (p1Hp <= 0)
                    break;
                p2Hp -= p1Atk;
            }
        }

        if (p1Hp > 0) {
            System.out.println(p1.getClass().getSimpleName() + " wins!");
        } else {
            System.out.println(p2.getClass().getSimpleName() + " wins!");
        }
    }
}