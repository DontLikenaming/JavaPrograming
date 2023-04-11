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

    // 메서드 재정의(override)
    // 객체지향 중요 3대 개념중 다형성에 해당
    // 상속 관계에 있는 상위 클래스의 메서드를
    // 하위 클래스에서 같은 이름의 메서드로 다시 작성하는 것을 의미
    // 즉, 상속받은 메서드를 새로 정의해서 사용하는 것을 말함

    public static void main(String[] args) {
        SCV scv1 = new SCV();
        Marine marine1 = new Marine();
        Medic Medic1 = new Medic();
        Firebat Firebat1 = new Firebat();
        System.out.printf("%s\n",scv1.name);
        System.out.printf("체력 : %d\n",scv1.life);
        scv1.collect();
        scv1.attack();

        System.out.printf("\n%s\n",marine1.name);
        System.out.printf("체력 : %d\n",marine1.life);
        marine1.attack();
        marine1.useSteampack();

        System.out.printf("\n%s\n",Medic1.name);
        System.out.printf("체력 : %d\n",Medic1.life);
        Medic1.attack();
        Medic1.useOpticalflare();

        System.out.printf("\n%s\n",Firebat1.name);
        System.out.printf("체력 : %d\n",Firebat1.life);
        Firebat1.attack();
        Firebat1.useSteampack();

    }
}

class Unit {
    protected String name;
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
    protected String weapon;

    public Unit() {}

    public Unit(
            String name, int life, int power, int defense,
            double atkCycle, double atkRange, int sight, double speed,
            int carrySize, char size, String attackAble, String weapon)
    {
        this.name = name;
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
        this.weapon = weapon;
    }

    public void attack() {
            System.out.printf("%s(%d)로 공격 중...\n", weapon, power);
    }
    public void move() {}
}

class SCV extends Unit {
    public SCV() {
        // super : 부모 클래스의 생성자를 호출하는 특수한 키워드
        super("SCV", 60, 5, 0, 15,
                1, 7, 2.344, 1,
                'S', "g", "융합 절단기");
    }

    public SCV(
            String name, int life, int power, int defense,
            double atkCycle, double atkRange, int sight, double speed,
            int carrySize, char size, String attackAble, String weapon) {
    }

    @Override   // annotation : 컴파일러에게 알려주는 메모
    public void attack() {
        super.attack();
    }

    protected void collect() {
        System.out.println("자원 채취 중..");
    }
}

class Marine extends Unit {
    public Marine() {
        super("Marine", 40, 6, 0, 15,
                4, 7, 1.875, 1,
                'S', "gs", "가우스 소총");
    }

    public Marine(
            String name, int life, int power, int defense,
            double atkCycle, double atkRange, int sight, double speed,
            int carrySize, char size, String attackAble, String weapon) {
    }

    @Override
    public void attack() {
        super.attack();
    }

    protected void useSteampack() {
        System.out.println("전투 자극제 사용!");
        System.out.printf("공격 속도 %.4f로 증가! 이동 속도 %.4f로 증가!\n",
                          atkCycle/1.72, speed*1.5);
    }
}

class Medic extends Unit {
    public Medic() {
        super("Medic", 60, 0, 1, 0,
                0, 9, 1.875, 1,
                'S', "", "");
    }

    public Medic(
            String name, int life, int power, int defense,
            double atkCycle, double atkRange, int sight, double speed,
            int carrySize, char size, String attackAble, String weapon) {
    }

    @Override
    public void attack() {
        System.out.println("일반 공격 불가!");
    }

    protected void useHealing() {
        System.out.println("대상 유닛의 체력을 초당 5.86 회복함..");
    }

    protected void useRestoration() {
        System.out.println("대상 유닛의 상태 이상 회복!");
    }

    protected void useOpticalflare() {
        System.out.println("대상 유닛의 시야를 1로 고정시킴!");
    }
}

class Firebat extends Unit {
    public Firebat() {
        super("Firebat", 50, (8)*2, 1, 22,
                1.5, 7, 1.875, 1,
                'S', "g", "화염 방사기");
    }

    public Firebat(
            String name, int life, int power, int defense,
            double atkCycle, double atkRange, int sight, double speed,
            int carrySize, char size, String attackAble, String weapon) {
    }

    @Override
    public void attack() {
        super.attack();
    }

    protected void useSteampack() {
        System.out.println("전투 자극제 사용!");
        System.out.printf("공격 속도 %.4f로 증가! 이동 속도 %.4f로 증가!\n",
                atkCycle/1.72, speed*1.5);
    }
}