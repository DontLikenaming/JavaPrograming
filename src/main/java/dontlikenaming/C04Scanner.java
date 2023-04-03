package dontlikenaming;
import java.util.Scanner;

public class C04Scanner {
    public static void main(String[] args) {
        // 데이터 입력 : Scanner
        Scanner input = new Scanner(System.in);

        // 이름을 입력받기
/*        System.out.println("이름을 입력하시오.");
        String Fname = input.next();
        System.out.println("성을 입력하시오.");
        String Lname = input.next();
        System.out.println("나이를 입력하시오.");
        int age = input.nextShort();
        System.out.println("이름 : "+Fname+" "+Lname);
        System.out.println("나이 : "+age+"세");*/
        // next는 줄바꿈 혹은 공백(공백 특수문자 포함) 이전까지 입력받음

        // ex) 성적 처리프로그램 v2
        // 이름, 국어, 영어, 수학을 키보드로 입력받아
        // 총점, 평균, 학점을 계산한 뒤 결과 출력
        System.out.print("이름을 입력하시오. ");
        String name = input.next();
        System.out.print("국어점수를 입력하시오. ");
        double kor = input.nextDouble();
        System.out.print("영어점수를 입력하시오. ");
        double eng = input.nextDouble();
        System.out.print("수학점수를 입력하시오. ");
        double mat = input.nextDouble();

        double tot = kor+eng+mat;
        double avg = tot/3;
        char grd = (avg>90)?'수':
                    (avg>80)?'우':
                    (avg>70)?'미':
                    (avg>60)?'양':'가';
        System.out.printf("이름 : %s 총점 : %.1f 평균 : %.1f 학점 : %c",
                           name, tot, avg, grd);
        input.close();
    }
}
