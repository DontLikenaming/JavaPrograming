package dontlikenaming.project.bookmarket;

public class BookMarket {
    // 실행 흐름
    // BookMarket -> BookService, MemberService <- Book, Member
    public static void main(String[] args) {
        BookMarketService bksrv = new BookMarketService();
        bksrv.registerMember();
        while (true) {
            String selectMenu = bksrv.displayMenu();
            bksrv.processMenu(selectMenu);
        }
    }
}
