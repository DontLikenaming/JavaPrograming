package dontlikenaming;
import java.util.Objects;
import java.util.Scanner;

public class C05Condition {
    public static void main(String[] args) {
        // 제어문
        // 프로그램의 실행 순서를 제어할 수 있는 명령문
        // 조건문, 반복문, 분기문

        // 조건문
        // 조건에 대한 만족 여부에 따라 실행할 코드를 결정하는 명령문
        // ex) 짝수 홀수 여부 출력
/*        Scanner input = new Scanner(System.in);

        System.out.println("임의의 정수 홀짝 여부 판단");
        System.out.println("숫자를 입력하시오.");
        double num = input.nextDouble();

        System.out.println(Math.round(num*10));

        if((Math.round(num*10)%10!=0)&&num!=0){
            System.out.println("정수를 입력하세요.");
        } else if(num%2==0){
            System.out.println("짝수입니다.");
        } else if(num%2==1||num%2==-1){
            System.out.println("홀수입니다.");
        }*/

        // ex) 오전, 오후 구분
        // 문자 추출 : charAt(위치)
/*        String time = "09:47:15";

        int hour = Integer.parseInt(time.charAt(0)+""+time.charAt(1));
        System.out.println(hour+"시");

        if(hour>=12){
            System.out.println("오후입니다.");
        } else if(hour<12){
            System.out.println("오전입니다.");
        }*/

        // ex) 나이가 18세 이상이면 투표 가능하다고 출력
/*        Scanner input = new Scanner(System.in);

        System.out.println("투표 가능한 나이 판단");
        System.out.println("나이를 입력해주세요.");
        double num = input.nextDouble();

        if((Math.round(num*10)%10!=0)&&num!=0){
            System.out.println("정수로 입력해주세요.");
        } else if(num>=18&&num<=122){
            System.out.println("투표 가능한 나이입니다.");
        } else if(num>122||num<=0){
            System.out.println("나이를 제대로 입력해주세요.");
        } else {
            System.out.println("아직 투표를 할 수 없습니다.");
        }*/

        // ex) 점수가 60점 이상이면, '시험 합격!!"을 출력
        // 점수가 60점 미만이면, '시험 불합격!!"을 출력
/*        System.out.println("점수를 입력해주세요.");
        double jumsu = input.nextDouble();

        if (jumsu>=60){
            System.out.println("시험 합격!!");
        } else {
            System.out.println("시험 불합격!!");
        }*/

        // ex) 아이디와 비밀번호를 이용해서 로그인 기능 구현하기
        // String형 변수는 == 연산자로 비교하면 주소값을 비교함
        // 정수, 실수와는 달리 String은 참조자료형이기 때문
        // 문자열 값 자체를 비교하기 위해서는 equals()를 사용해야 함
/*        Scanner input = new Scanner(System.in);
        String userid = "abc123";
        String passwd = "987zyx";

        System.out.println("아이디를 입력해주세요.");
        String inputId = input.next();
        System.out.println("비밀번호를 입력해주세요.");
        String inputPwd = input.next();

        if(!inputId.equals(userid)){
            System.out.println("입력하신 아이디가 없습니다.");
        } else if(!inputPwd.equals(passwd)){
            System.out.println("비밀번호가 잘못되었습니다.");
        } else {
            System.out.println("환영합니다. "+inputId+"님.");
        }*/

        // 중첩 조건문 - 가독성 저하로 권장하지 않음
        // if문 안에 또 다른 if문을 작성하는 것
        // ex) 윤년 여부를 출력
        // 4로 나뉘어 떨어지며 100으로는 나뉘어 떨어지지 않으면 윤년
        // 400으로 나뉘어 떨어지면 윤년
/*        int year = 2023;

        if(year % 4 == 0) {
            if (year % 100 == 0) {
                System.out.println("평년");
            } else {
                System.out.println("윤년");
            }
        } else {
            if (year % 400 == 0){
                System.out.println("윤년");
            } else {
                System.out.println("평년");
            }
        }*/

        // 다중 조건문
        // 둘 이상의 조건을 처리하는 조건문
        // if ~ else 뒤에 if ~ else를 더 추가함

        // ex) 점수에 따라 수우미양가 성적결과 출력
/*        double avg = 76.4;
        char grd = '가';

        if(avg>90) grd = '수';
        else if(avg>80) grd = '우';
        else if(avg>70) grd = '미';
        else if(avg>60) grd = '양';

        System.out.printf("점수 : %.1f 등급 : %s\n",avg ,grd);*/

        // switch
        // 다중 조건문을 가독성 있게 작성한 조건문
        // switch의 표현식을 평가하여 그 값의 일치여부에 따라
        // case문 아래의 코드 블록을 실행하는 구조
        // swtich 안에 결과값이 boolean인 식은 넣을 수 없음
/*        int num = 74;
        String result = "";

        switch(num%2){
            case 0 : result = "짝수"; break;
            case 1 : result = "홀수"; break;
        }

        System.out.printf("%d는 %s\n",num,result);*/

        // ex) switch문을 사용하여 점수에 따라 수우미양가 출력
/*        double avg = 76.4;
        char grd = '가';

        switch(((int)avg-1)/10){
            case 9 : grd = '수'; break;
            case 8 : grd = '우'; break;
            case 7 : grd = '미'; break;
            case 6 : grd = '양'; break;
            default: break;
        }

        System.out.printf("점수 : %.1f 등급 : %c\n",avg ,grd);*/

        // ex) 월, 윤년여부(Y/N)를 입력하면 해당 월의 마지막 날을 출력
        // 1,3,5,8,10,12 - 31일
        // 4,6,9,11 - 30일
        // 2 - 윤년 여부에 따라 28(N)일 or 29(Y)일
        Scanner input = new Scanner(System.in);

        System.out.println("월을 입력하세요.");
        int month = input.nextInt();

        String lastDay = "";

        switch (month){
            case 1 :
            case 3 :
            case 5 :
            case 7 :
            case 8 :
            case 10 :
            case 12 : lastDay = "31일"; break;

            case 4 :
            case 6 :
            case 9 :
            case 11 : lastDay = "30일"; break;
            case 2 :
                System.out.println("윤년인가요? (Y/N)");
                String isLeapYear = input.next();

                if(isLeapYear.equalsIgnoreCase("Y")){
                    lastDay = "29일"; break;
                } else if(isLeapYear.equalsIgnoreCase("N")){
                    lastDay = "28일"; break;
                } else {
                    lastDay = "error"; break;
                }
            default: lastDay = "error"; break;
        }

        System.out.printf("입력된 달 : %d월 마지막 날 : %s\n", month, lastDay);


    }
}
