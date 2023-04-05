package dontlikenaming;
import java.util.Scanner;

public class C06Loop {
    public static void main(String[] args) {
        // 반복문
        // 일정 횟수만큼 어떤 코드(들)을 반복해서 실행하는 제어문
        // 반복적으로 실행하는 동작을 loop라고 함
        // 자바에서는 기본적으로 for, while, do-while 등이 지원되며
        // 추가적으로 for-each(배열 및 ArrayList의 객체에 대한 반복문)도 있음

        // for문
        // 1 ~ 10까지 정수 출력
/*        for(int i = 1; i<=10; i++){
            System.out.println(i);
        }*/


        // 1 ~ 100까지 짝수 출력
/*        for(int i = 1; i<=100; i++){
            if(i%2==0){System.out.println(i);}
        }*/


        // 1 ~ 100까지 짝수 출력
/*        for(int i = 2; i<=100; i+=2){
            System.out.println(i);
        }*/


        // 1 ~ 100까지 총합 출력
/*        int odd = 0;
        for(int i = 1; i<=100; i++){
            odd+=i;
        }
        System.out.println(odd);*/


        // 1 ~ 100까지 짝수 총합 출력 1
        /*System.out.println((1+100)*(100-1+1)/2);*/
/*        int odd = 0;
        for(int i = 1; i<=100; i++){
            if(i%2==0){odd+=i;}
        }
        System.out.println(odd);*/


        // 1 ~ 100까지 짝수 총합 출력 2
/*        int odd = 0;
        for(int i = 0; i<=100; i++){
            if((100-i)%2==0){odd+=i+(100-i);}
        }
        System.out.println(odd/2);*/


        // 1 ~ 100까지 짝수 총합 출력 3
/*        int odd = 0;
        for(int i = 0; i<=100; i+=2){
            odd+=i;
        }
        System.out.println(odd);*/


        // 10부터 1까지 정수 출력
/*        for(int i=10;i>=1;i--){
            System.out.println(i);
        }*/


        // 구구단 출력
        // 2 x 1 = 2
        // 2 x 2 = 4
        // ...
/*        int dan = 2;
        for(int i=1;i<=9;i++){
            System.out.printf("%d * %d = %d\n",dan,i,dan*i);
        }*/


        // 무한 반복문
        // for문의 경우 초기식, 조건식, 증감식을 비워두면
        // 끝없이 반복하여 실행됨
/*        for(;;){
            System.out.println("Hello, World!!");
        }*/


        // 5개의 정수를 입력받아 총합, 평균을 구하고 결과 출력
/*        Scanner input = new Scanner(System.in);
        String[] num = new String[5];
        int sum = 0;
        double avg;
        for (int i=0;i<num.length;i++){
            System.out.println("정수를 입력하시오. ("+(i+1)+"/5)");
            num[i] = input.next();
            sum += Integer.parseInt(num[i]);

            if(i==0){
                System.out.print("\n입력된 숫자 : "+num[i]+"\n\n");
            } else {
                System.out.print("\n입력된 숫자 : "+num[0]);
                for(int j=1;j<=i;j++){
                    if(j==i){System.out.print(num[j]+"\n\n");}
                    else {System.out.print(num[j]);}
                }
            }
            num[i] += ", ";
        }
        avg = (double)sum/5;
        System.out.printf("총합 : %d 평균 %.1f\n", sum, avg);*/


        // 분기문 : break
        // 원하는 시점에 반복문이나 코드블록에서 벗어남

        // 1부터 10000까지의 총합을 계산
        // 단, 총합이 10000을 넘으면 계산 중단
/*        int i = 0;
        int sum = 0;
        for(i = 0;i<=10000;i++){
            sum += i;
            if(sum>10000)break;
        }
        System.out.printf("합한 마지막 숫자 : %d, 총합 : %d\n",i, sum);*/


        // 분기문 : continue
        // 반복을 일시적으로 건너뛰어 다음 반복으로 넘어가도록 함

        // 1부터 10000까지의 총합을 계산
        // 단, 5의 배수와 7의 배수는 계산에서 제외
        int sum = 0;
        for(int i = 0;i<=10000;i++){
            if((i%5==0)||(i%7==0))continue;
            sum += i;
        }
        System.out.printf("총합 : %d\n", sum);
    }
}
