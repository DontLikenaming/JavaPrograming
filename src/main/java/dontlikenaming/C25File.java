package dontlikenaming;

import java.io.*;

public class C25File {
    // 직렬화, 역직렬화
    // JVM 내에 생성된 자바 객체 또는 데이터를
    // JVM 외부에서도 사용할 수 있도록
    // 바이트 형태로 데이터를 변환하는 행위
    public static void main(String[] args) {
        Student2 std1 = new Student2(
                201350050, "김태희",
                "경기도 고양시", "1985.3.22",
                "컴퓨터", 504);

        Student2 std2 = new Student2(
                201350006, "송혜교",
                "서울 영등포구", "1988.9.17",
                "컴퓨터", 301);

        String fname = "C:/Java/students.obj";

        // 직렬화
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try{
            fos = new FileOutputStream(fname);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(std1);      // 객체를 파일에 저장

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            if(oos!=null) {
                try {
                    oos.close();
                } catch (Exception ex) {}
            }

            if(fos!=null) {
                try {
                    fos.close();
                } catch (Exception ex) {}
            }
        }

        // 역직렬화
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Student2 readstds = null;

        try{
            fis = new FileInputStream(fname);
            ois = new ObjectInputStream(fis);

            readstds = (Student2) ois.readObject();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            if(ois!=null) {
                try {
                    ois.close();
                } catch (Exception ex) {}
            }

            if(fis!=null) {
                try {
                    fis.close();
                } catch (Exception ex) {}
            }
        }

        // 역직렬화 결과 확인
        System.out.println(readstds.getHakbun());
    }
}

class Student2 implements Serializable {
    private int hakbun;
    private String name;
    private String address;
    private String brith;
    private String dept;
    private int prof;

    public Student2(
            int hakbun, String name, String address,
            String brith, String dept, int prof)
    {
        this.hakbun = hakbun;
        this.name = name;
        this.address = address;
        this.brith = brith;
        this.dept = dept;
        this.prof = prof;
    }

    public int getHakbun() {
        return hakbun;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(hakbun).append(" ")
                .append(name).append(" ")
                .append(address).append(" ")
                .append(brith).append(" ")
                .append(dept).append(" ")
                .append(prof).append('\n');

        return sb.toString();
    }
}