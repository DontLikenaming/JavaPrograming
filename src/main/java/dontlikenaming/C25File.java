package dontlikenaming;

import java.io.*;
import java.util.ArrayList;

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

        ArrayList<Student2> stds = new ArrayList<>();
        stds.add(std1);
        stds.add(std2);

        String fname = "C:/Java/students.obj";

        // 직렬화
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        ObjectOutputStream oos = null;

        try{
            fos = new FileOutputStream(fname);
            bos = new BufferedOutputStream(fos);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(std1);      // 객체를 파일에 저장
            oos.writeObject(std2);
            oos.writeObject(stds);

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            if(oos!=null) {
                try {
                    oos.close();
                } catch (Exception ex) {}
            }

            if(bos!=null) {
                try {
                    bos.close();
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
        BufferedInputStream bis = null;
        ObjectInputStream ois = null;
        Student2 readstd1 = null;
        Student2 readstd2 = null;
        ArrayList<Student2> list = null;

        try{
            fis = new FileInputStream(fname);
            bis = new BufferedInputStream(fis);
            ois = new ObjectInputStream(bis);

            readstd1 = (Student2) ois.readObject();
            readstd2 = (Student2) ois.readObject();
            list = (ArrayList) ois.readObject();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            if(ois!=null) {
                try {
                    ois.close();
                } catch (Exception ex) {}
            }

            if(bis!=null) {
                try {
                    bis.close();
                } catch (Exception ex) {}
            }

            if(fis!=null) {
                try {
                    fis.close();
                } catch (Exception ex) {}
            }
        }

        // 역직렬화 결과 확인
        System.out.println(readstd1);
        System.out.println(readstd2);
        System.out.println(list);
        System.out.println(list.get(0).getHakbun()+"\n");

        System.out.println("데이터 타입 보존 여부 확인");
        Check example = new Check();
        System.out.print("학번의 데이터 타입은 "+example.Check(list.get(0).getHakbun())+"\n");
        System.out.print("이름의 데이터 타입은 "+example.Check(list.get(0).getName()));

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

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(hakbun).append(" ")
                .append(name).append(" ")
                .append(address).append(" ")
                .append(brith).append(" ")
                .append(dept).append(" ")
                .append(prof);

        return sb.toString();
    }
}
class Check {
    public <T> T Check(T a) {
        T result = null;
        if (a.getClass() == Integer.class) {
            result = (T)"Integer";
        } else if (a.getClass() == Double.class) {
            result = (T)"Double";
        } else if (a.getClass() == Float.class) {
            result = (T) "Float";
        } else if (a.getClass() == String.class) {
            result = (T) "String";
        }

        return result;
    }
}