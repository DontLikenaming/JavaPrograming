package dontlikenaming;

import java.sql.*;

public class C26JDBC {
    // JDBC(Java Database Connectivity)
    // 자바를 통해 다양한 관계형 데이터베이스에 접속하고
    // SQL문을 실행해서 관리하고자 할 때 사용하는 표준 SQL 인터페이스
    // 이 것을 통해 데이터베이스 코드를 한번만 작성해두면
    // 어떤 DBMS라도 코드 변경없이 동일하게 작동시킬 수 있음
    // JDK에 포함된 JDBC 인터페이스는 java.sql 패키지 아래에 있음

    // 하지만, 이 것 만으로는 작동하지 않고
    // JDBC 인터페이스에 맞게 각 데이터베이스 제조사가
    // 구현한 JDBC 클래스들이 필요한데,
    // 이것을 'JDBC 드라이버'라고 함
    // JDBC 드라이버들은 제조사 홈페이지에서
    // 내려받을 수 있음
    public static void main(String[] args) {
        // 1. JDBC 드라이버를 메모리에 적재
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("드라이버 로드 성공!");
        } catch (ClassNotFoundException ex) {
            System.out.println("MariaDB용 JDBC 드라이버가 없음!");
            System.out.println(ex);
        }

        // 2. 데이터베이스 서버에 접속하기
        Connection conn;
        String url;
        String userid;
        String pwd;

        try {
            System.out.println("데이터베이스 연결 준비...");

            // 네트워크 입출력 + 객체 생성
            conn = DriverManager.getConnection(url, userid, pwd);
            if(!conn.isClosed())System.out.println("MariaDB 접속 연결 성공");
        } catch (SQLException ex) {
            System.out.println("DB 접속 주소 또는 아이디/비밀번호를 확인하시오!");
            System.out.println(ex);
        } finally {
            if (conn != null) try {conn.close();} catch (Exception ex) {}
        }
    }
}






