package dontlikenaming;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C29JDBC {
    public static void main(String[] args) {
        ReadBook2 readBook2 = new ReadBook2();

        readBook2.selectOne();
    }
}

class Book2 {
    private int bookno;
    private String title;
    private String writer;
    private int price;
    private String regdate;

    public Book2(int bookno, String title, String writer, int price, String regdate) {
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


class ReadBook2 {
    private String url = "jdbc:mariadb://fullstacks.cfgsyxlxdqdq.ap-northeast-2.rds.amazonaws.com:3306/fullstacks";
    private String DRV = "org.mariadb.jdbc.Driver";
    private String userid = "admin";
    private String pwd = "fullstack_2023";
    private String selectBookSQL = " select * from newbooks where title like ?";

    private ResultSet rs;

    void selectOne() {
        List<Book2> bookdata2 = new ArrayList<>();
        String findbook = null;

        try {
            Class.forName(DRV);

            Scanner input = new Scanner(System.in);
            System.out.println("제목을 입력하세요.");
            findbook = input.nextLine();

        } catch (ClassNotFoundException ex) {
            System.out.println("MariaDB용 JDBC 드라이버가 없음!");
            System.out.println(ex.getMessage());
        }

        Connection conn = null;
        PreparedStatement pstmt = null;



        try {
            conn = DriverManager.getConnection(url, userid, pwd);
            pstmt = conn.prepareStatement(selectBookSQL);
            pstmt.setString(1, "%"+findbook+"%");

            rs = pstmt.executeQuery();
            while (rs.next()){
                Book2 book2 = new Book2(
                        rs.getInt("bookno"),
                        rs.getString("title"),
                        rs.getString("writer"),
                        rs.getInt("price"),
                        rs.getString("regdate"));

                bookdata2.add(book2);
            }

        } catch (SQLException ex) {
            System.out.println("DB 접속 주소 또는 아이디/비밀번호, SQL문을 확인하시오!");
            System.out.println(ex);
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (Exception ex) {}

            if (pstmt != null) try {
                pstmt.close();
            } catch (Exception ex) {}

            if (conn != null) try {
                conn.close();
            } catch (Exception ex) {}
        }


        for(Book2 b : bookdata2){
            System.out.println(b);
        }
    }
}
