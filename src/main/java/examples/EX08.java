package examples;

public class EX08 {
    public static void main(String[] args) {
        Student std = new Student();
        std.setStudent(201350050,"김태희", "경기도고양시",
                        "1985.3.22","컴퓨터",504);
        System.out.println(std);

        Professor p1 = new Professor();
        p1.setProf(301,"이순신", "프로그래밍");
        System.out.println(p1);

    }
}
class Student{
    private int stdID, stdProf;
    private String stdName, stdAddr, stdBirth, stdDept;


    public void setStdID(int stdID){
        this.stdID = stdID;
    }

    public void setStdName(String stdName){
        this.stdName = stdName;
    }

    public void setStdAddr(String stdAddr){
        this.stdAddr = stdAddr;
    }

    public void setStdBirth(String stdBirth){
        this.stdBirth = stdBirth;
    }

    public void setStdDept(String stdDept){
        this.stdDept = stdDept;
    }

    public void setStdProf(int stdProf){
        this.stdProf = stdProf;
    }


    public int getStdID(){
        return stdID;
    }

    public String getStdName(){
        return stdName;
    }

    public String getStdAddr(){
        return stdAddr;
    }

    public String getStdBirth(){
        return stdBirth;
    }

    public String getStdDept(){
        return stdDept;
    }

    public int getStdProf(){
        return stdProf;
    }


    public void setStudent(
            int stdID, String stdName, String stdAddr,
            String stdBirth, String stdDept, int stdProf)
    {
        this.stdID = stdID;
        this.stdName = stdName;
        this.stdAddr = stdAddr;
        this.stdBirth = stdBirth;
        this.stdDept = stdDept;
        this.stdProf = stdProf;
    }

    @Override
    public String toString(){
        String fmt = "학번 : %d\n이름 : %s\n주소 : %s\n" +
                "생년월일 : %s\n학과명 : %s\n교수 : %d\n";
        return String.format(fmt,
                stdID, stdName, stdAddr, stdBirth, stdDept, stdProf);
    }
}

class Professor{
    private int profID;
    private String profName, profMajon;


    public void setProfID(int profID){
        this.profID = profID;
    }

    public void setProfName(String profName){
        this.profName = profName;
    }

    public void setProfMajon(String profMajon){
        this.profMajon = profMajon;
    }


    public int getProfID(){
        return profID;
    }

    public String getProfName(){
        return profName;
    }

    public String getProfMajon(){
        return profMajon;
    }


    public void setProf(
            int profID, String profName, String profMajon)
    {
        this.profID = profID;
        this.profName = profName;
        this.profMajon = profMajon;
    }

    @Override
    public String toString(){
        String fmt = "교수번호 : %d\n이름 : %s\n전공분야 : %s\n";
        return String.format(fmt, profID, profName, profMajon);
    }
}
