package dontlikenaming;
import java.util.ArrayList;
import java.util.Scanner;

public class C07Array {
    public static void main(String[] args) {
        // 배열
        // 동일한 자료형의 자료를 여러 개 저장하기 위한 자료구조
        // 데이터 입력 순서를 기억, 중복 자료 저장 가능
        // 배열 정의 시 변경 불가능한 고정 크기 자료구조가 만들어짐

        // 자료형[] 변수명 = new 자료형[크기(정수)]
        // 자료형[] 변수명 = {값, 값, ...}
/*       String[] menus = new String[5];
       menus[0] = "라면";
       menus[1] = "짜장면";
       menus[2] = "탕수육";
       menus[3] = "민트초코";
       menus[4] = "떡볶이";
       //menus[5] = "라볶이";    에러 출력됨
        String[] menus = {"라면", "짜장면", "탕수육", "민트초코", "떡볶이"};*/

        // 동적 배열 - ArrayList - collection 프레임워크의 한 요소
        // ArrayList<자료형> 변수명 = new ArrayList<>();
        // import java.util.ArrayList 필요
        // 변수명.add("값") : ArrayList에 값 추가
        // 변수명.get(index) : ArrayList의 특정 index에 있는 값 리턴
        // 변수명.size() : ArrayList에 들어있는 객체의 수 리턴
        // 변수명.indexOf(index) : 해당 객체가 있는 ArrayList의 인덱스 리턴
        // 변수명.contains(값) : 해당 객체가 ArrayList에 있는지 확인
        // 변수명.isEmpty() : ArrayList가 비어있는지 확인
/*        ArrayList<String> menus = new ArrayList<>();
        menus.add("라면");
        menus.add("짜장면");
        menus.add("탕수육");
        menus.add("민트초코");
        menus.add("떡볶이");*/

        // JKD 1.5 이상부터는 향상된 for문 사용 가능
        // 배열 또는 ArrayList 등의 자료구조를 가진 객체에 사용 가능
        // 값을 읽거나 가져올 수는 있지만 바꿀 수는 없음
        // for(자료형 변수명 : 배열명){
        //	        문장
        // }
/*        int num = 0;
        for (String i : menus) {
            num++;
            //if(num==menus.length){System.out.printf(i+"\n");continue;}
            if(num==menus.size()){System.out.printf(i+"\n");continue;}
            System.out.printf(i+", ");
        }*/


        // 5개의 정수를 입력받아 총합, 평균을 구하고 결과 출력
/*        Scanner input = new Scanner(System.in);
        ArrayList<String> num = new ArrayList<>(5);
        int sum = 0;
        final int limitNum = 5;
        double avg;
        for (int i=0;i<limitNum;i++){
            System.out.println("정수를 입력하시오. ("+(i+1)+"/"+limitNum+")");
            num.add(input.nextLine());
            sum += Integer.parseInt(num.get(i));

            if(i==0){
                System.out.print("\n입력된 숫자 : "+num.get(i)+"\n\n");
            } else {
                System.out.print("\n입력된 숫자 : "+num.get(0)+", ");
                for (String j : num) {
                    int J = Integer.parseInt(j);
                    if(J+1==i){System.out.print(num.get(J)+"\n\n");break;}
                    else {System.out.print(num.get(J)+", ");}
                }
            }
*//*                for(int j=1;j<=i;j++){
                    if(j==i){System.out.print(num.get(j)+"\n\n");}
                    else {System.out.print(num.get(j));}
                }*//*
        }
        avg = (double)sum/5;
        System.out.printf("총합 : %d 평균 %.1f\n", sum, avg);*/


        // 성적 처리 프로그램
        // 3명의 학생에 대해
        // 이름, 국어, 영어, 수학점수를 입력받아
        // 총점, 평균, 학점을 계산한 뒤 결과 출력
        // 단, 학점은 수우미양가 중 하나가 출력되어야 함
/*        Scanner input = new Scanner(System.in);
        int[][] stds = new int[3][3];
        String[][] grds = new String[3][4];
        final int limitNum = 3;
        int sum = 0;
        double avg = 0;

        for (int i=0;i<limitNum;i++){
            System.out.println("이름을 입력하십시오.");
            grds[i][0] = input.next();
            System.out.println("국어점수를 입력하십시오.");
            stds[i][0] = input.nextInt();
            sum = stds[i][0];
            System.out.println("영어점수를 입력하십시오.");
            stds[i][1] = input.nextInt();
            sum += stds[i][1];
            System.out.println("수학점수를 입력하십시오.");
            stds[i][2] = input.nextInt();
            sum += stds[i][2];
            grds[i][1] = String.valueOf(sum);

            avg = (double) sum/limitNum;
            grds[i][2] = String.valueOf(avg);

            switch ((int)Math.ceil(avg-1)/10){
                case 10 :
                case 9 : grds[i][3] = "수"; break;
                case 8 : grds[i][3] = "우"; break;
                case 7 : grds[i][3] = "미"; break;
                case 6 : grds[i][3] = "양"; break;
                case 5 :
                default: grds[i][3] = "가"; break;
            }

            System.out.printf("%s의 총점 : %s 평균 : %s 학점 : %s\n\n",
                               grds[i][0], grds[i][1], grds[i][2], grds[i][3]);

        }
        System.out.print("---------------------------------\n");
        for (String[] i : grds) {
            int index = 0;
            for (String j : i) {
                switch (index){
                    case 0 : System.out.printf("이름 : "+j+"\t"); break;
                    case 1 : System.out.printf("총점 : "+j+"\t"); break;
                    case 2 : System.out.printf("평균 : "+j+"\t"); break;
                    case 3 : System.out.printf("학점 : "+j+"\t"); break;
                    default: break;
                }
                index++;
            }
            System.out.print("\n");
        }*/


    }
}
