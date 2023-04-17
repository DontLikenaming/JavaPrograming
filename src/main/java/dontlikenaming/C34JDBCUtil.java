package dontlikenaming;

import java.sql.*;

public class C34JDBCUtil {
    private static String url = "jdbc:oracle:thin:@3.34.53.22:1521:XE";
    private static String DRV = "oracle.jdbc.driver.OracleDriver";
    private static String userid = "hr";
    private static String pwd = "hr";

    public static Connection makeConn(){
        Connection conn = null;
        try {
            Class.forName(DRV);
            conn = DriverManager.getConnection(url, userid, pwd);
        } catch (ClassNotFoundException ex) {
            System.out.println("oracleDB용 JDBC 드라이버가 없음!");
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
