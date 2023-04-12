package dontlikenaming.project.sungjuk.model;

public class SungJukVO {
    private String name, regdate;
    private int sjon, kor, eng, mat, tot;
    private double avg;
    private char grd;


    public SungJukVO() {
    }

    public SungJukVO(int sjon, String name,
                     int kor, int eng, int mat)
    {
        this.sjon = sjon;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    public void setSjon(int sjon) {
        this.sjon = sjon;
    }

    public int getSjon() {
        return sjon;
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
        return regdate;
    }


    @Override
    public String toString() {
        String fmt = "학번 : %d\n이름 : %s\n" +
                "국어점수 : %d\n영어점수 : %d\n수학점수 : %d\n" +
                "총합 : %d\n평균 : %.1f\n" +
                "학점 : %c\n입력시간 : %s\n";
        return String.format(fmt, sjon, name,
                kor, eng, mat, tot, avg, grd, regdate);
    }
}
