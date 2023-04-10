package dontlikenaming;
import java.util.Scanner;

public class BookMarket {
    // 실행 흐름
    // BookMarket -> BookService, MemberService <- Book, Member
    public static void main(String[] args) {
        // bookmarket 메뉴 작성
        Scanner input = new Scanner(System.in);
        String greeting = "Welcome to Shopping Mall";
        String tagline = "Welcome to Book Market";
        String[] menu = new String[8];
        menu[0] = "1. 고객 정보 확인하기";
        menu[1] = "2. 장바구니 상품목록 보기";
        menu[2] = "3. 장바구니 비우기";
        menu[3] = "4. 장바구니 상품 추가";
        menu[4] = "5. 장바구니 주문수량 변경";
        menu[5] = "6. 장바구니 상품 삭제";
        menu[6] = "7. 상품 주문 영수증 표시";
        menu[7] = "0. 종료";
        String line = "------------------------------------------";

        while (true) {
            System.out.println(line);
            System.out.println("\t\t" + greeting);
            System.out.println("\t\t " + tagline);
            System.out.println(line);
            for (int i = 0; i < 8; i++) {
                System.out.println(menu[i]);
            }
            System.out.println(line);
            System.out.print("작업을 선택하세요. ");
            int selectMenu = input.nextInt();
            switch (selectMenu){
                case 0 : System.out.println("프로그램을 종료합니다.");
                          System.exit(0);          //프로그램 정상 종료
                          break;
                case 1 : System.out.println(menu[0].substring(3, 11)); break;
                case 2 : System.out.println(menu[1].substring(8)); break;
                case 3 : System.out.println(menu[2].substring(8)); break;
                case 4 : System.out.println(menu[3].substring(8)); break;
                case 5 : System.out.println(menu[4].substring(8)); break;
                case 6 : System.out.println(menu[5].substring(8)); break;
                case 7 : System.out.println(menu[6].substring(9)); break;
                default : System.out.println("잘못 입력하셨습니다.");
            }
        }
    }
}
