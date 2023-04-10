package dontlikenaming;

import java.sql.SQLOutput;

public class C13OOP {
    // 메서드 다중정의
    // 객체지향 3대 중요 개념 중 하나인 다형성에 해당
    // 같은 이름의 메서드를 중복해서 정의하는 것을 의미
    // 한 클래스에 같은 이름의 메서드가 2개 이상 존재할 수 있음
    //
    // 메서드 다중정의를 위해서는
    // 메서드 이름은 같지만 매개변수의 자료형 또는 갯수가 달라야 함
    public static void main(String[] args) {
        Cat persian = new Cat("샴", "밤색");

        NotOverloading nol = new NotOverloading();
        ApplyOverloading aol = new ApplyOverloading();

        System.out.println(nol.addInt(10, 20));
        System.out.println(nol.addDouble(10.5, 10.5));
        System.out.println(nol.addInt2(10, 20, 30));

        System.out.println(aol.addNum(10, 20));
        System.out.println(aol.addNum(10.5, 10.5));
        System.out.println(aol.addNum(10, 20, 30));


    }
}

class Cat{
    String breed;
    String color;

    // 매개변수가 있는 생성자를 명시하면 기본 생성자는 작동하지 않음
    public Cat(String breed, String color) {
        this.breed = breed;
        this.color = color;
    }

    // 매개변수가 같은 타입의 생성자는 여러 개 생성할 수 없음
    public Cat(String breed) {
        this.breed = breed;
    }

    /*public Cat(String color) {
        this.color = color;
    }*/

}

class NotOverloading {
    // 간단한 덧셈 프로그램
    // 1. 정수2개를 더하는 메서드
    public int addInt(int x, int y){
        return x + y;
    }
    // 2. 실수2개를 더하는 메서드
    public double addDouble(double x, double y){
        return x + y;
    }
    // 3. 정수3개를 더하는 메서드
    public int addInt2(int x, int y, int z){
        return x + y + z;
    }

    // 메서드 오버로딩을 사용하지 않는 경우
    // 생성할 메서드마다 이름을 제각각으로 정해야 하므로
    // 개발자가 일일히 기억해서 사용해야 하는 불편 초래
}

class ApplyOverloading {
    // 간단한 덧셈 프로그램
    // 1. 정수2개를 더하는 메서드
    public int addNum(int x, int y){
        return x + y;
    }
    // 2. 실수2개를 더하는 메서드
    public double addNum(double x, double y){
        return x + y;
    }
    // 3. 정수3개를 더하는 메서드
    public int addNum(int x, int y, int z){
        return x + y + z;
    }

    // 메서드 오버로딩(다중정의)을 적용하면
    // 메서드의 이름을 하나로 통일해서 작성 가능
    // 단, 메서드를 어떻게 호출할 지만 알고 있으면 됨
}