package examples;

public class EX02 {
    // 79p 3~6
    public static void main(String[] args) {
        // 3번
        int colorPen = 5*12;
        int studentCount = 27;
        int divColorPen = colorPen/studentCount;
        System.out.println("학생당 나눠가지는 색연필 수 : "+divColorPen);
        int remainColorPen = colorPen%studentCount;
        System.out.println("똑같이 나눠가지고 남은 볼펜 수 : "+remainColorPen);

        // 4번
        int age = 3;
        int height = 150;
        boolean parent = true;
        boolean hearchDease = false;
        String canRide = ((age>=6||(age<6&&height>=120&&parent))&&(height>=120)&&(!hearchDease)) ? "탑승 가능" : "탑승 불가능";
        System.out.println("탑승 여부 : "+canRide);

        // 5번
        int year = 2020;
        boolean leapYear = ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
        System.out.println(leapYear);

        // 6번
        int price = 187000;
        int oman = price/50000;
        int ilman = (price%50000)/10000;
        int ochun = ((price%50000)%10000)/5000;
        int ilchun = (((price%50000)%10000)%5000)/1000;

        System.out.println("5만원권 : "+oman+"장");
        System.out.println("1만원권 : "+ilman+"장");
        System.out.println("5천원권 : "+ochun+"장");
        System.out.println("1천원권 : "+ilchun+"장");
    }
}
