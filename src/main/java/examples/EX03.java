package examples;

public class EX03 {
    public static void main(String[] args) {
        // 각 표현식에 대한 결과 값을 계산하여라. 만일 틀린 식이 있다면 수정하여라.

        // 가.  3 + 4.5 * 2 + 27 / 8
        //      [39]
        // 나.  true || false && 3 < 4 || !(5 == 7)
        //      [true]
        // 다.  true || (3 < 5 && 6 >= 2)
        //      [true]
        // 라.  !true > 'A'
        //      [식이 성립되지 않음. boolean과 char를 비교할 순 없음.]
        // 마.  7 % 4 + 3 - 2 / 6 * 'Z'
        //      [6, Z를 아스키코드로 환산해서 계산됨.
        //      또한 정수간의 계산은 무조건 정수가 출력되므로 7 % 4 + 3 부분만 유효함]
        // 바.  'D' + 1 + 'M' % 2 / 3
        //      [69, 위와 마찬가지로 알파벳을 아스키코드로 환산해서 계산됨.]
        // 사.  5.0 / 3 + 3 / 3
        //      [2.6..]
        // 아.  53 % 21 < 45 / 18
        //      [false]
        // 자.  (4 < 6) || true && false || false && (2 > 3)
        //      [true]
        // 차.  7 - (3 + 8 * 6 + 3) - (2 + 5 * 2)
        //      [-59]


        // 8. 다음의 자바 문장에 잘못된 부분이 있는지 알아보고,
        // 만약 올바르다면 출력결과를, 그렇지 않다면 그 이유를 서술하여라

        // 가.  System.out.print( " May 13, 1988 fell on day number ");
        //      [ May 13, 1988 fell on day number ]
        // 나.  System.out.println( ( (13 + (13 * 3 - 1) / 5 + 1988 % 100 + 1988 % 100 / 4 + 1988 / 400
        //      - 2 * (1988 / 100) ) % 7 + 7) % 7 );
        //      [5]
        // 다.  System.out.print( " Check out this line  ");
        //      [ Check out this line  ]
        // 라.  System.out.println( " //hello there " + '9' + 7 );
        //      [ //hello there 97]
        // 마.  System.out.print( 'H' + 'I' + " is " + 1 + "more example" );
        //      [145 is 1more example]
        // 바.  System.out.print( 'H' + 6.5 + 'I' + " is " + 1 + "more example" );
        //      [151.5 is 1more example]
        // 사.  System.out.print( "Print both of us", "Me too" );
        //      [error, print에서 2개 이상의 문자열을 출력하려면 +로 합쳐야 함]
        // 아.  System.out.print( "Reverse " + 'I' + 'T' );
        //      [Reverse IT]
        // 자.  System.out.print( "No! Here is" + 1 + "more example" );
        //      [No! Here is1more example]
        // 차.  System.out.println( "Here is " + 10 * 10) ) // that’s 100 ;
        //      [Here is 100]
        // 카.  System.out.println( "Not x is " + true ); // that’s true.
        //      [Not x is true 가 출력됨]
        // 타.  System.out.print(  );
        //      [print에서 ""는 허용되도 아예 빈칸은 허용되지 않음]
        // 파.  System.out.println;
        //      [()가 빠짐]
        // 하.  System.out.print( "How about this one" ++ '?' + 'Huh?' );
        //      [증감 연산자를 문자에 사용할 수 없음]


        // 요일 계산
/*        System.out.print("Dec 25, 2023\n");
        System.out.println( ( (25 + (25 * 2 - 1) / 12 + 2023 % 100 + 2023 % 100 / 4 + 2023 / 400
                            - 2 * (2023 / 100) ) % 7 + 7) % 7 );*/


        // 각 부울 표현식에 대한 값을 계산하여라. 자바는 단축식 평가
        // short-circuit evaluation을 사용한다는 점에 주의하여라.

        // 가. true && false && true || true
        //     [true]
        // 나. true || true && true && false
        //     [true]
        // 다. (true && false) || (true && ! false) || (false && !false)
        //     [true]
        // 라. (2 < 3) || (5 > 2) && !(4 == 4) || 9 != 4
        //     [true]
        // 마. 6 == 9 || 5 < 6 && 8 < 4 || 4 > 3
        //     [ture]
    }
}
