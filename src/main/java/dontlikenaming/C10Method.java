package dontlikenaming;
import java.util.Scanner;

public class C10Method {
    public static void main(String[] args) {
        // method
        // 프로그램에서 특정 작업을 수행하기 위한 코드의 집합을 모듈 형태로 작성한 것
        // 특정 작업(코드 블록)을 여러 번 반복할 때 재사용하기 위해 사용

        // 메서드 호출
/*        sayHello();
        sayHello2("Java");
        sayHello2("HTML");
        System.out.println(sayHello3("Javascript"));

        int year = 2023;
        System.out.println(computeLeapYear(year));

        String time = "17:36:23";
        System.out.println(showAMPM(time));

        int floors = 10;
        System.out.println(showStarPyramid(floors));*/

        // 성적 처리 프로그램
        int[][] stds = new int[3][3];
        String[][] grds = new String[3][4];
        int sum = 0;
        final int limitNum = 3;
        double avg = 0;
        String result = "";
        readSungJuk(grds, stds, limitNum, sum);
        computeSungJuk(grds, stds, limitNum, sum, avg);
        printSungJuk(grds, result);


    }


    // 메서드 정의
    // 접근제한자 static 반환유형 메서드 이름(매개변수)
    public static void sayHello() {
        System.out.println("Hello, World!!");
    }

    // 메서드 매개변수 사용
    public static void sayHello2(String msg) {
        System.out.printf("Hello, %s\n", msg);
    }

    // 반환형 메서드 선언
    public static String sayHello3(String msg) {
        return String.format("Hello, %s\n", msg);
    }

    // 연도 입력하면 윤년 여부 계산해서 출력하는 메서드
    public static String computeLeapYear(int year) {
        String result = "평년";
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            result = "윤년";
        }
        return String.format("%d년은 %s입니다.\n", year, result);
    }

    // 시분초(12:00:00)를 입력받아 오전, 오후 구분해서 출력하는 메서드
    public static String showAMPM(String time) {
        String[] spltime = time.split(":");
        String result = "오후";
        int hour = Integer.parseInt(spltime[0]);

        if (hour < 0) {
            hour = 24 + (hour % 24);
        } else if (hour > 24) {
            hour %= 24;
        } else if (hour == 24) {
            hour = 0;
        }

        if (hour < 12) {
            result = "오전";
        }

        time = hour + ":" + spltime[1] + ":" + spltime[2];

        return String.format("%s는 %s입니다.\n", time, result);
    }

    // 층수를 입력받아 별(*) 피라미드 출력하는 메서드
    public static String showStarPyramid(int floors) {
        String result = "";
        for (int i = 0; i < floors; i++) {
            for (int j = 0; j < i + 1; j++) {
                result += "*";
            }
            result += "\n";
        }
        return String.format("%s\n", result);
    }

    // 성적 처리 프로그램 (메서드로 작성)
    // 3명의 학생에 대해
    // 이름, 국어, 영어, 수학점수를 입력받아
    // 총점, 평균, 학점을 계산한 뒤 결과 출력
    // 단, 학점은 수우미양가 중 하나가 출력되어야 함
    public static void readSungJuk(
            String[][] grds, int[][] stds, final int limitNum, int sum) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < limitNum; i++) {
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
        }
    }

    public static void computeSungJuk(
            String[][] grds, int[][] stds, final int limitNum, int sum, double avg) {
        for (int i = 0; i < limitNum; i++) {
            sum += stds[i][2];
            grds[i][1] = String.valueOf(sum);

            avg = (double)Math.round( ((double)sum / limitNum)*10 )/10;
            grds[i][2] = String.valueOf(avg);

            switch ((int) Math.ceil(avg - 1) / 10) {
                case 10:
                case 9:
                    grds[i][3] = "수";
                    break;
                case 8:
                    grds[i][3] = "우";
                    break;
                case 7:
                    grds[i][3] = "미";
                    break;
                case 6:
                    grds[i][3] = "양";
                    break;
                case 5:
                default:
                    grds[i][3] = "가";
                    break;
            }

            System.out.printf("%s의 총점 : %s 평균 : %s 학점 : %s\n\n",
                    grds[i][0], grds[i][1], grds[i][2], grds[i][3]);
        }

    }

    public static void printSungJuk(String[][] grds, String result) {
        System.out.print("---------------------------------\n");
        for (String[] i : grds) {
            int index = 0;
            for (String j : i) {
                switch (index) {
                    case 0:
                        result += "이름 : " + j + "\t";
                        break;
                    case 1:
                        result += "총점 : " + j + "\t";
                        break;
                    case 2:
                        result += "평균 : " + j + "\t";
                        break;
                    case 3:
                        result += "학점 : " + j;
                        break;
                    default:
                        break;
                }
                index++;
            }
            result += "\n";
        }
        System.out.println(result);
    }

}


