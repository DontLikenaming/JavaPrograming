package dontlikenaming;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class C29JDBC {
    public static void main(String[] args) {
        ReadBook3 readBook3 = new ReadBook3();

        readBook3.selectOne();
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


class ReadBook3 {
    private String selectBookSQL = " select * from newbooks where title like ?";

    private ResultSet rs;

    void selectOne() {
        List<Book2> bookdata2 = new ArrayList<>();
        String findbook = null;

        Connection conn = C32JDBCUtil.makeConn();
        PreparedStatement pstmt = null;

        try {
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
            C32JDBCUtil.closeConn(rs, pstmt, conn);
        }

        for(Book2 b : bookdata2){
            System.out.println(b);
        }
    }
}
