package dontlikenaming.project.sungjuk.service;

import dontlikenaming.project.sungjuk.model.SungJukVO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class SungJukV2ServiceImpl implements SungJukV1cService {
    private Scanner input = null;
    private List<SungJukVO> sj = null;
    // private int idx = 0;
    private int sjnum = 0;

    public SungJukV2ServiceImpl() {
        input = new Scanner(System.in);
        sj = new ArrayList<>();
    }

    public int displayMenu() {
        StringBuffer sb = new StringBuffer();

        String greeting = "성적 처리 프로그램 v2";
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
                System.out.println("잘못 입력하셨습니다. 다시 시도하세요.");
                return;
            }

            SungJukVO sjs = new SungJukVO(sjnum, name, kor, eng, mat);
            computeSungJuk(sjs);

            sj.add(sjs);
            sjnum++;

            System.out.print("\n");

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
        System.out.println("성적 데이터 조회\n");
        final StringBuffer sb = new StringBuffer();
        System.out.println("조회 결과");
        try {
            for (SungJukVO sjs : sj) {
                sb.append("학번 : " + sjs.getSjon() + "\n")
                        .append("이름 : " + sjs.getName() + "\n")
                        .append("국어점수 : " + sjs.getKor() + "\n")
                        .append("영어점수 : " + sjs.getEng() + "\n")
                        .append("수학점수 : " + sjs.getMat() + "\n\n");
            }
        } catch (NullPointerException ex){}

        if(sb.length()==0){
            System.out.println("\n데이터가 없습니다!\n");
        } else {System.out.print(sb);}
    }

    public void readOneSungJuk() {
        System.out.println("성적 데이터 상세 조회");
        System.out.print("학번을 입력하세요. ");
        String sjon = input.next();
        SungJukVO one = null;
        try {
            for (SungJukVO sjs : sj) {
                if (String.valueOf(sjs.getSjon()).equals(sjon)) {
                    one = sjs;
                    break;
                }
            }
        } catch (NullPointerException ex){
            return;
        }

        if(one!=null){
            System.out.printf("\n%s\n", one);
        } else {
            System.out.println("\n찾는 데이터가 없습니다!\n");
        }
    }

    public void modifySungJuk() {
        System.out.println("성적 데이터 수정\n");
        System.out.print("학번을 입력하세요. ");
        int sjon = input.nextInt();

        try {
            for(int i=0;i<sj.size();i++){
                if (sj.get(i).getSjon()==sjon) {
                    System.out.println("이름을 입력하세요. 기존 이름 : " + sj.get(i).getName());
                    String name = input.next();
                    System.out.println("국어점수를 입력하세요. 기존 점수 : " + sj.get(i).getKor());
                    int kor = input.nextInt();
                    System.out.println("영어점수를 입력하세요. 기존 점수 : " + sj.get(i).getEng());
                    int eng = input.nextInt();
                    System.out.println("수학점수를 입력하세요. 기존 점수 : " + sj.get(i).getMat());
                    int mat = input.nextInt();
                    System.out.print("\n");

                    SungJukVO newOne = new SungJukVO(sjon, name, kor, eng, mat);
                    computeSungJuk(newOne);
                    sj.set(i, newOne);

                    System.out.println("\n수정 작업이 완료되었습니다.\n");
                    break;
                }
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

        for(int i=0;i<sj.size();i++){
            if(sj.get(i).getSjon()==sjon){
                sj.remove(sj.get(i));
            }
        }

        System.out.println("삭제작업이 완료되었습니다.");
    }
}
