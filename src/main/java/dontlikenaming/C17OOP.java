package dontlikenaming;

public class C17OOP {
    // 추상 클래스
    // 추상 메서드를 포함하는 클래스
    // 추상 메서드 : 메서드의 선언부만 있고, 몸체가 없는 메서드
    // 메서드의 몸체는 이것을 상속하는 자식클래스에서 정의함

    // 따라서, 추상 클래스는 불완전 클래스이므로
    // 객체화할 수 없음
    // 추상 메서드나 추상 클래스는 abstract라는 키워드 사용

    public static void main(String[] args) {
        // 추상 클래스 객체화 시도 - 불가능
        // Unit2 unit2 = new Unit2();

        Unit2 scv2 = new SCV2();
        ((SCV2)scv2).collect();
        scv2.attack();
        scv2.move();

    }
}

abstract class Unit2 {
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

    public Unit2() {}

    public Unit2(
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

    protected abstract void attack();
    protected abstract void move();
}

class SCV2 extends Unit2 {
    public SCV2() {
        // super : 부모 클래스의 생성자를 호출하는 특수한 키워드
        super("SCV", 60, 5, 0, 15,
                1, 7, 2.344, 1,
                'S', "g", "융합 절단기");
    }

    public SCV2(
            String name, int life, int power, int defense,
            double atkCycle, double atkRange, int sight, double speed,
            int carrySize, char size, String attackAble, String weapon) {
    }

    @Override   // annotation : 컴파일러에게 알려주는 메모
    public void attack() {
        System.out.printf("%s(%d)로 공격 중...\n", weapon, power);
    }

    @Override
    protected void move() {
        System.out.printf("%.3f 속도로 이동 중...\n", speed);
    }

    protected void collect() {
        System.out.println("자원 채취 중..");
    }
}

class Marine2 extends Unit2 {
    public Marine2() {
        super("Marine", 40, 6, 0, 15,
                4, 7, 1.875, 1,
                'S', "gs", "가우스 소총");
    }

    public Marine2(
            String name, int life, int power, int defense,
            double atkCycle, double atkRange, int sight, double speed,
            int carrySize, char size, String attackAble, String weapon) {
    }

    @Override
    public void attack() {
        System.out.printf("%s(%d)로 공격 중...\n", weapon, power);
    }

    @Override
    protected void move() {
        System.out.printf("%.3f 속도로 이동 중...\n", speed);
    }

    protected void useSteampack() {
        System.out.println("전투 자극제 사용!");
        System.out.printf("공격 속도 %.4f로 증가! 이동 속도 %.4f로 증가!\n",
                atkCycle/1.72, speed*1.5);
    }
}

class Medic2 extends Unit2 {
    public Medic2() {
        super("Medic", 60, 0, 1, 0,
                0, 9, 1.875, 1,
                'S', "", "");
    }

    public Medic2(
            String name, int life, int power, int defense,
            double atkCycle, double atkRange, int sight, double speed,
            int carrySize, char size, String attackAble, String weapon) {
    }

    @Override
    public void attack() {
        System.out.println("일반 공격 불가!");
    }

    @Override
    protected void move() {
        System.out.printf("%.3f 속도로 이동 중...\n", speed);
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

class Firebat2 extends Unit2 {
    public Firebat2() {
        super("Firebat", 50, (8)*2, 1, 22,
                1.5, 7, 1.875, 1,
                'S', "g", "화염 방사기");
    }

    public Firebat2(
            String name, int life, int power, int defense,
            double atkCycle, double atkRange, int sight, double speed,
            int carrySize, char size, String attackAble, String weapon) {
    }

    @Override
    public void attack() {
        System.out.printf("%s(%d)로 공격 중...\n", weapon, power);
    }

    @Override
    protected void move() {
        System.out.printf("%.3f 속도로 이동 중...\n", speed);
    }

    protected void useSteampack() {
        System.out.println("전투 자극제 사용!");
        System.out.printf("공격 속도 %.4f로 증가! 이동 속도 %.4f로 증가!\n",
                atkCycle/1.72, speed*1.5);
    }
}
