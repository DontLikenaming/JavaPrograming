package examples;
import java.util.Scanner;
import java.util.ArrayList;

public class EX07 {
    public static void main(String[] args) {
        // 구구단 테이블 출력 (BigGugudan)
/*        int[] gugudan = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("\t\t\t Multiplication Table");
        System.out.print("\t");
        for (int i : gugudan) {
            System.out.print("\t " + i);
        }
        System.out.println("\n------------------------------------------");
        for (int i : gugudan) {
            System.out.print(i+" ㅣ"+"    ");
            for (int j : gugudan) {
                System.out.printf("%2d\t",i*j);
            }
            System.out.print("\n");
        }*/
/*        System.out.println("\t\t Multiplication Table");
        System.out.print("\t 1\t 2\t 3\t 4\t 5\t 6\t 7\t 8\t 9");
        System.out.println("\n------------------------------------------");
        String fmt = "%2dㅣ%2d\t%2d\t%2d\t%2d\t%2d\t%2d\t%2d\t%2d\t%2d\n";
        for(int i=1;i<10;i++){
            System.out.printf(fmt, i, i*1, i*2, i*3, i*4, i*5, i*6, i*7, i*8, i*9);
        }*/


        // 다음의 공식을 이용해서 입력한 년도의 1월 달력을 출력하는 프로그램을
        // 작성하시오. (CalrendarV1)
        // ((년도 - 1) * 365 + (년도 - 1) / 4 - (년도 - 1) / 100 + (년도 - 1) / 400 + 1) % 7
        // 0 : 일, 1 : 월, 2 : 화, … … , 6 : 토
/*        String[] DoW = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        int year = 2023;
        int days = ((year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400 + 1) % 7;
        System.out.println("\t\t\t\t\tJanuary "+year);
        System.out.println("-------------------------------------------------------");
        System.out.print("   ");

        for (String i : DoW) {
            System.out.print(i+"\t  ");
        }

        System.out.print("\n   ");
        for(int j=0;j<days;j++){
            System.out.print("\t\t  ");
        }

        for(int i=0;i<31;i++){
            if((i!=0)&&((i+days)%7==0)){System.out.print("\n   ");}
            System.out.printf("%2d\t  ",i+1);
        }*/


        // 다음 조건에 따라 주민번호 유효성 검사 기능을 구현하시오. (JuminCode)
        // 주민번호 마지막을 뺀 각 자리를 2,3,4,5,6,7,8,9,2,3,4,5 가중치로 곱함
        // 곱한 결과를 각각 모두 더함
        // 더한 값을 11로 나눠 나머지를 구함
        // 11에서 나머지를 뺀 결과값을 구함.
        // 결과값과 주민번호 맨 마지막 자리와 일치여부 검사
        // 나머지가 2자리라면 맨 끝자리와 비교
/*        Scanner input = new Scanner(System.in);
        ArrayList<Integer> jNum = new ArrayList<>(13);
        String[] splitNum;
        String jumin = "";
        int[] checkNum = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};
        int checkSum = 0;
        int mod;
        String result = "잘못된 번호입니다.";

        System.out.println("주민번호를 입력하세요.");
        jumin = input.nextLine();
        splitNum = jumin.split("");
        for (int i=0;i<13;i++) {
            jNum.add(Integer.parseInt(splitNum[i]));
        }
        for(int i=0;i<12;i++){
            checkSum += (jNum.get(i)*checkNum[i]);
        }

        mod = (11-checkSum%11)%10;

        if(mod==jNum.get(12)){
            result = "유효한 번호입니다.";
        }

        System.out.println(result);*/


    }
}
