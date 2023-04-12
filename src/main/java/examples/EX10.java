package examples;
import dontlikenaming.project.sungjuk.model.SungJukVO;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class EX10 {
    public static void main(String[] args) {
        // 클래스 기반 성적 처리 프로그램
        SungJukVO sj = new SungJukVO();
        readSungJuk(sj);
        computeSungJuk(sj);
        printSungJuk(sj);

    }

    public static void readSungJuk(SungJukVO sj) {
        Scanner input = new Scanner(System.in);
        System.out.println("학번");
        sj.setSjon(input.nextInt());
        System.out.println("이름");
        sj.setName(input.next());
        System.out.println("국어점수");
        sj.setKor(input.nextInt());
        System.out.println("영어점수");
        sj.setEng(input.nextInt());
        System.out.println("수학점수");
        sj.setMat(input.nextInt());

        LocalDate nowaday = LocalDate.now();
        LocalTime nowatime = LocalTime.now();
        DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formatedNow = nowaday.format(dayFormatter) + " ";
        formatedNow += nowatime.format(timeFormatter);
        sj.setRegdate(formatedNow);
    }

    public static void computeSungJuk(SungJukVO sj) {
        sj.setTot(sj.getKor()+sj.getEng()+sj.getMat());
        sj.setAvg((double) sj.getTot()/3);

        switch ((int) Math.ceil(sj.getAvg() - 1) / 10) {
            case 10:
            case 9:
                sj.setGrd('수');
                break;
            case 8:
                sj.setGrd('우');
                break;
            case 7:
                sj.setGrd('미');
                break;
            case 6:
                sj.setGrd('양');
                break;
            case 5:
            default:
                sj.setGrd('가');
                break;
        }
    }

    public static void printSungJuk(SungJukVO sj) {
        System.out.print("---------------------------------\n");
        System.out.print(sj);
    }
}

