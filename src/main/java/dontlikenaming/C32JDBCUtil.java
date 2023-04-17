package dontlikenaming;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C32JDBCUtil {
    private static String url = "jdbc:mariadb://fullstacks.cfgsyxlxdqdq.ap-northeast-2.rds.amazonaws.com:3306/fullstacks";
    private static String DRV = "org.mariadb.jdbc.Driver";
    private static String userid = "admin";
    private static String pwd = "fullstack_2023";
    private static Connection conn = null;

    public static Connection makeConn(){
        try {
            Class.forName(DRV);
            conn = DriverManager.getConnection(url, userid, pwd);
        } catch (ClassNotFoundException ex) {
            System.out.println("MariaDB용 JDBC 드라이버가 없음!");
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("DB 접속 주소 또는 아이디/비밀번호, SQL문을 확인하세요!");
            System.out.println(ex.getMessage());
        }

        return conn;
    }

    public static void closeConn(
            ResultSet rs, PreparedStatement pstmt, Connection conn){
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
