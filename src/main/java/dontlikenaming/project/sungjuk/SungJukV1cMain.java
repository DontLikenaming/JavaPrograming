package dontlikenaming.project.sungjuk;

import dontlikenaming.project.sungjuk.service.SungJukV1cService;
import dontlikenaming.project.sungjuk.service.SungJukV1cServiceImpl;

public class SungJukV1cMain {
    // SungJukV1cMain, SungJukVO, SungJukV1cService, SungJukV1cServiceImpl
    // 예외 처리 추가
    public static void main(String[] args) {
        SungJukV1cService sjsrv = new SungJukV1cServiceImpl();
        while (true) {
            int selectMenu = sjsrv.displayMenu();
            sjsrv.processMenu(selectMenu);
        }
    }
}
