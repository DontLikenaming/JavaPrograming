package dontlikenaming.project.sungjuk;

import dontlikenaming.project.sungjuk.service.SungJukV1cService;
import dontlikenaming.project.sungjuk.service.SungJukV3ServiceImpl;

public class SungJukV3Main {
    // SungJukV3Main, SungJukV1cService,
    // SungJukV3ServiceImpl, SungJukVO, sungjukv3.dat
    public static void main(String[] args) {
        SungJukV1cService sjsrv = new SungJukV3ServiceImpl();
        while (true) {
            int selectMenu = sjsrv.displayMenu();
            sjsrv.processMenu(selectMenu);
        }
    }
}
