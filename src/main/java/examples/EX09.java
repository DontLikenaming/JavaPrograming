package examples;


public class EX09 {
    public static void main(String[] args){
        // board 테이블에 대응하는 클래스 작성
        board b1 = new board(
                1, "Mr.Bob", "저녁 추천 좀",
                "라면 말고", 1, "2023-04-07");
        System.out.println(b1);

        // employees, departments 테이블에 대응하는 클래스 작성
        EmployeesVO e1 = new EmployeesVO(100,"Steven","King","SKING",
                "515.123.4567","2003-06-17",
                "AD_PRES",24000.00,null,
                null,90);
        System.out.println(e1);

        DepartmentsVO d1 = new DepartmentsVO(10, "Administration", 200, 1700);
        System.out.println(d1);

    }
}
class board{
    private int bno;
    private String userid;
    private String title;
    private String contents;
    private int views;
    private String regdate;


    public board() {
    }

    public board(
            int bno, String userid, String title,
            String contents, int views, String regdate) {
        this.bno = bno;
        this.userid = userid;
        this.title = title;
        this.contents = contents;
        this.views = views;
        this.regdate = regdate;
    }


    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }


    @Override
    public String toString() {
        String fmt = "글 번호 : %d\n작성자 ID : %s\n글 제목 : %s\n" +
                "글 내용 : %s\n열람 횟수 : %d\n작성일 : %s\n";
        return String.format(fmt,
                bno, userid, title, contents, views, regdate);
    }
}

class EmployeesVO{
    private int EMPLOYEE_ID, DEPARTMENT_ID;
    private String FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID;
    private double SALARY;
    private Long COMMISSION_PCT;
    private Integer MANAGER_ID;


    public EmployeesVO() {}
    public EmployeesVO(int EMPLOYEE_ID, String FIRST_NAME, String LAST_NAME,
                       String EMAIL, String PHONE_NUMBER, String HIRE_DATE,
                       String JOB_ID, double SALARY, Long COMMISSION_PCT,
                       Integer MANAGER_ID, int DEPARTMENT_ID)
    {
        this.EMPLOYEE_ID = EMPLOYEE_ID;
        this.FIRST_NAME = FIRST_NAME;
        this.LAST_NAME = LAST_NAME;
        this.EMAIL = EMAIL;
        this.PHONE_NUMBER = PHONE_NUMBER;
        this.HIRE_DATE = HIRE_DATE;
        this.JOB_ID = JOB_ID;
        this.SALARY = SALARY;
        this.COMMISSION_PCT = COMMISSION_PCT;
        this.MANAGER_ID = MANAGER_ID;
        this.DEPARTMENT_ID = DEPARTMENT_ID;
    }


    public int getEMPLOYEE_ID() {
        return EMPLOYEE_ID;
    }

    public void setEMPLOYEE_ID(int EMPLOYEE_ID) {
        this.EMPLOYEE_ID = EMPLOYEE_ID;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getPHONE_NUMBER() {
        return PHONE_NUMBER;
    }

    public void setPHONE_NUMBER(String PHONE_NUMBER) {
        this.PHONE_NUMBER = PHONE_NUMBER;
    }

    public String getHIRE_DATE() {
        return HIRE_DATE;
    }

    public void setHIRE_DATE(String HIRE_DATE) {
        this.HIRE_DATE = HIRE_DATE;
    }

    public String getJOB_ID() {
        return JOB_ID;
    }

    public void setJOB_ID(String JOB_ID) {
        this.JOB_ID = JOB_ID;
    }

    public double getSALARY() {
        return SALARY;
    }

    public void setSALARY(double SALARY) {
        this.SALARY = SALARY;
    }

    public Long getCOMMISSION_PCT() {
        return COMMISSION_PCT;
    }

    public void setCOMMISSION_PCT(Long COMMISSION_PCT) {
        this.COMMISSION_PCT = COMMISSION_PCT;
    }

    public Integer getMANAGER_ID() {
        return MANAGER_ID;
    }

    public void setMANAGER_ID(Integer MANAGER_ID) {
        this.MANAGER_ID = MANAGER_ID;
    }

    public int getDEPARTMENT_ID() {
        return DEPARTMENT_ID;
    }

    public void setDEPARTMENT_ID(int DEPARTMENT_ID) {
        this.DEPARTMENT_ID = DEPARTMENT_ID;
    }


    @Override
    public String toString() {
        String fmt = "고용인 ID : %d\n이름 : %s\n성 : %s\n" +
                "이메일 : %s\n전화번호 : %s\n고용일 : %s\n" +
                "직업 ID : %s\n연봉 : %.0f\nCOMMISSION 비율 : %.2f\n" +
                "메니저 ID : %d\n부서 ID : %s\n";
        return String.format(fmt, EMPLOYEE_ID, FIRST_NAME, LAST_NAME,
                EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY,
                COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID);

    }
}

class DepartmentsVO{
    private int DEPARTMENT_ID, LOCATION_ID;
    private String DEPARTMENT_NAME;
    private Integer MANAGER_ID;


    public DepartmentsVO(){}
    public DepartmentsVO(
            int DEPARTMENT_ID, String DEPARTMENT_NAME,
            Integer MANAGER_ID, int LOCATION_ID)
    {
        this.DEPARTMENT_ID = DEPARTMENT_ID;
        this.DEPARTMENT_NAME = DEPARTMENT_NAME;
        this.MANAGER_ID = MANAGER_ID;
        this.LOCATION_ID = LOCATION_ID;
    }


    public int getDepartment_ID() {
        return DEPARTMENT_ID;
    }

    public void setDepartment_ID(int DEPARTMENT_ID) {
        this.DEPARTMENT_ID = DEPARTMENT_ID;
    }

    public String getDepartment_name() {
        return DEPARTMENT_NAME;
    }

    public void setDepartment_name(String DEPARTMENT_NAME) {
        this.DEPARTMENT_NAME = DEPARTMENT_NAME;
    }

    public Integer getManager_ID() {
        return MANAGER_ID;
    }

    public void setManager_ID(Integer MANAGER_ID) {
        this.MANAGER_ID = MANAGER_ID;
    }

    public int getLocation_ID() {
        return LOCATION_ID;
    }

    public void setLocation_ID(int LOCATION_ID) {
        this.LOCATION_ID = LOCATION_ID;
    }


    @Override
    public String toString() {
        String fmt = "부서 ID : %d\n부서명 : %s\n" +
                "메니저 ID : %d\n위치 ID : %d\n";
        return String.format(fmt,
                DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID);
    }
}