package dontlikenaming.project.sungjuk;

import dontlikenaming.project.sungjuk.service.SungJukV1cService;
import dontlikenaming.project.sungjuk.service.SungJukV2ServiceImpl;

public class SungJukV2Main {
    // SungJukV2Main, SungJukV1cService, SungJukV2ServiceImpl, SungJukVO
    public static void main(String[] args) {
        SungJukV1cService sjsrv = new SungJukV2ServiceImpl();
        while (true) {
            int selectMenu = sjsrv.displayMenu();
            sjsrv.processMenu(selectMenu);
        }
    }
}
