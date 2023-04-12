package dontlikenaming.project.bookmarket;

import dontlikenaming.project.Membership;

import java.util.Scanner;

public class BookMarketService {
    private Scanner input = null;
    private Membership m = null;
    private Books b = null;

    public BookMarketService() {
        input = new Scanner(System.in);
        registerBooks();
    }

    public String displayMenu() {
        // BookMarket 메뉴 작성
        StringBuilder sb = new StringBuilder();

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
        String selectMenu = null;

        sb.append(line).append("\n")
                .append("\t\t").append(greeting).append("\n")
                .append("\t\t").append(tagline).append("\n")
                .append(line).append("\n");
        for (int i = 0; i < 8; i++) {
            sb.append(menu[i]).append("\n");
        }
        sb.append(line).append("\n").append("작업을 선택하세요. ").append("\n");
        System.out.print(sb);
        selectMenu = input.next();

        return selectMenu;
    }

    // 메뉴 분기 처리
    public void processMenu(String selectMenu) {
        switch (selectMenu) {
            case "0":
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);          //프로그램 정상 종료
                break;

            case "1":
                System.out.println("고객정보 확인\n");
                System.out.println(m);
                break;

            case "2":
                System.out.println("상품목록 보기\n");

                break;

            case "3":
                System.out.println("장바구니 비우기\n");
                break;

            case "4":
                System.out.println("장바구니 상품 추가\n");
                System.out.println(b);
                break;

            case "5":
                System.out.println("주문 수량 변경\n");
                break;

            case "6":
                System.out.println("장바구니 상품 삭제\n");
                break;

            case "7":
                System.out.println("영수증 표시\n");
                break;

            default:
                System.out.println("잘못 입력하셨습니다.");
        }
    }

    // 회원 등록
    public void registerMember() {
        System.out.print("이름을 입력하세요. ");
        String name = input.next();
        System.out.print("이메일을 입력하세요. ");
        String email = input.next();
        System.out.print("전화번호를 입력하세요. (-빼고 입력) ");
        String hp = input.next();

        m = new Membership(001, name, email, hp);
    }

    // 도서 정보 자동 등록
    public void registerBooks() {
        b = new Books();
        b.BookList();
    }
}
