package dontlikenaming;

public class C12OOP {
    // 클래스 종류
    // VO/DTO : ValueObject, Data Transfer Object
    // 계층간 데이터 교환을 위한 자바빈즈(JSP 기반 웹 어플리케이션에서 정보를 표현하기 위한 객체)
    // 값만 저장하기 위해 생성하는 클래스
    // 주로 데이터베이스 테이블의 각 열과 연계해서 작성

    public static void main(String[] args) {
        Person2 p2 = new Person2();
        // p2.name = "ㅁㄴㅇㄹ"; // private로 지정되서 외부에서 접근 불가

        // setter로 변수 초기화
        p2.setName("혜교");
        p2.setJob("학생");
        p2.setAge(35);
        p2.setGender('여');

        // getter로 출력
        System.out.println(p2.getName());
        System.out.println(p2.getJob());
        System.out.println(p2.getAge());
        System.out.println(p2.getGender());

        p2.setPerson2("John", "학생", 35, '남');
        // System.out.println(p2.getPerson2());
        System.out.println(p2);
    }
}

class Person2{
    // 멤버 변수 캡슐화
    // 접근 제한자를 이용해서 멤버 변수의 직접 접근을 막음
    private String name, job;
    private int age;
    private char gender;

    public Person2(){}

    // getter / setter 선언
    // private로 선언된 변수를 외부에서 접근할 수 있도록
    // 정의하는 특수한 메서드
    // get"변수명"
    public void setName(String name){
        this.name = name;
    }

    public void setJob(String job){
        this.job = job;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setGender(char gender){
        this.gender = gender;
    }


    public String getName(){
        return name;
    }

    public String getJob(){
        return job;
    }

    public int getAge(){
        return age;
    }

    public char getGender(){
        return gender;
    }


    public void setPerson2(String name, String job, int age, char gender){
        this.name = name;
        this.job = job;
        this.age = age;
        this.gender = gender;
    }

/*    public String getPerson2(){
        return String.format(
                "이름 : %s\n직업 : %s\n나이 : %d\n성별 : %c\n",
                name, job, age, gender);
    }*/

    // toString : 객체의 모든 멤버 변수의 값을 출력할 때 사용하는 메서드
    @Override
    public String toString() {
        String fmt = "이름 : %s\n직업 : %s\n나이 : %d\n성별 : %c\n";
        return String.format(fmt, name, job, age, gender);
    }
}
