package dontlikenaming;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class C24File {
    public static void main(String[] args) {
        // 학번, 이름, 주소, 생년월일, 학과명, 교수 등으로
        // 구성된 객체 데이터를 students.dat에 저장

        // 학생 객체 생성
        Student std1 = new Student(
                201350050, "김태희",
                "경기도 고양시", "1985.3.22",
                "컴퓨터", 504);

        Student std2 = new Student(
                201350006, "송혜교",
                "서울 영등포구", "1988.9.17",
                "컴퓨터", 301);

        // 학생 정보 저장용 파일 지정
        String fname = "C:/Java/students.dat";
/*        File file1 = new File(fname);
        FileWriter fw = null;

        try {
            fw = new FileWriter(file1);

            fw.write(std1.toString());
            fw.write(std2.toString());

            System.out.print("\n파일 생성 성공!\n");

        } catch (Exception ex){
            System.out.println("실패!");
            System.out.println(ex.getMessage());
        } finally {
            if(fw!=null) {
                try {
                    fw.close();
                } catch (Exception ex) {}
            }
        }*/

        // 파일에 저장된 학생 정보를 읽어서 변수(stdinfo)에 저장
        FileReader fr = null;
        BufferedReader br = null;
        List<String> stdinfos = new ArrayList<>();

        try {
            fr = new FileReader(fname);
            br = new BufferedReader(fr);

            while (br.ready()){
                stdinfos.add(br.readLine());
            }

            System.out.println("\n성공!\n");

        } catch (Exception ex){
            System.out.println("실패!");
            System.out.println(ex.getMessage());
        } finally {
            if(br!=null) {
                try {
                    br.close();
                } catch (Exception ex) {}
            }

            if(fr!=null) {
                try {
                    fr.close();
                } catch (Exception ex) {}
            }
        }

        // 변수에 저장된 학생정보 출력
        for(String stdinfo : stdinfos){
            String[] infos = stdinfo.split(" ");
            System.out.println("학번 : "+infos[0]);
            System.out.println("이름 : "+infos[1]);
            System.out.println("주소 : "+infos[2]+" "+infos[3]);
            System.out.println("생년월일 : "+infos[4]);
            System.out.println("학과명 : "+infos[5]);
            System.out.println("교수 : "+infos[6]+"\n");
        }

        // 위와 같이 하면 객체의 멤버 변수 고유의 성질이 변하게 됨
        // ex) 학번, 교수번호 등이 String이 되어버림
    }
}

class Student {
    private int hakbun;
    private String name;
    private String address;
    private String brith;
    private String dept;
    private int prof;

    public Student(
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