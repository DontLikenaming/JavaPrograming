package dontlikenaming;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C33JDBC {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /*System.out.println("사원 등록을 진행합니다.");

        System.out.print("사원번호 입력 : ");
        int empno = input.nextInt();

        System.out.print("이름 입력 : ");
        String fname = input.next();

        System.out.print("성 입력 : ");
        String lname = input.next();

        System.out.print("이메일 입력 : ");
        String email = input.next();

        System.out.print("전화번호 입력 : ");
        String phone = input.next();

        System.out.print("입사일 입력 : ");
        String hdate = input.next();

        System.out.print("직책 입력 : ");
        String jobid = input.next();

        System.out.print("급여 입력 : ");
        int sal = input.nextInt();

        System.out.print("수당 입력 : ");
        double comm = input.nextDouble();

        System.out.print("상사번호 입력 : ");
        int mgrid = input.nextInt();

        System.out.print("부서번호 입력 : ");
        int deptno = input.nextInt();

        EMPVO emp = new EMPVO(empno, fname, lname, email, phone,
                hdate, jobid, sal, comm, mgrid, deptno);


        if(EMPDAOImpl.insertEmp(emp)>0){
            System.out.println("입력 성공!");
        } else {
            System.out.println("입력 실패");
        }*/

/*        List<EMPVO> empdata =  EMPDAOImpl.selectEmp();

        String fmt = "%d %s %s %s %s %s %s %d %.2f %d %d\n";
        for(EMPVO emp : empdata) {
            System.out.printf(fmt, emp.getEmpno(), emp.getFname(),
                    emp.getLname(), emp.getEmail(), emp.getPhone(),
                    emp.getHdate(), emp.getJobid(), emp.getSal(),
                    emp.getComm(), emp.getMgrid(), emp.getDeptno());
        }*/

        System.out.print("조회할 사원 번호 입력 : ");
        int empno = input.nextInt();

        EMPVO emp = EMPDAOImpl.selectOneEmp(empno);
        if(emp!=null) System.out.println(emp);
        else {System.out.println("해당 데이터가 존재하지 않습니다.");}

        System.out.print("삭제할 사원 번호 입력 : ");
        empno = input.nextInt();

        int delCheck = EMPDAOImpl.deleteEmp(empno);
        if(delCheck!=0) System.out.println("사원 정보 삭제 성공!!");
        else {System.out.println("해당 데이터가 존재하지 않습니다.");}

    }
}

class EMPVO {
    private int empno;
    private String fname;
    private String lname;
    private String email;
    private String phone;
    private String hdate;
    private String jobid;
    private int sal;
    private double comm;
    private int mgrid;
    private int deptno;

    public EMPVO(){}

    public EMPVO(
            int empno, String fname, String lname,
            String email, String phone, String hdate,
            String jobid, int sal, double comm, int mgrid, int deptno) {
        this.empno = empno;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
        this.hdate = hdate;
        this.jobid = jobid;
        this.sal = sal;
        this.comm = comm;
        this.mgrid = mgrid;
        this.deptno = deptno;
    }

    public int getEmpno() {
        return empno;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getHdate() {
        return hdate;
    }

    public String getJobid() {
        return jobid;
    }

    public int getSal() {
        return sal;
    }

    public double getComm() {
        return comm;
    }

    public int getMgrid() {
        return mgrid;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setHdate(String hdate) {
        this.hdate = hdate;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public void setComm(double comm) {
        this.comm = comm;
    }

    public void setMgrid(int mgrid) {
        this.mgrid = mgrid;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    @Override
    public String toString() {
        String fmt = "%d %s %s %s %s %s %s %d %.2f %d %d";
        return String.format(fmt, empno, fname, lname, email,
                phone, hdate, jobid, sal, comm, mgrid, deptno);
    }
}

interface EMPDAO {
    int insertEmp(EMPVO emp);
    List<EMPVO> selectEmp();
    EMPVO selectOneEmp(int empno);
    int updateEmp(EMPVO emp);
    int delectEmp(int emp);
}

class EMPDAOImpl {
    private static String insertEmpSQL = " insert into EMPLOYEES " +
            " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    private static String selectEmpSQL = " select * from employees " +
            " order by EMPLOYEE_ID asc ";
    private static String selectOneEmpSQL = " select * from employees " +
            " where EMPLOYEE_ID = ? ";
    private static String deleteEmpSQL = " delete from employees where " +
            " EMPLOYEE_ID = ? ";
    private static String updateEmpSQL = " update employees set " +
            " (FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER) = (?, ?, ?, ?) " +
            " where EMPLOYEE_ID = ? ";


    public EMPDAOImpl() {}

    public static int insertEmp(EMPVO emp) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int cnt = -1;

        try{
            conn = C34JDBCUtil.makeConn();
            pstmt = conn.prepareStatement(insertEmpSQL);
            pstmt.setInt(1, emp.getEmpno());
            pstmt.setString(2, emp.getFname());
            pstmt.setString(3, emp.getLname());
            pstmt.setString(4, emp.getEmail());
            pstmt.setString(5, emp.getPhone());
            pstmt.setString(6, emp.getHdate());
            pstmt.setString(7, emp.getJobid());
            pstmt.setInt(8, emp.getSal());
            pstmt.setDouble(9, emp.getComm());
            pstmt.setInt(10, emp.getMgrid());
            pstmt.setInt(11, emp.getDeptno());

            cnt = pstmt.executeUpdate();
            System.out.println("데이터 입력 확인 : "+cnt);

        } catch (Exception ex) {
            System.out.println("insertEmp 에러!");
            System.out.println(ex.getMessage());
        } finally {
            C34JDBCUtil.closeConn(null, pstmt, conn);
        }

        return cnt;
    }

    public static List<EMPVO> selectEmp() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<EMPVO> empdata = new ArrayList<>();

        try {
            conn = C34JDBCUtil.makeConn();
            pstmt = conn.prepareStatement(selectEmpSQL);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                EMPVO emp = new EMPVO(
                    rs.getInt("EMPLOYEE_ID"),
                    rs.getString("FIRST_NAME"),
                    rs.getString("LAST_NAME"),
                    rs.getString("EMAIL"),
                    rs.getString("PHONE_NUMBER"),
                    rs.getString("HIRE_DATE"),
                    rs.getString("JOB_ID"),
                    rs.getInt("SALARY"),
                    rs.getDouble("COMMISSION_PCT"),
                    rs.getInt("MANAGER_ID"),
                    rs.getInt("DEPARTMENT_ID")
                );
                empdata.add(emp);
            }

        }catch(Exception ex){
            System.out.println("selectEmp 에러!");
            System.out.println(ex.getMessage());
        } finally {
            C34JDBCUtil.closeConn(rs, pstmt, conn);
        }

        return empdata;
    }

    public static EMPVO selectOneEmp(int empno) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        EMPVO emp = null;

        try{
            conn = C34JDBCUtil.makeConn();
            pstmt = conn.prepareStatement(selectOneEmpSQL);
            pstmt.setInt(1, empno);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                emp = new EMPVO(
                       rs.getInt("EMPLOYEE_ID"),
                       rs.getString("FIRST_NAME"),
                       rs.getString("LAST_NAME"),
                       rs.getString("EMAIL"),
                       rs.getString("PHONE_NUMBER"),
                       rs.getString("HIRE_DATE"),
                       rs.getString("JOB_ID"),
                       rs.getInt("SALARY"),
                       rs.getDouble("COMMISSION_PCT"),
                       rs.getInt("MANAGER_ID"),
                       rs.getInt("DEPARTMENT_ID")
                );
            }
        } catch (SQLException ex) {
            System.out.println("selectOneEmp 에러!");
            System.out.println(ex.getMessage());
        } finally {
        C34JDBCUtil.closeConn(rs, pstmt, conn);
    }

        return emp;
    }

    public static int deleteEmp(int empno) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int cnt = -1;

        try{
            conn = C34JDBCUtil.makeConn();
            pstmt = conn.prepareStatement(deleteEmpSQL);
            pstmt.setInt(1, empno);

            cnt = pstmt.executeUpdate();

        } catch (Exception ex) {
            System.out.println("deleteEmp 에러!");
            System.out.println(ex.getMessage());
        } finally {
            C34JDBCUtil.closeConn(null, pstmt, conn);
        }
        return cnt;
    }

    public static int updateEmp(EMPVO emp) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            conn = C34JDBCUtil.makeConn();
            pstmt = conn.prepareStatement(updateEmpSQL);
            pstmt.setString(1, emp.getFname());
            pstmt.setString(2, emp.getLname());
            pstmt.setString(3, emp.getEmail());
            pstmt.setString(4, emp.getPhone());
            pstmt.setInt(5, emp.getEmpno());

        } catch (Exception ex) {
        System.out.println("updateEmp 에러!");
        System.out.println(ex.getMessage());
    } finally {
        C34JDBCUtil.closeConn(null, pstmt, conn);
    }
        return 0;
    }
}