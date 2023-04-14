package dontlikenaming;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class C28JDBC {
    public static void main(String[] args) {
        // newbooks 테이블의 모든 레코드 조회
        Book book = new Book();

        book.selectAll();
    }
}

class Book {
    private int bookno;
    private String title;
    private String writer;
    private int price;
    private String regdate;

    public Book() {
    }

    public Book(int bookno, String title, String writer, int price, String regdate) {
        this.bookno = bookno;
        this.title = title;
        this.writer = writer;
        this.price = price;
        this.regdate = regdate;
    }

    private String url = "jdbc:mariadb://fullstacks.cfgsyxlxdqdq.ap-northeast-2.rds.amazonaws.com:3306/fullstacks";
    private String DRV = "org.mariadb.jdbc.Driver";
    private String userid = "admin";
    private String pwd = "fullstack_2023";
    private String selectBookSQL = " select * from newbooks order by bookno desc ";
    private ResultSet rs;

    void selectAll() {
        try {
            Class.forName(DRV);
        } catch (ClassNotFoundException ex) {
            System.out.println("MariaDB용 JDBC 드라이버가 없음!");
            System.out.println(ex);
        }

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            String fmt = "\n번호 : %d 책 제목 : %s 글쓴이 : %s 가격 : %d원 입고일자 : %s";
            conn = DriverManager.getConnection(url, userid, pwd);
            pstmt = conn.prepareStatement(selectBookSQL);

            rs = pstmt.executeQuery();
            while (rs.next()){
                System.out.printf(fmt,
                        rs.getInt("bookno"),
                        rs.getString("title"),
                        rs.getString("writer"),
                        rs.getInt("price"),
                        rs.getTimestamp("regdate"));
            }

        } catch (SQLException ex) {
            System.out.println("DB 접속 주소 또는 아이디/비밀번호를 확인하시오!");
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
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(bookno)
        .append(title)
        .append(writer)
        .append(price)
        .append(regdate);

        return sb.toString();
    }
}
