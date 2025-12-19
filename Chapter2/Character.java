package Chapter2;

public class Character {
    private String nickname;
    private double hp;
    private double power;

    Character(String nickname, double hp, double power) {
        if (nickname == null) {
            System.out.println("null안됨");
            return;
        }

        if (hp < 0) {
            System.out.println("hp음수안됨");
            return;
        }

        if (power < 0) {
            System.out.println("power음수안됨");
            return;
        }

        this.nickname = nickname;
        this.hp = hp;
        this.power = power;
    }

    public void attack() {
        System.out.println(power + "만큼 공격");
    }

}
