package dontlikenaming.project.bookmarket;

public class Books {
    static final int NUM_BOOK = 3;
    static final int NUM_ITEM = 7;
    static String[][] mBook = new String[NUM_BOOK][NUM_ITEM];

    public static void BookList() {
        mBook[0][0] = "ISB1234";
        mBook[0][1] = "쉽게 배우는 JSP 웹 프로그래밍";
        mBook[0][2] = "27000";
        mBook[0][3] = "송미영";
        mBook[0][4] = "단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍";
        mBook[0][5] = "IT 전문서";
        mBook[0][6] = "2018-10-08";

        mBook[1][0] = "ISB1235";
        mBook[1][1] = "안드로이드 프로그래밍";
        mBook[1][2] = "33000";
        mBook[1][3] = "우재남";
        mBook[1][4] = "실습 단계별 명퀘한 멘토링!";
        mBook[1][5] = "IT 전문서";
        mBook[1][6] = "2022-01-22";

        mBook[2][0] = "ISB1236";
        mBook[2][1] = "스크래치";
        mBook[2][2] = "22000";
        mBook[2][3] = "고광일";
        mBook[2][4] = "컴퓨팅 사고력을 키우는 블록 코딩";
        mBook[2][5] = "컴퓨터 입문";
        mBook[2][6] = "2019-06-10";
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("조회 결과\n");
                for(int i=0;i<3;i++) {
                    sb.append("ISBN : ").append(mBook[i][0]).append("\n")
                            .append("도서명 : ").append(mBook[i][1]).append("\n")
                            .append("정가 : ").append(mBook[i][2]).append("\n")
                            .append("저자 : ").append(mBook[i][3]).append("\n")
                            .append("도서 설명 : ").append(mBook[i][4]).append("\n")
                            .append("도서 분야 : ").append(mBook[i][5]).append("\n")
                            .append("도서 출간일 : ").append(mBook[i][6]).append("\n\n");
                }
        return String.format(sb.toString());
    }
}
