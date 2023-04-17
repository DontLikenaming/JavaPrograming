package dontlikenaming;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C30JDBC {
    public static void main(String[] args) {
        ReadBook3 readBook3 = new ReadBook3();

        readBook3.deleteOne();
    }
}

class Book3 {
    private int bookno;
    private String title;
    private String writer;
    private int price;
    private String regdate;

    public Book3(int bookno, String title, String writer, int price, String regdate) {
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


class ReadBook3 {
    private String url = "jdbc:mariadb://fullstacks.cfgsyxlxdqdq.ap-northeast-2.rds.amazonaws.com:3306/fullstacks";
    private String DRV = "org.mariadb.jdbc.Driver";
    private String userid = "admin";
    private String pwd = "fullstack_2023";
    private String selectAllBookSQL = " select * from newbooks order by bookno desc ";
    private String selectOneBookSQL = " select * from newbooks where title like ?";
    private String deleteBookSQL = " delete from newbooks where bookno like ?";

    private ResultSet rs;

    void selectAll() {
        List<Book3> bookdata3 = new ArrayList<>();
        try {
            Class.forName(DRV);
        } catch (ClassNotFoundException ex) {
            System.out.println("MariaDB용 JDBC 드라이버가 없음!");
            System.out.println(ex.getMessage());
        }

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(url, userid, pwd);
            pstmt = conn.prepareStatement(selectAllBookSQL);

            rs = pstmt.executeQuery();
            while (rs.next()){
                Book3 book3 = new Book3(
                        rs.getInt("bookno"),
                        rs.getString("title"),
                        rs.getString("writer"),
                        rs.getInt("price"),
                        rs.getString("regdate"));

                bookdata3.add(book3);
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

        // 도서정보 출력
        for(Book3 b : bookdata3){
            System.out.println(b);
        }
    }

    void selectOne() {
        List<Book3> bookdata3 = new ArrayList<>();
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
            pstmt = conn.prepareStatement(selectOneBookSQL);
            pstmt.setString(1, "%"+findbook+"%");

            rs = pstmt.executeQuery();
            while (rs.next()){
                Book3 book3 = new Book3(
                        rs.getInt("bookno"),
                        rs.getString("title"),
                        rs.getString("writer"),
                        rs.getInt("price"),
                        rs.getString("regdate"));

                bookdata3.add(book3);
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


        for(Book3 b : bookdata3){
            System.out.println(b);
        }
    }

    void deleteOne() {
        String findbook = null;

        try {
            Class.forName(DRV);

            Scanner input = new Scanner(System.in);
            System.out.println("삭제할 도서번호를 입력하세요.");
            findbook = input.nextLine();

        } catch (ClassNotFoundException ex) {
            System.out.println("MariaDB용 JDBC 드라이버가 없음!");
            System.out.println(ex.getMessage());
        }

        Connection conn = null;
        PreparedStatement pstmt = null;



        try {
            conn = DriverManager.getConnection(url, userid, pwd);
            pstmt = conn.prepareStatement(deleteBookSQL);
            pstmt.setString(1, findbook);

            int cnt = pstmt.executeUpdate();
            System.out.println("데이터 삭제 확인 : "+cnt);


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
