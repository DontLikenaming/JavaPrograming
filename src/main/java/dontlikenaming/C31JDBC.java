package dontlikenaming;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C31JDBC {
    public static void main(String[] args) {
        ReadBook4 readBook4 = new ReadBook4();

        readBook4.update();
    }
}

class Book4 {
    private int bookno;
    private String title;
    private String writer;
    private int price;
    private String regdate;

    public Book4(int bookno, String title, String writer, int price, String regdate) {
        this.bookno = bookno;
        this.title = title;
        this.writer = writer;
        this.price = price;
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        String fmt = "번호 : %d 책 제목 : %s 글쓴이 : %s 가격 : %d원 입고일자 : %s";

        return String.format(fmt, bookno, title, writer, price, regdate.substring(0,19));
    }
}


class ReadBook4 {
    private String url = "jdbc:mariadb://fullstacks.cfgsyxlxdqdq.ap-northeast-2.rds.amazonaws.com:3306/fullstacks";
    private String DRV = "org.mariadb.jdbc.Driver";
    private String userid = "admin";
    private String pwd = "fullstack_2023";
    private String updateOneBookSQL = " update newbooks set title = ?, writer = ?, price = ? where bookno = ? ";

    void update() {
        int findbookno = 0;
        String bookname = null;
        String author = null;
        int price = 0;

        try {
            Class.forName(DRV);

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

        } catch (ClassNotFoundException ex) {
            System.out.println("MariaDB용 JDBC 드라이버가 없음!");
            System.out.println(ex.getMessage());
        }

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(url, userid, pwd);
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
            if (pstmt != null) try {
                pstmt.close();
            } catch (Exception ex) {}

            if (conn != null) try {
                conn.close();
            } catch (Exception ex) {}
        }
    }
}






