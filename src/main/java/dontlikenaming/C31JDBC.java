package dontlikenaming;

import java.sql.*;
import java.util.Scanner;

public class C31JDBC {
    public static void main(String[] args) {
        ReadBook5 readBook5 = new ReadBook5();

        readBook5.update();
    }
}

class ReadBook5 {
    private String updateOneBookSQL = " update newbooks set title = ?, writer = ?, price = ? where bookno = ? ";

    void update() {
        int findbookno;
        String bookname;
        String author;
        int price;

        Scanner input = new Scanner(System.in);
        System.out.println("수정할 책번호를 입력하세요.");
        findbookno = input.nextInt();
        input.nextLine();
        System.out.println("책 제목을 입력하세요.");
        bookname = input.nextLine();
        System.out.println("저자를 입력하세요.");
        author = input.nextLine();
        System.out.println("가격을 입력하세요.");
        price = input.nextInt();


        Connection conn = C32JDBCUtil.makeConn();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(updateOneBookSQL);
            pstmt.setString(1, bookname);
            pstmt.setString(2, author);
            pstmt.setInt(3, price);
            pstmt.setInt(4, findbookno);


            int cnt = pstmt.executeUpdate();
            System.out.println("데이터 변경 확인 : "+cnt);


        } catch (SQLException ex) {
            System.out.println("DB 접속 주소 또는 아이디/비밀번호, SQL문을 확인하시오!");
            System.out.println(ex);
        } finally {
            C32JDBCUtil.closeConn(null, pstmt, conn);
        }
    }
}






