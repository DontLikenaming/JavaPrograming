package dontlikenaming;

public class SungJukV1Main {
    // 성적 처리 프로그램 v1
    // 배열과 클래스를 이용해서
    // 성적을 입력하면 총점, 평균, 학점을 계산함
    // 최대 10명까지 입력 가능해야 함
    // SungJukV1Main, SungJukVO, SungJukV1Service
    //
    // 1. 성적 데이터 입력         (이름, 국어, 영어, 수학)
    // 2. 성적 데이터 조회         (이름, 국어, 영어, 수학)
    // 3. 성적 데이터 상세 조회    (전부 출력)
    // 4. 성적 데이터 수정
    // 5. 성적 데이터 삭제
    // 0. 프로그램 종료
    public static void main(String[] args) {
        SungJukV1Service sjsrv = new SungJukV1Service();
        while (true) {
            String selectMenu = sjsrv.displayMenu();
            sjsrv.processMenu(selectMenu);
        }
    }
}
