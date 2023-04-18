package dontlikenaming.project.sungjuk;

import dontlikenaming.project.sungjuk.service.SungJukV1cService;
import dontlikenaming.project.sungjuk.service.SungJukV4ServiceImpl;

public class SungJukV4Main {
    // 배열, 클래스, 인터페이스, 예외처리, 컬렉션, JDBC 이용
    // 성적을 입력하면 총점, 평균, 학점을 계산함
    // SungJukV4Main, SungJukV1cService,
    // SungJukV4ServiceImpl, SungJukVO
    // SungJukV4DAO, SungJukV4DAOImpl
    public static void main(String[] args) {
        SungJukV1cService sjsrv = new SungJukV4ServiceImpl();
        while (true) {
            int selectMenu = sjsrv.displayMenu();
            sjsrv.processMenu(selectMenu);
        }
    }
}
