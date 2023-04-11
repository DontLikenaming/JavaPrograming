package dontlikenaming;

public class SungJukV1bMain {
    // SungJukV1bMain, SungJukVO, SungJukV1bService, SungJukV1bServiceImpl
    public static void main(String[] args) {
        SungJukV1bService sjsrv = new SungJukV1bServiceImpl();
        while (true) {
            String selectMenu = sjsrv.displayMenu();
            sjsrv.processMenu(selectMenu);
        }
    }
}
