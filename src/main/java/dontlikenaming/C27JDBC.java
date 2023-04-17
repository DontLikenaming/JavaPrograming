package dontlikenaming;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class C27JDBC {
    public static void main(String[] args) {
        // newbooks 테이블에 도서정보 저장
        Scanner input = new Scanner(System.in);
        ReadBook1 readBook1 = new ReadBook1();

        System.out.print("도서명 입력 : ");
        String bkname = input.nextLine();

        System.out.print("저자 입력 : ");
        String author = input.nextLine();

        System.out.print("가격 입력 : ");
        int price = input.nextInt();

        readBook1.WriteBook(bkname, author, price);
    }
}

class ReadBook1 {
    private String insertBookSQL = " insert into newbooks (title, writer, price) values (?, ?, ?) ";

    public void WriteBook(String bkname, String author, int price){
        Connection conn = C32JDBCUtil.makeConn();
        PreparedStatement pstmt = null;

        try {
            // 실행할 SQL문 생성
            pstmt = conn.prepareStatement(insertBookSQL);

            // 실행할 SQL문의 placeholder에 값 전달
            pstmt.setString(1, bkname);
            pstmt.setString(2, author);
            pstmt.setInt(3, price);

            // SQL문 실행 후 결과 확인
            int cnt = pstmt.executeUpdate();    // DML 실행 시 사용
            System.out.println("데이터 입력 확인 : "+cnt);
        } catch (SQLException ex) {
            System.out.println("DB 접속 주소 또는 아이디/비밀번호, SQL문을 확인하시오!");
            System.out.println(ex.getMessage());
        } finally {
            C32JDBCUtil.closeConn(null, pstmt, conn);
        }
    }


}
