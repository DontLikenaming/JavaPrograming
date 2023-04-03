package dontlikenaming;

import java.sql.SQLOutput;

public class C02Operater {
    // psvm+탭 버튼으로 쉽게 만들 수 있음
    public static void main(String[] args) {
        // 연산자 : 하나 이상의 표현식을 대상으로 산술, 할당, 비교, 논리, 타입 연산을
        //          수행하여 하나의 값을 만드는 기호를 의미

        //산술연산자
        // souf+탭 버튼으로 쉽게 만들 수 있음
        int x = 10, y = 20;
        System.out.printf("%d + %d = %d\n", x, y, x+y);
        System.out.printf("%d - %d = %d\n", x, y, x-y);
        System.out.printf("%d * %d = %d\n", x, y, x*y);
        System.out.printf("%d / %d = %.1f\n", x, y, (double)x/y);
        System.out.printf("%d %% %d = %.0f\n\n", x, y, (double)x%y);

        // sout+탭 버튼으로 쉽게 만들 수 있음
        System.out.println(x==10);
        System.out.printf("%d은 %d보다 크나요? %b\n", x, y, x>y);
        System.out.printf("%d은 %d보다 작나요? %b\n", x, y, x<y);
        System.out.printf("%d과 %d는 같나요? %b\n", x, y, x==y);
        System.out.println(" ");

        System.out.printf("x < 10 AND x < 20 : %b\n", x<10&&x<20);
        System.out.printf("x < 10 OR x < 20 : %b\n", x<10||x<20);
        System.out.printf("NOT(x < 10 AND x < 20 : %b)\n\n", !(x<10||x<20));

        // 자바에선 안되는 것 (연산할 값들의 형식이 다르면 연산 불가)
        // System.out.printf("1 + true : %b\n", 1+true);
        // System.out.printf("false + true : %b\n", false+true);

        // 할당연산자
        System.out.printf("x = %d\n", x);
        int c = x+=2;
        x = 10;
        System.out.printf("x + 2 = %d\n", c);
        c = x-=2;
        x = 10;
        System.out.printf("x - 2 = %d\n", c);
        c = x*=2;
        System.out.printf("x * 2 = %d\n\n", c);

        // 증가, 감소 연산자
        x = 10;
        System.out.printf("++x + 1 = %d\n", ++x+1);

        x = 10;
        System.out.printf("x++ + 1 = %d\n", x+++1);

        x = 10;
        System.out.printf("--x + 1 = %d\n\n", --x+1);

        // 문자열 연산 : +
        String name = "홍길동";
        System.out.println("나의 이름은 "+name);

        String eman = "길홍";
        System.out.printf("%s + %s + %s\n\n", name, eman, name+eman);

        // 삼항 연산자 : if 문의 syntatic sugar
        // 조건식 ? 참일 때 값 : 거짓일 때 값

        // ex) 평균점수가 60 이상이면 '합격'
        // 아니면 '불합격'이라 출력
        double jumsu = 68.5;
        String result =  jumsu>=60 ? "합격" : "불합격";

        String fmt = "평균점수가 %.1f라면 결과는 %s입니다.\n\n";
        System.out.printf(fmt, jumsu, result);
    }
}
