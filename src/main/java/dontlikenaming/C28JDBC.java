package dontlikenaming;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class C28JDBC {
    public static void main(String[] args) {
        // newbooks 테이블의 모든 레코드 조회
        ReadBook2 readBook2 = new ReadBook2();

        readBook2.selectAll();
    }
}

class Book {
    private int bookno;
    private String title;
    private String writer;
    private int price;
    private String regdate;

    public Book(int bookno, String title, String writer, int price, String regdate) {
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
    List<Book> bookdata = new ArrayList<>();

    private String selectBookSQL = " select * from newbooks order by bookno desc ";
    private ResultSet rs;

    void selectAll() {
        Connection conn = C32JDBCUtil.makeConn();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(selectBookSQL);

            rs = pstmt.executeQuery();
            while (rs.next()){
                Book book = new Book(
                        rs.getInt("bookno"),
                        rs.getString("title"),
                        rs.getString("writer"),
                        rs.getInt("price"),
                        rs.getString("regdate"));

                bookdata.add(book);
            }

        } catch (SQLException ex) {
            System.out.println("DB 접속 주소 또는 아이디/비밀번호, SQL문을 확인하시오!");
            System.out.println(ex);
        } finally {
            // static으로 선언된 메서드는
            // 객체 생성 없이 바로 호출 가능
            // 단, 클래스 이름.메서드 이름으로 호출해야 함
            C32JDBCUtil.closeConn(rs, pstmt, conn);
        }

        // 도서정보 출력
        for(Book b : bookdata){
            System.out.println(b);
        }
    }
}
