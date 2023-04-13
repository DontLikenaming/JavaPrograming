package dontlikenaming;

import java.io.*;
import java.util.Scanner;

public class C23File {
    // 스트림(stream)
    // 데이터를 비트 등의 단위로 조각내어 일련의 연속성을
    // 갖도록 만든 데이터의 나열
    // 일반적으로 스트림이라하면 이러한 데이터의 나열과
    // 이것을 활용하기 위해 사용하는 모듈을 합쳐 부르는 것
    // 즉, 스트림은 데이터를 읽고 쓰기 위한 공통된 방법 제공함

    // 자바에서 스트림 처리 방식은
    // 모든 데이터를 '바이트'로 보는 바이트 단위 스트림과
    // 문자 데이터만을 위한 문자 단위 스트림등이 있음

    // 데이터 영속성(persistence)
    // 데이터를 생성한 프로그램이 종료되더라도
    // 사라지지 않는 데이터의 특성을 의미함
    // 이 것을 위해 파일 시스템이나 관계형 데이터베이스를 이용함
    public static void main(String[] args) {
        // 문자 스트림 다루기
        // ex) 자신의 이름, 키, 나이를 파일에 저장
        String fname1 = "C:/Java/info.txt";
/*        Scanner input = new Scanner(System.in);
        String name;
       int height, age;

        System.out.print("이름 입력 : ");
        name = input.next();
        System.out.print("키 입력(cm) : ");
        height = input.nextInt();
        System.out.print("나이 입력 : ");
        age = input.nextInt();


        File file1 = new File(fname1);
        try {
            FileWriter myWriter = new FileWriter(file1);

            myWriter.write("이름 : "+name+"\n");
            myWriter.write("신장 : "+height+"cm\n");
            myWriter.write("나이 : "+age+"세\n");
            myWriter.close();

            System.out.print("\n성공!\n");

        } catch (Exception ex){
            System.out.println("실패!");
            ex.getMessage();
        }

        // 파일에 저장된 데이터 출력 1 - 문자 하나씩 읽음
        //String fname2 = "C:/Users/Fullstack/Desktop/covid19_1.csv";
        File file2 = new File(fname1);
        try {
            FileReader fr1 = new FileReader(file2);
            // System.out.println((char)fr.read());
            int i = 0;

            // 파일에서 문자를 하나씩 받아와서 출력함
            // 읽어온 문자의 아스키 코드값이 -1이 아니라면
            while ((i=fr.read())!=-1){
                // 문자(char)로 변환해서 출력
                System.out.print((char)i);
            }
            fr.close();
            System.out.print("\n성공!\n");

        } catch (Exception ex){
            System.out.print("실패!");
            ex.getMessage();
        }*/


        // 파일에 저장된 데이터 출력 2 - 한 행씩 읽음
        // BufferedReader를 이용하면 입력속도를 높일 수 있음
        File file3 = new File(fname1);
        try {
            FileReader fr2 = new FileReader(file3);
            BufferedReader br = new BufferedReader(fr2);
            int i = 0;

            while (br.ready()){     // 읽어올 데이터가 있는지 확인
                // 있다면 한 행씩 읽어옴
                System.out.print(br.readLine()+"\n");
            }

            br.close();
            fr2.close();
            System.out.print("\n성공!\n");

        } catch (Exception ex){
            System.out.print("실패!");
            ex.getMessage();
        }
    }
}
