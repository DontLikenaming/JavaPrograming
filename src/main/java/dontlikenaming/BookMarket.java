package dontlikenaming;

public class BookMarket {
    // 실행 흐름
    // BookMarket -> BookService, MemberService <- Book, Member
    public static void main(String[] args) {
        BookMarketService bksrv = new BookMarketService();
        while (true) {
            String selectMenu = bksrv.displayMenu();
            bksrv.processMenu(selectMenu);
        }
    }
}
