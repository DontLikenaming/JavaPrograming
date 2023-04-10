package dontlikenaming;

public class Membership {
    private int mno;
    private String name;
    private String email;
    private String hp;

    public Membership(int mno, String name, String email, String hp) {
        this.mno = mno;
        this.name = name;
        this.email = email;
        this.hp = hp;
    }

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("조회 결과\n")
        .append("회원 번호 : ").append(mno).append("\n")
        .append("이름 : ").append(name).append("\n")
        .append("이메일 : ").append(email).append("\n")
        .append("휴대전화 번호 : ").append(hp).append("\n");
        return String.format(sb.toString());
    }
}
