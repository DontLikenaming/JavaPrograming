package dontlikenaming;

public class C18OOP {
    // 인터페이스(interface)
    // 사물과 사물 사이 또는 사물과 인간 사이의 경계에서,
    // 상호 간의 소통을 위해 사용하는 물리적/논리적 매개체나 프로토콜
    // 사람 <- (말, 글) -> 사람
    // 컴퓨터 <- (입력장치, 출력장치) -> 사람
    // 객체 <- (메서드) -> 객체

    // 자바에서는 추상 메서드와 상수만으로 구성된
    // 특수한 클래스를 의미함
    // 어떤 클래스를 만들 때 추상 메서드를 통해
    // 기본이 되는 틀을 제공하여 규칙에 맞춰
    // 코드를 짤수 있게 해 줌
    // => 접근제한자는 언제나 public으로 고정
    // 클래스와는 달리 다중상속을 지원함

    // 인터페이스 작성시 interface 를 사용
    // 인터페이스를 구현할때는 implements를 사용

    public static void main(String[] args) {
        // 인터페이스도 객체화 불가
        // UnitAction ua = new UnitAction();

        SCV3 scv3 = new SCV3();
        Marine3 marine3 = new Marine3();
        Medic3 medic3 = new Medic3();
        Firebat3 firebat3 = new Firebat3();

        System.out.printf("%s\n", scv3.getName());
        System.out.printf("체력 : %d\n",scv3.getLife());
        scv3.collect();
        scv3.attack();
        scv3.move();

        System.out.printf("\n%s\n", marine3.getName());
        System.out.printf("체력 : %d\n",marine3.getLife());
        marine3.useSteampack();
        marine3.attack();
        marine3.move();

        System.out.printf("\n%s\n", medic3.getName());
        System.out.printf("체력 : %d\n",medic3.getLife());
        medic3.useHealing();
        medic3.useRestoration();
        medic3.useOpticalflare();
        medic3.attack();
        medic3.move();

        System.out.printf("\n%s\n", firebat3.getName());
        System.out.printf("체력 : %d\n",firebat3.getLife());
        firebat3.useSteampack();
        firebat3.attack();
        firebat3.move();


    }
}

abstract class Unit3 {
    protected String name;
    protected int life;
    protected int power;
    protected int defense;
    protected double atkCycle;
    protected double atkRange;
    protected int sight;
    protected double speed;
    protected int carrySize;
    protected char size;
    protected String attackAble;
    protected String weapon;

    public Unit3() {}

    public Unit3(
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
    
}

interface Unit3Action {
    public abstract void attack();
    public abstract void move();
}

class SCV3 extends Unit3 implements Unit3Action{
    public SCV3() {
        // super : 부모 클래스의 생성자를 호출하는 특수한 키워드
        super("SCV", 60, 5, 0, 15,
                1, 7, 2.344, 1,
                'S', "g", "융합 절단기");
    }

    public SCV3(
            String name, int life, int power, int defense,
            double atkCycle, double atkRange, int sight, double speed,
            int carrySize, char size, String attackAble, String weapon) {
    }

    protected String getName() {
        return name;
    }

    protected int getLife() {
        return life;
    }

    protected void collect() {
        System.out.println("자원 채취 중..");
    }


    @Override
    public void attack() {
        System.out.printf("%s(%d)로 공격 중...\n", weapon, power);
    }

    @Override
    public void move() {
        System.out.printf("%.3f 속도로 이동 중...\n", speed);
    }
}

class Marine3 extends Unit3 implements Unit3Action {
    public Marine3() {
        super("Marine", 40, 6, 0, 15,
                4, 7, 1.875, 1,
                'S', "gs", "가우스 소총");
    }

    public Marine3(
            String name, int life, int power, int defense,
            double atkCycle, double atkRange, int sight, double speed,
            int carrySize, char size, String attackAble, String weapon) {
    }

    protected String getName() {
        return name;
    }

    protected int getLife() {
        return life;
    }

    @Override
    public void attack() {
        System.out.printf("%s(%d)로 공격 중...\n", weapon, power);
    }

    @Override
    public void move() {
        System.out.printf("%.3f 속도로 이동 중...\n", speed);
    }

    protected void useSteampack() {
        System.out.println("전투 자극제 사용!");
        System.out.printf("공격 속도 %.4f로 증가! 이동 속도 %.4f로 증가!\n",
                atkCycle/1.72, speed*1.5);
    }
}

class Medic3 extends Unit3 implements Unit3Action {
    public Medic3() {
        super("Medic", 60, 0, 1, 0,
                0, 9, 1.875, 1,
                'S', "", "");
    }

    public Medic3(
            String name, int life, int power, int defense,
            double atkCycle, double atkRange, int sight, double speed,
            int carrySize, char size, String attackAble, String weapon) {
    }

    protected String getName() {
        return name;
    }

    protected int getLife() {
        return life;
    }

    @Override
    public void attack() {
        System.out.println("일반 공격 불가!");
    }

    @Override
    public void move() {
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

class Firebat3 extends Unit3 implements Unit3Action {
    public Firebat3() {
        super("Firebat", 50, (8)*2, 1, 22,
                1.5, 7, 1.875, 1,
                'S', "g", "화염 방사기");
    }

    public Firebat3(
            String name, int life, int power, int defense,
            double atkCycle, double atkRange, int sight, double speed,
            int carrySize, char size, String attackAble, String weapon) {
    }

    protected String getName() {
        return name;
    }

    protected int getLife() {
        return life;
    }

    @Override
    public void attack() {
        System.out.printf("%s(%d)로 공격 중...\n", weapon, power);
    }

    @Override
    public void move() {
        System.out.printf("%.3f 속도로 이동 중...\n", speed);
    }

    protected void useSteampack() {
        System.out.println("전투 자극제 사용!");
        System.out.printf("공격 속도 %.4f로 증가! 이동 속도 %.4f로 증가!\n",
                atkCycle/1.72, speed*1.5);
    }
}
