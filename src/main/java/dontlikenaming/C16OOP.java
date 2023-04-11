package dontlikenaming;

import java.util.ArrayList;

public class C16OOP {
    // 상속 (확장 : Extend)
    // 부모클래스로부터 변수, 메서드를 물려받아
    // 새로운 클래스를 만드는 기법
    // 한번 정의된 데이터 유형을 필요에 따라
    // 다시 재활용함으로써 반복되는 코드를 줄일수 있음

    // 상속의 장점 : 기존 클래스 재활용, 중복코드 배제, 유지보수 용이
    // 통일성 유지, 다형성 구현 용이

    // 부모/상위/슈퍼 <=> 자식/하위/파생

    public static void main(String[] args) {
        SCV scv1 = new SCV();
        Marine marine1 = new Marine();
        Medic Medic1 = new Medic();
        Firebat Firebat1 = new Firebat();
        System.out.println(scv1.life);
        System.out.println(marine1.life);
        System.out.println(Medic1.life);
        System.out.println(Firebat1.life);
        scv1.attack();
        marine1.attack();
        Firebat1.attack();

    }
}

class Unit {
    protected int life;
    protected int power;
    protected int defense;
    protected double atkCycle;
    protected double atkRange;
    protected int sight;
    protected double speed;
    protected int carrySize;
    protected char size = 'S';
    protected String attackAble = "g";

    public Unit() {}

    public Unit(
            int life, int power, int defense,
            double atkCycle, double atkRange, int sight, double speed,
            int carrySize, char size, String attackAble)
    {
        this.life = life;
        this.power = power;
        this.defense = defense;
        this.atkCycle = atkCycle;
        this.atkRange = atkRange;
        this.sight = sight;
        this.speed = speed;
        this.carrySize = carrySize;
        this.size = size;
        this.attackAble = attackAble;
    }

    public void attack() {}
    public void move() {}
}

class SCV extends Unit {
    public SCV() {
        // super : 부모 클래스의 생성자를 호출하는 특수한 키워드
        super(60, 5, 0, 15, 1, 7,
               2.344, 1, 'S', "g");
    }

    public SCV(
            int life, int power, int defense, int atkCycle, int sight,
            double speed, int carrySize, char size, char attackAble) {
    }
}

class Marine extends Unit {
    public Marine() {
        super(40, 6, 0, 15, 4, 7,
                1.875, 1, 'S', "gs");
    }

    public Marine(
            int life, int power, int defense, int atkCycle, int sight,
            double speed, int carrySize, char size, char attackAble) {
    }
}

class Medic extends Unit {
    public Medic() {
        super(60, 0, 1, 0, 0, 9,
                1.875, 1, 'S', "");
    }

    public Medic(
            int life, int power, int defense, int atkCycle, int sight,
            double speed, int carrySize, char size, char attackAble) {
    }

}

class Firebat extends Unit {
    public Firebat() {
        super(50, (8*2), 1, 22, 1.5, 7,
                1.875, 1, 'S', "g");
    }

    public Firebat(
            int life, int power, int defense, int atkCycle, int sight,
            double speed, int carrySize, char size, char attackAble) {
    }
}