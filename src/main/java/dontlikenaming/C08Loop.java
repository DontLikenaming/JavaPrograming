package dontlikenaming;
import java.util.Scanner;
import java.util.ArrayList;

public class C08Loop {
    public static void main(String[] args) {
        // while
        // 조건식이 참일 동안 코드불록을 실행하는 반복문
        // for와 다르게 반복 횟수를 모르는 상태에서 실행하는 반복문

        // 1 ~ 10까지 정수 출력
/*        int num = 0;                      // 초기화식
        while (num<10){                     // 조건식
            num++;                          // 증감식
            System.out.print(num+" ");
        }*/


        // 1부터 100 사이 짝수 출력
/*        int num = 0;
        while (num<100){
            num++;
            if(num%10==0) System.out.print(num+"\n");
            else if (num%2==0) {
                if(num<10){System.out.printf("0" +"%d ",num);}
                else {System.out.print(num+" ");}
            }
        }*/


        // 1부터 100 까지 정수 총합 출력
/*        int num = 0;
        int sum = 0;

        while (num<100){
            num++;
            sum += num;
        }
        System.out.printf("1부터 100까지 정수 총합 : %d\n",sum);*/


        // 1부터 100 까지 홀수 총합 출력
/*        int num = 1;
        int sum = 0;

        while (num<100){
            if(num%2==1){
                sum += num;
            }
            num+=2;
        }
        System.out.printf("1부터 100까지 홀수 총합 : %d\n",sum);*/


        // 구구단 출력
/*        int dan = 9;
        int i = 0;
        String fmt = "%d * %d = %2d\n";
        while (i<9){
            i++;
            System.out.printf(fmt, dan, i, dan*i);
        }*/


        // 무한 반복문
        // 반복문의 조건식을 true라고 설정하면
        // 해당 반복문을 무한 실행함

        // 임의의 정수를 계속 입력하면
        // 입력한 정수의 합을 계산함
        // 단, 0을 입력하면 실행을 중지하고
        // 지금까지의 총합을 출력
        // 옵션 : 입력한 모든 정수도 같이 화면에 출력
/*        Scanner input = new Scanner(System.in);
        ArrayList<Integer> vals = new ArrayList<>();
        int sum = 0;
        int idx = 0;

        while (true){
            System.out.println("임의의 정수를 입력하십시오.");
            vals.add(input.nextInt());
            if(vals.get(idx)==0){break;}
            idx++;
        }

        System.out.print("입력된 값 : ");

        for (Integer val : vals) {
            if(val!=0){
            System.out.print(val + " ");
            sum += val;
            }
        }

        System.out.printf("\n총합 : %d\n",sum);*/



    }
}
