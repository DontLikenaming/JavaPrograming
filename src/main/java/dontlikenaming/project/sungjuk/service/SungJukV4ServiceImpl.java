package dontlikenaming.project.sungjuk.service;

import dontlikenaming.project.sungjuk.dao.SungJukV4DAO;
import dontlikenaming.project.sungjuk.dao.SungJukV4DAOImpl;
import dontlikenaming.project.sungjuk.model.SungJukVO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;


public class SungJukV4ServiceImpl implements SungJukV1cService {
    private Scanner input = null;
    private SungJukV4DAO sjdao = null;


    public SungJukV4ServiceImpl() {
        input = new Scanner(System.in);
        sjdao = new SungJukV4DAOImpl();
    }

    public int displayMenu() {
        StringBuffer sb = new StringBuffer();

        String greeting = "성적 처리 프로그램 v4";
        String[] menu = new String[8];
        menu[0] = "1. 성적 데이터 입력";
        menu[1] = "2. 성적 데이터 조회";
        menu[2] = "3. 성적 데이터 상세 조회";
        menu[3] = "4. 성적 데이터 수정";
        menu[4] = "5. 성적 데이터 삭제";
        menu[5] = "0. 종료";
        String line = "------------------------------------------";
        int selectMenu = 0;

        sb.append(line).append("\n")
                .append("\t\t").append(greeting).append("\n")
                .append(line).append("\n");
        for (int i = 0; i < 6; i++) {
            sb.append(menu[i]).append("\n");
        }
        sb.append(line).append("\n")
                .append("작업을 선택하세요. ").append("\n");
        System.out.print(sb);


            try {
                selectMenu = input.nextInt();
            } catch (InputMismatchException ex) {
                input.nextLine();   // 문자를 입력할 때 버퍼에 남은 찌꺼기 제거
                selectMenu = -1;
            }

        return selectMenu;
    }

    public void processMenu(int selectMenu) {
        switch (selectMenu) {
            case 0:
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
                break;

            case 1:
                newSungJuk();
                break;

            case 2:
                readSungJuk();
                break;

            case 3:
                readOneSungJuk();
                break;

            case 4:
                modifySungJuk();
                break;

            case 5:
                removeSungJuk();
                break;

            default:
                System.out.println("잘못 입력하셨습니다.");
        }
    }

    public void newSungJuk() {
        SungJukVO sjs = null;
        try {
            sjs = scanSungJuk();
            computeSungJuk(sjs);


        } catch (InputMismatchException ime) {
            System.out.println("\n잘못 입력하셨습니다.");
            return;
        }

        // 성적데이터를 데이터베이스에 저장
        int cnt = sjdao.insertSungJuk(sjs);
        if(cnt > 0) System.out.println("성적 데이터 저장 완료");

    }

    // 성적 데이터 입력받기
    private SungJukVO scanSungJuk() {
        String name = null;
        int kor = 0, eng = 0, mat = 0;

        System.out.println("성적 데이터 입력\n");
        try {
            System.out.print("이름을 입력하세요. ");
            name = input.next();
            System.out.print("국어점수를 입력하세요. ");
            kor = input.nextInt();
            System.out.print("영어점수를 입력하세요. ");
            eng = input.nextInt();
            System.out.print("수학점수를 입력하세요. ");
            mat = input.nextInt();
        } catch (InputMismatchException ex) {
            input.nextLine();
            // scanSungJuk 메서드를 호출한 상위 메서드로 예외를 전파함
            throw new InputMismatchException();
        }
        return new SungJukVO(name, kor, eng, mat);
    }

    public void computeSungJuk(SungJukVO sj) {
        sj.setTot( sj.getKor() + sj.getEng() + sj.getMat() );
        sj.setAvg( (double) sj.getTot() / 3 );

        switch ((int)(sj.getAvg()/10)) {
            case 10: case 9: sj.setGrd('수'); break;
            case 8: sj.setGrd('우'); break;
            case 7: sj.setGrd('미'); break;
            case 6: sj.setGrd('양'); break;
            default: sj.setGrd('가'); break;
        }

        LocalDate nowaday = LocalDate.now();
        LocalTime nowatime = LocalTime.now();
        DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formatedNow = nowaday.format(dayFormatter) + " ";
        formatedNow += nowatime.format(timeFormatter);
        sj.setRegdate(formatedNow);
    }

    public void readSungJuk() {
        String fmt = "\n학번 : %d 이름 : %s 국어 : %d 영어 : %d 수학 : %d\n";
        System.out.println("성적 데이터 조회\n");
        System.out.println("조회 결과");
        try {
            for (SungJukVO sjs : sjdao.selectSungJuk()) {
                System.out.printf(fmt, sjs.getSjno(), sjs.getName(),
                        sjs.getKor(), sjs.getEng(), sjs.getMat());
            }
            System.out.print("\n");

        } catch (NullPointerException ex) {
            System.out.println("\n데이터가 없습니다!\n");
        }
    }

    public void readOneSungJuk() {
        String fmt = "\n학번 : %d\n이름 : %s\n국어 : %d\n영어 : %d\n수학 : %d\n" +
                "총점 : %d\n평균 : %.1f\n학점 : %s\n입력 시간 : %s\n\n";
        System.out.println("성적 데이터 상세 조회");
        System.out.print("학번을 입력하세요. ");
        int sjon = input.nextInt();
        SungJukVO sj = sjdao.selectOneSungJuk(sjon);
            if(sj!=null){
                System.out.printf(fmt, sj.getSjno(), sj.getName(),
                        sj.getKor(), sj.getEng(), sj.getMat(),
                        sj.getTot(), sj.getAvg(), sj.getGrd(),
                        sj.getRegdate());
            } else {
                System.out.println("\n찾는 데이터가 없습니다!\n");
            }

    }

    public void modifySungJuk() {
        System.out.println("성적 데이터 수정\n");
        System.out.print("학번을 입력하세요. ");
        int sjon = input.nextInt();
        SungJukVO sj = sjdao.selectOneSungJuk(sjon);
        try {
            if (sj != null) {
                System.out.println("이름을 입력하세요. 기존 이름 : " + sj.getName());
                String name = input.next();
                System.out.println("국어점수를 입력하세요. 기존 점수 : " + sj.getKor());
                int kor = input.nextInt();
                System.out.println("영어점수를 입력하세요. 기존 점수 : " + sj.getEng());
                int eng = input.nextInt();
                System.out.println("수학점수를 입력하세요. 기존 점수 : " + sj.getMat());
                int mat = input.nextInt();
                System.out.print("\n");

                SungJukVO newOne = new SungJukVO(sjon, name, kor, eng, mat);
                computeSungJuk(newOne);

                if (sjdao.updateSungJuk(newOne) > 0) System.out.println("데이터 수정 완료!");

            } else {
                System.out.println("데이터가 없습니다!");
            }
        }
        catch (InputMismatchException ex){
            input.nextLine();
            System.out.println("잘못 입력하셨습니다. 다시 시도하세요.");
        }
    }

    public void removeSungJuk() {
        System.out.println("성적 데이터 삭제\n");
        System.out.print("학번을 입력하세요. ");
        int sjon = input.nextInt();
        int cnt = sjdao.deleteSungJuk(sjon);

        if(cnt!=0) System.out.println("삭제작업이 완료되었습니다.");
        else {System.out.println("해당 데이터가 없습니다.");}
    }
}
