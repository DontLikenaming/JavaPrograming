package examples;
import java.time.LocalDate;
import java.util.Scanner;

public class EX04 {
    public static void main(String[] args) {
        // 이름과 몸무게, 나이를 변수로 선언하고 자신의 것을 값으로 초기화하는
        // 프로그램을 작성하여라 (MyInfo)
/*        Scanner input = new Scanner(System.in);

        System.out.print("이름을 입력하시오. ");
        String name = input.next();
        System.out.print("몸무게를 입력하시오. ");
        Double weight = input.nextDouble();
        System.out.print("나이를 입력하시오. ");
        int age = input.nextInt();

        String age_text = "당신의 이름은 %s이며, 몸무게는 %.1fkg, 나이는 %d살입니다.";
        System.out.printf(age_text, name, weight, age);*/


        // 생년월일을 이용해서 나이를 계산하는 프로그램을 작성하여라. (MyAge)
/*        Scanner input = new Scanner(System.in);

        System.out.println("태어난 날짜를 입력하시오.");
        System.out.println("ex) 2023/04/03");
        String birth = input.nextLine();
        String[] birth_array = birth.split("/");

        int bYear = Integer.parseInt(birth_array[0]);
        int bMonth = Integer.parseInt(birth_array[1]);
        int bDay = Integer.parseInt(birth_array[2]);

        LocalDate today = LocalDate.now();
        int todayYear = today.getYear();
        int todayMonth = today.getMonthValue();
        int todayDay = today.getDayOfMonth();
        String nowtoday = Integer.toString(todayYear)+"년 "+
                          Integer.toString(todayMonth)+"월 "+
                          Integer.toString(todayDay)+"일";


        int age = todayYear-bYear;
        if(bMonth > todayMonth) {
            age--;
        } else if(bMonth == todayMonth) {
            if(bDay > todayDay) {
                age--;
            }
        }

        System.out.printf("오늘은 %s입니다.\n", nowtoday);
        System.out.printf("당신의 나이는 %d살입니다.", age);*/


        // 구구단 중 7단을 출력하는 프로그램을 작성하여라. (GuGu7Dan)
        int dan = 7;

/*        String gugudan = dan + " * " + 1 + " = " + dan * 1 + "\n";
               gugudan += dan + " * " + 2 + " = " + dan * 2 + "\n";
               gugudan += dan + " * " + 3 + " = " + dan * 3 + "\n";
               gugudan += dan + " * " + 4 + " = " + dan * 4 + "\n";
               gugudan += dan + " * " + 5 + " = " + dan * 5 + "\n";
               gugudan += dan + " * " + 6 + " = " + dan * 6 + "\n";
               gugudan += dan + " * " + 7 + " = " + dan * 7 + "\n";
               gugudan += dan + " * " + 8 + " = " + dan * 8 + "\n";
               gugudan += dan + " * " + 9 + " = " + dan * 9 + "\n";

        System.out.println(gugudan);*/



        // 다음 조건을 만족하는 프로그램을 작성하여라 (TimeTime)
        //
        // 하루는 86400초이다. 입력값이 1234567890일 경우 며칠인지 계산하여라
        // 한 시간은 3600초이다. 입력값이 98765일 경우 몇 시간인지 계산하여라
        // 일 분은 60초이다. 입력값이 12345일 경우 몇 분인지 계산하여라.
/*        int daysec = 86400;
        int data1 = 1234567890;
        int hour = 3600;
        int data2 = 98765;
        int minute = 60;
        int data3 = 12345;
        String fmt = "하루는 %d초, %d초는 약 %d일\n";
        System.out.printf(fmt, daysec, data1, data1 / daysec);

        fmt = "한 시간은 %d초, %d초는 약 %d시간\n";
        System.out.printf(fmt, hour, data2, data2 / hour);

        fmt = "1분은 %d초, %d초는 약 %d분\n";
        System.out.printf(fmt, minute, data3, data3 / minute);*/


        // 클래스를 사용해 도서 정보를 출력하는 프로그램을 작성하여라.
/*        class BookInfo {
            private String bookname = "누구나 알기쉬운 자바 : 입문편";
            private String  auther = "카와바 타케시";
            private String  translator = "하진일";
            private String  publisher = "혜지원";
            private String  saledate = "2014년 06월";
            private int  bookprice = 25000;
            private int  bookdsc = 10;
            private double  booksale = bookprice - bookprice * ((double)bookdsc / 100);
            private double bookmile = booksale * ((double)bookdsc / 100);
        }

        BookInfo Info = new BookInfo();
        System.out.println("도서명 : " + Info.bookname);
        System.out.println("저자 : " + Info.auther);
        System.out.println("역자 : " + Info.translator);
        System.out.println("출판사 : " + Info.publisher);
        System.out.println("출간일 : " + Info.saledate);
        System.out.println("정가 : " + Info.bookprice + '원');
        System.out.println("판매가 : " + Math.round(Info.booksale*10)/10 + '원');
        System.out.println("할인율 : " + Info.bookdsc + '%');
        System.out.println("적립금 : " + Math.round(Info.bookmile*10)/10 + '원');*/
    }
}
