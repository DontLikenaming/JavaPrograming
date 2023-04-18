package dontlikenaming.project.sungjuk.model;

public class SungJukVO {
    private String name, regdate;
    private int sjno, kor, eng, mat, tot;
    private double avg;
    private char grd;


    public SungJukVO() {
    }

    public SungJukVO(int sjno, String name, int kor, int eng, int mat){
        this.sjno = sjno;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    public SungJukVO(int sjno, String name, int kor, int eng, int mat, int tot, double avg, char grd, String regdate) {
        this(sjno, name, kor, eng, mat);
        this.mat = mat;
        this.tot = tot;
        this.avg = avg;
        this.grd = grd;
        this.regdate = regdate;
    }

    public SungJukVO(String name, int kor, int eng, int mat){
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    public SungJukVO(String name, int kor, int eng, int mat, int tot, double avg, char grd, String regdate) {
        this(name, kor, eng, mat);
        this.mat = mat;
        this.tot = tot;
        this.avg = avg;
        this.grd = grd;
        this.regdate = regdate;
    }

    public void setSjno(int sjno) {
        this.sjno = sjno;
    }

    public int getSjno() {
        return sjno;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getKor() {
        return kor;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getEng() {
        return eng;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    public int getMat() {
        return mat;
    }

    public void setTot(int tot) {
        this.tot = tot;
    }

    public int getTot() {
        return tot;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public double getAvg() {
        return avg;
    }

    public void setGrd(char grd) {
        this.grd = grd;
    }

    public char getGrd() {
        return grd;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public String getRegdate() {
        return regdate.substring(0,19);
    }


    @Override
    public String toString() {
        String fmt = "%d, %s, " +
                "%d, %d, %d, " +
                "%d, %.1f, " +
                "%c, %s\n";
        return String.format(fmt, sjno, name,
                kor, eng, mat, tot, avg, grd, regdate.substring(0,19));
    }
}
