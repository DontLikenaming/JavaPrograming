package examples;
import java.util.Random;
import java.util.Scanner;

public class EX06 {
    public static void main(String[] args) {
        // 다음 조건을 만족하는 복권 발행 프로그램을 작성하세요. (Lotto)
        //가. 사용자로부터 복권 숫자 3자리를 입력 받으세요 (yourkey)
        //나. 변수에 임의의 복권 숫자 3자리를 초기화합니다 (lottokey)
        //다. 사용자가 입력한 복권 숫자가 모두 일치 : 상금 1백만 지급
        //라. 일치하지 않는 경우 : “아쉽지만, 다음 기회를!” 라고 출력
/*        Scanner input = new Scanner(System.in);
        int[] yourkey = new int[3];
        int[] lottokey = new int[3];
        int success = 0;
        int check = 0;
        String result = "아쉽지만, 다음 기회를!";

        for (int i=0;i<3;i++) {
            while (true) {
                System.out.println("0부터 9까지의 숫자를 입력하세요. "+(i + 1)+"번째");
                yourkey[i] = Integer.parseInt(input.next());

                if((yourkey[i]>=0)&&(yourkey[i]<10)){
                    break;
                }
                System.out.println("잘못 입력하셨습니다.\n");
            }
        }

        System.out.print("입력한 숫자 : ");
        for (int i=0;i<3;i++) {
            System.out.print(yourkey[i]+" ");
        }

*//*        Random rnd = new Random();
        for (int k=0;k<3;k++) {
            lottokey[k] = rnd.nextInt(9)+1;
        }*//*


        for (int k=0;k<3;k++) {
            lottokey[k] = (int)(Math.random() * 10);
        }


        System.out.print("\n당첨 번호 : ");
        for(int i=0;i<3;i++){
            System.out.print(lottokey[i]+" ");
            for(int j=0;j<3;j++) {
                if (yourkey[i] == lottokey[j]) {
                    success++;
                }
            }
        }

        switch(success){
            case 0: break;
            case 1: result = "1개 일치!"; break;
            case 2: result = "2개 일치!"; break;
            case 3: result = "상금 100만원 지급!!"; break;
        }

        System.out.println("\n"+result);*/


        // 다음 조건에 따라 숫자 맞추기 프로그램을 작성해보세요. (CatchNumber)
        //가. 사용자로부터 1 - 100사이의 숫자를 입력 받으세요 (num1)
        //나. 변수에 임의의 숫자 3자리를 초기화합니다 (num2)
        //다.  num1이 num2보다 크면 “추측한 숫자가 큽니다”라고 출력하세요
        //라.  num1이 num2보다 작으면 “추측한 숫자가 작습니다”라고 출력하세요
        //마.  num1과 num2가 같으면 “빙고! 숫자를 맞췄습니다”라고 출력하고 종료
/*        Scanner input = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        String result = "";
        boolean clear = false;

        for (int i = 0; i < 10; i++) {
            num2 = (int)(Math.random()*100+1);
            while (true) {
                System.out.println("1부터 100까지의 숫자를 입력하세요. ("+(i+1)+"/10)");
                num1 = Integer.parseInt(input.next());

                if((num1>=1)&&(num1<=100)){
                    break;
                }
                System.out.println("잘못 입력하셨습니다.\n");
            }


            System.out.printf("입력한 번호 : %d 당첨 번호 : %d\n", num1, num2);
            switch (Integer.compare(num1,num2)){
                case 0 : result = "빙고! 숫자를 맞췄습니다!"; clear = true; break;
                case 1 : result = "추측한 숫자가 큽니다."; break;
                case -1 : result = "추측한 숫자가 작습니다."; break;
            };

            System.out.println(result+"\n");
            if((i==9)&&(!clear)){System.out.println("다음 기회에!");break;}
            else if(clear) break;
        }*/


        // 키보드로 정수를 하나 입력받아 다음 조건에 따라
        // 결과를 출력하는 프로그램을 작성 (CheckNumber)
        //가. 입력한 값이 10000 보다 작으면 “10000미만” 이라 출력
        //나. 입력한 값이 10000 이상 20000미만 이면 “10000~20000” 이라 출력
        //다. 입력한 값이 20000 이상 30000미만 이면 “20000~30000” 이라 출력
        //라. 입력한 값이 그 이외 값이면 “범위 밖 값” 이라 출력
/*        Scanner input = new Scanner(System.in);
        int num = 0;
        String result = "";
        System.out.println("임의의 정수를 입력하세요.");
        num = Integer.parseInt(input.next());
        result = (num >= 30000) ? "범위 밖 값" :
                 (num > 20000) ? "20000~30000" :
                 (num > 10000) ? "10000~20000" : "10000미만";
        System.out.println(result);*/


        // 현재 수지의 통장잔액은 25,000원이다.
        // 은행이자가 연 6%라 가정할 때,
        // 몇 년이 지나야 통장잔액이 지금의 2배를 넘는지
        // 알아보는 프로그램 작성 (ComputeInvestment)
        // 원금 25000원에 연 이율 6%를 적용하면 12년 뒤에 2배 수익을 얻을 수 있음.
        int balance = 25000;
        int dest = balance;
        double interest = 0.06;
        int year = 0;
        while (true){
            if(year==0){System.out.printf("첫 해 예금액 %d원 이자 %.0f원\n", balance, balance*interest);}
            else {System.out.printf("%d년 후 예금액 %d원 이자 %.0f원\n", year, balance, balance*interest);}
            year++;
            balance += balance*interest;
            if(balance>dest*2)break;
        }
        System.out.printf("%d년 후 예금액 %d원 이자 %.0f원 (원금 2배 초과)\n",
                          year, balance, balance*interest);


    }
}
