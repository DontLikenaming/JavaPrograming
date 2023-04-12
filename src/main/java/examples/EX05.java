package examples;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EX05 {
    public static void main(String[] args) throws IOException {
        // 특정 년도의 윤년 여부를 출력
        // 4로 나뉘어 떨어지며 100으로는 나뉘어 떨어지지 않으면 윤년
        // 400으로 나뉘어 떨어지면 윤년
/*        Scanner input = new Scanner(System.in);
        int year, flag;

        do{
            flag = 1;
            try{

                while (true){
                    System.out.print("년도를 입력하세요. ");
                    year = input.nextInt();
                    if(year<0){
                        System.out.println("기원전 년도는 지원하지 않습니다.");
                    } else {
                        System.out.print(year+"년은 ");
                        break;
                    }
                }

                if((year%4==0)&&(year%100!=0)||(year%400==0)){
                    System.out.print("윤년입니다.");
                } else {
                    System.out.print("윤년이 아닙니다.");
                }

            }
            catch(InputMismatchException e){
                flag=0;
                input.nextLine();
                System.out.println("정수를 입력하세요");
            }

        }while(flag==0);*/

        // 버스 기본요금 부과하기 - 나이를 입력받음
        // 미취학 아동 (~7세) : 0원
        // 어린이 (8~13세) : 450원
        // 청소년 (14~19세) : 720원
        // 일반 (20~69세) : 1200원
        // 노인 (70세~) : 0원
/*        Scanner input = new Scanner(System.in);
        System.out.print("나이를 입력하세요. ");
        int age = input.nextInt();
        int busCharge = 0;

        if (age>=20&&age<70) {
            busCharge = 1200;
        } else if (age>=14) {
            busCharge = 720;
        } else if (age>=8) {
            busCharge = 450;
        }

        System.out.printf("입력받은 나이는 %d세, 버스요금은 %d입니다.", age, busCharge);*/


        // 고객에게 돌려줘야 하는 잔돈을 화폐단위로 계산하는 프로그램
        // 잔돈을 돌려주기 위해 10원, 50원, 100원, 500원, 1000원,
        // 5000원, 10000원, 50000원 등이 몇 개 필요한지 계산하는 것이다. (Charge)
/*        Scanner input = new Scanner(System.in);
        int money = 0;
        int price = 0;
        int charge = 0;
        while (true) {
            System.out.print("투입할 금액을 입력하세요. ");
            money = input.nextInt();
            System.out.print("물품의 가격을 입력하세요. ");
            price = input.nextInt();

            charge = money - price;
            if(charge>0)break;
            else {
                System.out.println("금액이 부족합니다.");
                continue;
            }
        }

        int oman = charge/50000;
        int change = charge % 50000;
        int ilman = change/10000;
        change %= 10000;
        int ochun = change/5000;
        change %= 5000;
        int ilchun = change/1000;
        change %= 1000;
        int obeak = change/500;
        change %= 500;
        int ilbeak = change/100;
        change %= 100;
        int osip = change/50;
        change %= 50;
        int ilsip = change/10;
        change %= 10;

        System.out.println("투입된 금액 : "+money+"원");
        System.out.println("물품의 가격 : "+price+"원");
        System.out.println("반환할 금액 : "+charge+"원");
        System.out.println("------------------------------------");
        System.out.println("5만원권 : "+oman+"장");
        System.out.println("1만원권 : "+ilman+"장");
        System.out.println("5천원권 : "+ochun+"장");
        System.out.println("1천원권 : "+ilchun+"장");
        System.out.println("5백원 동전 : "+obeak+"장");
        System.out.println("1백원 동전 : "+ilbeak+"장");
        System.out.println("5십원 동전 : "+osip+"장");
        System.out.println("1십원 동전 : "+ilsip+"장");
        System.out.println("거스름돈 : "+change+"원");*/


        // 사용자가 연봉과 결혼 여부를 입력하면 다음의 세금율에 의해 납부해야
        // 할 세금을 계산하는 프로그램 (Tax)
        // 미혼인 경우, 연봉 3000미만 : 10%, 3000 이상 : 25%
        // 결혼한 경우, 연봉 6000미만 : 15%, 6000 이상 : 35%
/*        Scanner input = new Scanner(System.in);
        int salary = 0;
        String isMarried = "N";
        int tax = 30;

        while (true) {
            System.out.print("연봉을 입력하세요. (만 단위) ");
            salary = input.nextInt();
            System.out.print("결혼여부를 입력하세요. (Y/N) ");
            isMarried = input.next();


            if (isMarried.equalsIgnoreCase("Y")) {
                if(salary<3000){
                    tax = 10; break;
                } else {
                    tax = 25; break;
                }

            } else if (isMarried.equalsIgnoreCase("N")) {
                if(salary<6000){
                    tax = 15; break;
                } else {
                    tax = 35; break;
                }

            } else {
                System.out.println("잘못 입력하셨습니다.");
                continue;
            }
        }

        System.out.printf("연봉 : %d 만원 결혼 여부 : %s 세율 : %d%%\n", salary, isMarried, tax);*/


        // 사용자로부터 숫자(1 - 9)를 하나 입력 받아, 구구단을 출력하는 프로그램
        // 단, 1 - 9 이외의 숫자나 문자를 입력 받으면
        // “잘못 입력하셨습니다!!”라는 메시지를 출력해야 함 (GuGuDan)
/*        Scanner input = new Scanner(System.in);
        String gugudan = "";
        int dan = 0;
        StringBuilder result = new StringBuilder();

        while (true) {
            System.out.print("숫자를 하나 입력하세요. (1 ~ 9) ");
            gugudan = input.next();
            dan = gugudan.charAt(0);

            if(49<=dan&&dan<=57)break;
            else {
                System.out.println("1 ~ 9 사이의 숫자를 입력해주세요.");
                continue;
            }
        }
        dan = Integer.parseInt(gugudan);
        for(int i = 1;i<10;i++){
            result.append(String.format("%d x %d = %d\n", dan, i, dan * i));
        }
        System.out.print(result);*/

        // 사용자로부터 소문자를 입력 받아 대문자로 출력하는 프로그램
        // 단, 소문자 이외의 숫자나 문자를 입력 받으면 “잘못 입력하셨습니다!!”
        // 라는 메시지를 출력해야 함 (UpperCase)
        // System.in.read()는 키보드로부터 문자 하나를 입력받음
        // 이렇게 입력받은 문자는 ASCII코드값(10진수)이므로
        // 문자로 쓰려면 형변환이 필요함
/*        System.out.println("a~z까지의 소문자를 입력하시오.");
        char ch = (char) System.in.read();
        String result = "";
        if (97 <= ch && ch <= 122) {
            //char Ch = Character.toUpperCase((char)ch);
            char Ch = (char) (ch - 32);
            result = String.format("입력받은 문자는 %c 변환된 문자는 %s", ch, Ch);
        } else {
            result = "잘못 입력하셨습니다.";
        }

        System.out.println(result);*/


        // 임의의 숫자 6자리를 입력하면 신용카드의 종류와 은행정보를 출력 (CardCheck)
/*        Scanner input = new Scanner(System.in);
        int num = 0;
        String result = "";

        while (true) {
            System.out.print("6자리 카드번호를 입력하세요.");
            num = input.nextInt();
            if((num>99999)&&(num<1000000)){
                break;
            }
            System.out.println("잘못 입력하셨습니다.");
        }
        String cardNum = Integer.toString(num);
        String[] Cid = new String[2];
        Cid[0] = cardNum.substring(0,1);
        Cid[1] = cardNum.substring(0,2);

        if(Cid[0].equals("4")){
            result = "비자카드";
            switch (num) {
                case 404825:
                    result += " 비씨카드";
                    break;
                case 438676:
                    result += " 신한카드";
                    break;
                case 457973:
                    result += " 국민은행";
                    break;
                default: break;
            }} else if(Cid[0].equals("5")){
            result = "마스터카드";
            switch (num) {
                case 515594:
                    result += " 신한카드";
                    break;
                case 524353:
                    result += " 외환카드";
                    break;
                case 540926:
                    result += " 국민은행";
                    break;
                default: break;
            }} else if(Cid[1].equals("35")){
            result = "JCB카드";
            switch (num) {
                case 356317:
                    result += " NH농협카드";
                    break;
                case 356901:
                    result += " 신한카드";
                    break;
                case 356912:
                    result += " KB국민카드";
                    break;
                default: break;
            }} else result ="잘못된 카드번호 입니다.";

        System.out.printf("입력된 카드번호 : %d 카드 종류 : %s\n", num, result);*/


        // 거리를 km로 입력했을 때 거리에 따라 배송료를 계산하는 프로그램을 작성
        // (CalcurateFee)
        // 50km 미만 : 10000원
        // 50 ~ 100km : 18000원
        // 100 ~ 300km : 55000원
        // 300km 이상 : 75000원
/*        Scanner input = new Scanner(System.in);
        double dist = 0;
        int result = -1;

        while (true) {
            System.out.println("배송할 거리를 입력하세요.(km 단위, 소수점 이하는 올림처리 됨)");
            dist = input.nextDouble();
            if(dist>0){
                dist = Math.ceil(dist);
                break;
            }
            System.out.println("잘못 입력하셨습니다.");
        }

        if(dist>=300){
            result = 75000;
        } else if(dist>=100){
            result = 55000;
        } else if(dist>=50){
            result = 18000;
        } else {
            result = 10000;
        }

        System.out.printf("%.0fkm의 배송료는 %d입니다.",dist,result);*/
    }
}
