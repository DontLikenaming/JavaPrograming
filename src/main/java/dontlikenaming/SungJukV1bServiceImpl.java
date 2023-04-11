package dontlikenaming;

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
        // BookMarket 메뉴 작성
        StringBuilder sb = new StringBuilder();

        String greeting = "성적 처리 프로그램 v1";
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
                System.exit(0);          //프로그램 정상 종료
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
        System.out.println("성적 데이터 입력\n");
        sj[idx] = new SungJukVO();
        sj[idx].setSjon(idx);
        System.out.print("이름을 입력하세요. ");
        sj[idx].setName(input.next());
        System.out.print("국어점수를 입력하세요. ");
        sj[idx].setKor(input.nextInt());
        System.out.print("영어점수를 입력하세요. ");
        sj[idx].setEng(input.nextInt());
        System.out.print("수학점수를 입력하세요. ");
        sj[idx].setMat(input.nextInt());
        System.out.print("\n");
        computeSungJuk(sj[idx]);
        idx++;
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
        sb.append("조회 결과\n");
        for (SungJukVO sjs : sj) {
            if(sjs!=null) {
                sb.append("학번 : ").append(sjs.getSjon()).append("\n")
                        .append("이름 : ").append(sjs.getName()).append("\n")
                        .append("국어점수 : ").append(sjs.getKor()).append("\n")
                        .append("영어점수 : ").append(sjs.getEng()).append("\n")
                        .append("수학점수 : ").append(sjs.getMat()).append("\n\n");

                System.out.println(sb);
            }
        }
    }

    public void readOneSungJuk() {
        System.out.println("성적 데이터 상세 조회");
        System.out.print("이름을 입력하세요. ");
        String name = input.next();
        SungJukVO one = null;
        for (SungJukVO sjs : sj) {
            if(sjs != null && sjs.getName().equals(name)){
                one = sjs; break;
            }
        }

        if(one!=null){
            System.out.println(one);
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
        int num = input.nextInt();

        System.out.println("이름을 입력하세요. 기존 이름 : "+sj[num].getName());
        sj[num].setName(input.next());
        System.out.println("국어점수를 입력하세요. 기존 점수 : "+sj[num].getKor());
        sj[num].setKor(input.nextInt());
        System.out.println("영어점수를 입력하세요. 기존 점수 : "+sj[num].getEng());
        sj[num].setEng(input.nextInt());
        System.out.println("수학점수를 입력하세요. 기존 점수 : "+sj[num].getMat());
        sj[num].setMat(input.nextInt());

        computeSungJuk(sj[num]);
    }

    public void removeSungJuk() {
        System.out.println("성적 데이터 삭제\n");
        System.out.print("학번을 입력하세요. ");
        int num = input.nextInt();

        SungJukVO[] destArray = new SungJukVO[sj.length-1];

        System.arraycopy(sj, 0, destArray, 0, num);
        System.arraycopy(sj, num+1, destArray, num, sj.length-num-1);

        sj = destArray;

        System.out.println("작업 완료되었습니다.");
    }
}
