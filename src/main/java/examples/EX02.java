package examples;

public class EX02 {
    // 79p 3~6
    public static void main(String[] args) {
        // 3번
        int colorPen = 5*12;
        int studentCount = 27;
        int divColorPen = colorPen/studentCount;
        System.out.println("총 색연필 수 : "+colorPen);
        System.out.println("총 학생 인원 수 : "+studentCount);
        System.out.println("학생당 나눠가지는 색연필 수 : "+divColorPen);
        int remainColorPen = colorPen%studentCount;
        System.out.println("똑같이 나눠가지고 남은 볼펜 수 : "+remainColorPen+"\n");

        // 4번
        int age = 3;
        int height = 100;
        boolean parent = true;
        boolean heartDease = true;
        String p = parent ? "있음" : "없음";
        String h = heartDease ? "있음" : "없음";
        String canRide = ((age>=6||(age<6&&height>=120&&parent))&&(height>=120)&&(!heartDease)) ? "탑승 가능" : "탑승 불가능";

        System.out.println("탑승객 나이가 6세 이상이거나 키가 120cm이면서 보호자가 동행하는 경우");
        System.out.println("탑승객 키가 120cm인 경우");
        System.out.println("탑승객에게 심장질환이 있거나 과거 병력이 있는 경우");
        System.out.println("셋 중 하나라도 저촉될 경우 탑승 불가");

        System.out.println("탑승객 나이 : "+age+"세");
        System.out.println("탑승객 신장 : "+height+"cm");
        System.out.println("보호자 여부 : "+p);
        System.out.println("심장질환 여부 : "+h);
        System.out.println("탑승 여부 : "+canRide+"\n");

        // 5번
        int year = 2020;
        boolean leapYear = ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
        System.out.println("입력된 년도 : " + year);
        System.out.println("윤년 여부 : "+leapYear+"\n");

        // 6번
        int price = 123456;
        int oman = price/50000;
        int ilman = (price%50000)/10000;
        int ochun = ((price%50000)%10000)/5000;
        int ilchun = (((price%50000)%10000)%5000)/1000;
        int change = ((((price%50000)%10000)%5000)%1000);

        System.out.println("투입된 금액 : "+price+"원");
        System.out.println("5만원권 : "+oman+"장");
        System.out.println("1만원권 : "+ilman+"장");
        System.out.println("5천원권 : "+ochun+"장");
        System.out.println("1천원권 : "+ilchun+"장");
        System.out.println("거스름돈 : "+change+"원");
    }
}
