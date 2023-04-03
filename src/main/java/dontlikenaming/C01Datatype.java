package dontlikenaming;

public class C01Datatype {
    public static void main(String[] args){
        // 변수와 자료형
        // 변수는 데이터를 담는 그릇
        // 변수 선언 시, 변수에 저장할 값을 유형을 지정해야 함
        // 값의 유형에는 정수/실수/문자/불리언/문자열 등이 있음

        int a = 3, b = 5;
        // int c = 1.5;
        int c = 3;
        System.out.println("b의 값 : "+b);
        System.out.println("a의 주소값 : "+System.identityHashCode(a)+
                ", c의 주소값 : "+System.identityHashCode(c));

        // 상수 : 변하지 않는 값을 담은 그릇, final로 선언
        // 상수 선언 시, 대문자 사용
        final double PI = 3.14;
        // PI += 1;
        System.out.println(PI);

        // 자료형
        // 자바의 자료형은 기본 자료형과 참조 자료형으로 나뉨
        // 기본 자료형 : 단일값을 다룸 (정수, 실수, 문자, 불리언)
        // 참조 자료형 : 값이 저장된 주소를 다룸 (문자열, 배열, 클래스)

        // 정수 integer : byte, short, int, long
        // 자바에서 정수는 기본적으로 int로 취급됨
        int d = 123;
        byte e = 1;
        short f = 25123;
        // g에 들어갈 값이 long 임을 나타내기 위해 L 접미사 추가
        long g = 1234567890123L;

        // 실수 : float, double
        // 자바에서 실수는 기본적으로 double로 취급됨
        double h = 1234.5678;
        // i에 들어갈 값이 float 임을 나타내기 위해 F 접미사 추가
        float i = 1234.5678F;

        // 문자 : char
        // 자바에서 단일문자를 다룰 때 사용 (작은 따움표로 정의)
        char j = 'a';
        char k = '가';
        char l = '\uAC00';
        System.out.println(l);

        // 논리형 : boolean
        boolean m = true;

        // 문자열 : String
        // 자바에서 다중문자를 다룰 때 사용(큰 따움표로 정의)
        String n = "Hello";
        String o = "🗝";
        System.out.println(o);

        // 형식문자열을 이용한 출력 : printf
        // 정수 : %d, 단일 문자 : %c, 문자열 : %s
        System.out.printf("a: %d, b: %d\n", a, b);

        // ex) 성적 처리프로그램 v1
        // 이름, 국어, 영어, 수학을 초기화시켜서
        // 총점, 평균을 게산한 뒤 결과 출력
        String name = "김철수";
        int kor = 99;
        int eng = 98;
        int mat = 99;

        int tot = kor+eng+mat;
        //double avg = tot/3.0; 정수를 정수로 나누면 결과도 정수
        double avg = tot/3.0;  // 정수를 실수로 나누면 결과는 실수
        System.out.printf("이름 : %s, 총점 : %d, 평균 : %.1f", name , tot, avg);
    }
}
