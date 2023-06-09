package dontlikenaming.project.sungjuk.service;

import dontlikenaming.project.sungjuk.model.SungJukVO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class SungJukV1bServiceImpl implements SungJukV1bService {
    private Scanner input = null;
    private SungJukVO[] sj = null;
    private int idx = 0;

    public SungJukV1bServiceImpl() {
        input = new Scanner(System.in);
        sj = new SungJukVO[10];
    }

    public String displayMenu() {
        StringBuilder sb = new StringBuilder();

        String greeting = "성적 처리 프로그램 v1b";
        String[] menu = new String[8];
        menu[0] = "1. 성적 데이터 입력";
        menu[1] = "2. 성적 데이터 조회";
        menu[2] = "3. 성적 데이터 상세 조회";
        menu[3] = "4. 성적 데이터 수정";
        menu[4] = "5. 성적 데이터 삭제";
        menu[5] = "0. 종료";
        String line = "------------------------------------------";
        String selectMenu = null;

        sb.append(line).append("\n")
                .append("\t\t").append(greeting).append("\n")
                .append(line).append("\n");
        for (int i = 0; i < 6; i++) {
            sb.append(menu[i]).append("\n");
        }
        sb.append(line).append("\n").append("작업을 선택하세요. ").append("\n");
        System.out.print(sb);
        selectMenu = input.next();

        return selectMenu;
    }

    public void processMenu(String selectMenu) {
        int num = 0;
        switch (selectMenu) {
            case "0":
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
                break;

            case "1":
                newSungJuk();
                break;

            case "2":
                readSungJuk();
                break;

            case "3":
                readOneSungJuk();
                break;

            case "4":
                modifySungJuk();
                break;

            case "5":
                removeSungJuk();
                break;

            default:
                System.out.println("잘못 입력하셨습니다.");
        }
    }

    public void newSungJuk() {
        if(sj[9] != null){
            System.out.println("더 이상 입력할 수 없습니다!\n");
        } else {
            System.out.println("성적 데이터 입력\n");
            sj[idx] = new SungJukVO();
            System.out.print("이름을 입력하세요. ");
            String name = input.next();
            System.out.print("국어점수를 입력하세요. ");
            int kor = input.nextInt();
            System.out.print("영어점수를 입력하세요. ");
            int eng = input.nextInt();
            System.out.print("수학점수를 입력하세요. ");
            int mat = input.nextInt();
            System.out.print("\n");

            SungJukVO sjs = new SungJukVO(idx, name, kor, eng, mat);
            computeSungJuk(sjs);
            sj[idx++] = sjs;
        }
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
        final StringBuilder sb = new StringBuilder();
        System.out.println("조회 결과");
        for (SungJukVO sjs : sj) {
            if(sjs!=null) {
                sb.append("학번 : ").append(sjs.getSjno()).append("\n")
                        .append("이름 : ").append(sjs.getName()).append("\n")
                        .append("국어점수 : ").append(sjs.getKor()).append("\n")
                        .append("영어점수 : ").append(sjs.getEng()).append("\n")
                        .append("수학점수 : ").append(sjs.getMat()).append("\n\n");

                System.out.println(sb);
            }
        }

        if(sb.length()==0){
            System.out.println("\n데이터가 없습니다!\n");;
        }
    }

    public void readOneSungJuk() {
        System.out.println("성적 데이터 상세 조회");
        System.out.print("학번을 입력하세요. ");
        String sjon = input.next();
        SungJukVO one = null;
        for (SungJukVO sjs : sj) {
            if(sjs != null && String.valueOf(sjs.getSjno()).equals(sjon)){
                one = sjs; break;
            }
        }

        if(one!=null){
            System.out.printf("\n%s\n", one);
        } else {
            System.out.println("\n찾는 데이터가 없습니다!\n");
        }

/*      System.out.println("성적 데이터 상세 조회");
        System.out.print("학번을 입력하세요. ");
        int num = input.nextInt();
        final StringBuilder sb = new StringBuilder();
        sb.append("조회 결과\n")
                .append("학번 : ").append(sj[num].getSjon()).append("\n")
                .append("이름 : ").append(sj[num].getName()).append("\n")
                .append("국어 점수 : ").append(sj[num].getKor()).append("\n")
                .append("영어 점수 : ").append(sj[num].getEng()).append("\n")
                .append("수학 점수 : ").append(sj[num].getMat()).append("\n")
                .append("총합 : ").append(sj[num].getTot()).append("\n")
                .append("평균 : ").append(Math.floor(sj[num].getAvg()*10)/10).append("\n")
                .append("학점 : ").append(sj[num].getGrd()).append("\n")
                .append("입력시간 : ").append(sj[num].getRegdate()).append("\n\n");

        System.out.println(String.format(sb.toString()));*/
    }

    public void modifySungJuk() {
        System.out.println("성적 데이터 수정\n");
        System.out.print("학번을 입력하세요. ");
        String sjon = input.next();
        int check = 0;

        for (int i=0;i<sj.length;i++ ) {
            if(sj[i] != null && String.valueOf(sj[i].getSjno()).equals(sjon)){
                System.out.println("이름을 입력하세요. 기존 이름 : "+sj[i].getName());
                String name = input.next();
                System.out.println("국어점수를 입력하세요. 기존 점수 : "+sj[i].getKor());
                int kor = input.nextInt();
                System.out.println("영어점수를 입력하세요. 기존 점수 : "+sj[i].getEng());
                int eng = input.nextInt();
                System.out.println("수학점수를 입력하세요. 기존 점수 : "+sj[i].getMat());
                int mat = input.nextInt();
                System.out.print("\n");

                SungJukVO sjs = new SungJukVO(i, name, kor, eng, mat);
                computeSungJuk(sjs);
                sj[i] = null;
                sj[i] = sjs;
                check++;

                System.out.println("\n수정 작업이 완료되었습니다.\n");
                break;
            }
        }

        if(check==0)System.out.println("\n찾는 데이터가 없습니다!\n");
/*        System.out.println("성적 데이터 수정\n");
        System.out.print("학번을 입력하세요. ");
        int num = input.nextInt();

        System.out.println("이름을 입력하세요. 기존 이름 : "+sj[num].getName());
        sj[num].setName(input.next());
        System.out.println("국어점수를 입력하세요. 기존 점수 : "+sj[num].getKor());
        sj[num].setKor(input.nextInt());
        System.out.println("영어점수를 입력하세요. 기존 점수 : "+sj[num].getEng());
        sj[num].setEng(input.nextInt());
        System.out.println("수학점수를 입력하세요. 기존 점수 : "+sj[num].getMat());
        sj[num].setMat(input.nextInt());

        computeSungJuk(sj[num]);*/
    }

    public void removeSungJuk() {
        System.out.print("학번을 입력하세요. ");
        String sjon = input.next();
        int check = 0;

        for (int i=0;i<sj.length;i++ ) {
            if(sj[i] != null && String.valueOf(sj[i].getSjno()).equals(sjon)){
                sj[i] = null;
                System.out.println("\n삭제 작업이 완료되었습니다.\n");
                check++;
                break;
            }
        }
        if(check==0)System.out.println("\n찾는 데이터가 없습니다!\n");
/*        System.out.println("성적 데이터 삭제\n");
        System.out.print("학번을 입력하세요. ");
        int num = input.nextInt();

        SungJukVO[] destArray = new SungJukVO[sj.length];

        System.arraycopy(sj, 0, destArray, 0, num);
        System.arraycopy(sj, num+1, destArray, num, sj.length-num-1);

        sj = destArray;

        System.out.println("삭제작업이 완료되었습니다.");*/
    }
}
