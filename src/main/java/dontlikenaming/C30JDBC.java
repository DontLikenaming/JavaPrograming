package dontlikenaming;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class C30JDBC {
    public static void main(String[] args) {
        ReadBook4 readBook4 = new ReadBook4();

        readBook4.deleteOne();
    }
}

class ReadBook4 {
    private String deleteBookSQL = " delete from newbooks where bookno like ?";

    void deleteOne() {
        int findbookno = -1;

        Connection conn = C32JDBCUtil.makeConn();
        PreparedStatement pstmt = null;

        Scanner input = new Scanner(System.in);
        System.out.println("수정할 책번호를 입력하세요.");
        findbookno = input.nextInt();

        try {
            pstmt = conn.prepareStatement(deleteBookSQL);
            pstmt.setInt(1, findbookno);

            int cnt = pstmt.executeUpdate();
            System.out.println("데이터 삭제 확인 : "+cnt);


        } catch (SQLException ex) {
            System.out.println("DB 접속 주소 또는 아이디/비밀번호, SQL문을 확인하시오!");
            System.out.println(ex);
        } finally {
            C32JDBCUtil.closeConn(null, pstmt, conn);
        }

    }
}
