package dontlikenaming;

public class C10Method {
    public static void main(String[] args) {
        // method
        // 프로그램에서 특정 작업을 수행하기 위한 코드의 집합을 모듈 형태로 작성한 것
        // 특정 작업(코드 블록)을 여러 번 반복할 때 재사용하기 위해 사용

        // 메서드 호출
        sayHello();
        sayHello2("Java");
        sayHello2("HTML");
        System.out.println(sayHello3("Javascript"));

        int year = 2023;
        System.out.println(computeLeapYear(year));

        String time = "17:36:23";
        System.out.println(showAMPM(time));

        int floors = 10;
        System.out.println(showStarPyramid(floors));

    }




    // 메서드 정의
    // 접근제한자 static 반환유형 메서드 이름(매개변수)
    public static void sayHello(){
        System.out.println("Hello, World!!");
    }

    // 메서드 매개변수 사용
    public static void sayHello2(String msg){
        System.out.printf("Hello, %s\n",msg);
    }

    // 반환형 메서드 선언
    public static String sayHello3(String msg){
        return String.format("Hello, %s\n",msg);
    }

    // 연도 입력하면 윤년 여부 계산해서 출력하는 메서드
    public static String computeLeapYear(int year){
        String result = "평년";
        if((year%4==0)&&(year%100!=0)||(year%400==0)){
            result="윤년";
        }
        return String.format("%d년은 %s입니다.\n", year, result);
    }

    // 시분초(12:00:00)를 입력받아 오전, 오후 구분해서 출력하는 메서드
    public static String showAMPM(String time){
        String[] spltime = time.split(":");
        String result = "오후";
        int hour = Integer.parseInt(spltime[0]);

        if(hour<0){
            hour=24+(hour%24);
        } else if(hour>24){
            hour%=24;
        } else if(hour==24){
            hour=0;
        }

        if(hour<12){
            result = "오전";
        }

        time = hour+":"+spltime[1]+":"+spltime[2];

        return String.format("%s는 %s입니다.\n", time, result);
    }

    // 층수를 입력받아 별(*) 피라미드 출력하는 메서드
    public static String showStarPyramid(int floors){
        String result = "";
        for(int i=0;i<floors;i++){
            for(int j=0;j<i+1;j++){
                result += "*";
            }
            result += "\n";
        }
        return String.format("%s\n", result);
    }
}


