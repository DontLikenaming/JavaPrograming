package dontlikenaming;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class C20Exception {
    // 예외(exception)와 오류(error)
    // 자바프로그램 작성시 문법에 맞지 않게 코드를 작성하면
    // 컴파일 오류가 발생함
    // 또한, 코드가 제대로 작성되었다 하더라도 실행 중에
    // 예상치 못한 상황으로 실행 오류가 발생할 수 있음
    // 이처럼 프로그램 실행 중에 예상치 못한 상황으로
    // 프로그램이 영향을 받는 것을 오류와 예외로 구분함

    // 일반적으로 오류는 시스템 단계에서 프로그램에 심각한 문제를
    // 야기해서 실행중인 프로그램을 강제 중단시킴
    // -> 네트워크 상 접속 오류, 메모리 부족
    // 이러한 오류는 개발자가 처리할 수 없음

    // 반면, 예외는 오류와 마찬가지로 실행중인 프로그램을 중단시키지만
    // 발생할 수 있는 상황을 미리 예측하여 코드를 통해
    // 프로그램 실행 중단을 방지할수 있음
    public static void main(String[] args) {
/*        // 예외 처리 전 1
        System.out.println("프로그램 시작1");
        System.out.println("프로그램 끝1");
        System.out.println("----------------");

        // 예외 처리 전 2
        System.out.println("프로그램 시작2");
        int a = 0, b = 20;
        int c = a + b;
        System.out.println(c);
        System.out.println("프로그램 끝2");
        System.out.println("----------------");

        // 예외 처리 전 3
        System.out.println("프로그램 시작3");
        int d = 10, e = 0;
        int f = d / e;          // 예외 발생(ArithmeticException)으로 인한 실행중단
        System.out.println(c);
        System.out.println("프로그램 끝3");
        System.out.println("----------------");

        // 예외처리 구분 1
        // try{
        //    예외 발생 가능성이 있는 코드
        // }
        // catch(예외 종류){
        //    예외처리 핸들러
        // }

        // 예외 처리 1
        System.out.println("프로그램 시작3a");
        int d1 = 10, e1 = 0;
        try {
            int f1 = d1 / e1;
            System.out.println(f1);
        } catch (Exception ex){   // 모든 예외를 감지해서 처리
            System.out.printf("%d / %d 은(는) 계산할 수 없습니다!\n",d1,e1);
            System.out.println(ex.getMessage());
        }
        System.out.println("프로그램 끝3a");
        System.out.println("----------------");


        // ex) 1~9 사이의 정수만 입력받아 화면에 출력하는 코드 작성
        // 정수가 아닌 문자를 입력받을 시
        // "1~9 사이 정수만 입력 가능합니다." 라고 출력되게 해야 함
        Scanner input = new Scanner(System.in);
        int num, flag1;

        do{
            flag1 = 1;
            try{
                while (true){
                    System.out.print("1 ~ 9 사이의 정수를 입력하세요. ");
                    num = input.nextInt();
                    if(num<1||num>9){
                        throw new InputMismatchException();
                    } else {
                        System.out.printf("입력 받은 숫자 : %d",num);
                        break;
                    }
                }
            }
            catch(InputMismatchException ex){
                flag1=0;
                input.nextLine();
                System.out.println("잘못 입력하셨습니다!");
            }
        }
        while(flag1==0);

        // 예외 처리 2
        // RuntimeException, ArithmeticException 등의 예외 클래스를
        // 특정해서 catch 할 수도 있음
        System.out.println("프로그램 시작3b");
        int d2 = 10, e2 = 0;
        try {
            int f2 = d2 / e2;
            System.out.println(f2);
        } catch (ArithmeticException ex){
            System.out.printf("%d / %d 은(는) 계산할 수 없습니다!\n",d2,e2);
        }
        System.out.println("프로그램 끝3b");
        System.out.println("----------------");
        
        // ex) 학생 3명의 이름을 입력받아 화면에 출력하는 코드 작성
        // 학생 수 초과 입력 시 발생할 예외도 처리할 것
        Scanner input = new Scanner(System.in);
        int num = 0;
        String[] stdname = new String[3];


        try{
            while (true){
                System.out.printf("학생 이름을 입력하세요. (%d번 가능) \n", 3-num);
                stdname[num] = input.next();
                System.out.printf("입력 받은 이름 : %s\n", stdname[num]);
                num++;
            }
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("3명까지만 입력할 수 있습니다!");
            System.out.print("입력 받은 이름 : ");
            for(int i=0;i<stdname.length;i++){
                if(i!=stdname.length-1){
                    System.out.printf("%s, ",stdname[i]);
                } else {
                    System.out.printf("%s",stdname[i]);
                }
            }
        }


        // 예외 종류
        // 비검사형 예외 : unchecked exception (런타임 예외)
        // 검사형 예외 : checked exception (컴파일타임 예외)

        // 비검사형 예외
        // 명시적인 예외 처리를 강제하지 않음 - 개발자에 맡김
        // 실행할 때 예외 발생을 확인할 수 있음
        // ArithmeticException
        // ArrayIndexOutOfBoundsException
        // InputMismatchException

        // 검사형 예외
        // 명시적인 예외처리를 강제함 - 반드시 처리해야 함!
        // 컴파일 할 때 예외 발생을 확인할 수 있음
        // IOException
        // ClassNotFoundException
        // 검사형 예외를 피하고 싶으면 throws를 이용해서
        // 예외 처리를 외부로 넘기면 됨 (권장되지 않음)

        // sungjuk.data 파일을 읽어와서 화면에 출력
        File f = new File("c:/Java/sungjuk.data");
        try {
            FileInputStream fis = new FileInputStream(f); // 검사형 예외 (FileNotFoundException)
        } catch (FileNotFoundException e) {
            System.out.print("파일이 존재하지 않습니다!");;
        }*/

        // 예외처리 3
        // 사용자 정의 예외 - 개발자 입맛에 맞는 예외 메세지 출력 가능
        // Exception 클래스를 상속해서 만들어야 함
        System.out.println("프로그램 시작4");
        int d3 = 10, e3 = 0;
        try {
            try{
            int f3 = d3 / e3;
            System.out.println(f3);
            } catch (ArithmeticException ex){
                String message = String.format("%d / %d 은(는) 계산할 수 없습니다!",d3,e3);
                throw new ZeroDivideException(message);
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("프로그램 끝4");
        System.out.println("----------------");

    }
}

// 사용자 정의 예외 - 0으로 나누려 할 때 발생하는 예외에 대한 클래스
class ZeroDivideException extends Exception {
    public ZeroDivideException(String message) {
        super(message);
    }
}