package dontlikenaming;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C27JDBC {
    public static void main(String[] args) {
        // newbooks 테이블에 도서정보 저장
        Scanner input = new Scanner(System.in);
        DBExample2 example2 = new DBExample2();

        System.out.print("도서명 입력 : ");
        String bkname = input.nextLine();

        System.out.print("저자 입력 : ");
        String author = input.nextLine();

        System.out.print("가격 입력 : ");
        int price = input.nextInt();

        example2.input(bkname, author, price);
    }
}

class DBExample2 {
    private String url = "jdbc:mariadb://fullstacks.cfgsyxlxdqdq.ap-northeast-2.rds.amazonaws.com:3306/fullstacks";
    private String DRV = "org.mariadb.jdbc.Driver";
    private String userid = "admin";
    private String pwd = "fullstack_2023";
    private String insertBookSQL = " insert into newbooks (title, writer, price) values (?, ?, ?) ";

    private void AccessDB() {
        try {
            Class.forName(DRV);
        } catch (ClassNotFoundException ex) {
            System.out.println("MariaDB용 JDBC 드라이버가 없음!");
            System.out.println(ex.getMessage());
        }
    }

    public void input(String bkname, String author, int price){
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 데이터베이스 접속
            conn = DriverManager.getConnection(url, userid, pwd);

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
            if (pstmt != null) try {
                pstmt.close();
            } catch (Exception ex) {}

            if (conn != null) try {
                conn.close();
            } catch (Exception ex) {}
        }
    }


}
