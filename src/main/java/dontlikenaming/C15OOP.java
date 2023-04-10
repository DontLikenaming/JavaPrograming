package dontlikenaming;
import java.util.ArrayList;

public class C15OOP {
    // 클래스 종류
    // Service : 비지니스 로직 처리를 담당하는 클래스
    // VO로 저장된 데이터를 DAO로 넘기기 전에
    // 처리해야 하는 일반적인 작업을 기능으로 구현한 클래스
    // 메서드만 저장하기 위해 생성하는 클래스
    // DAO(Data Access Object) : 데이터베이스의 data에 접근하기 위한 객체
    // 비지니스 로직과 분리되어 있음

    // 일반적인 프로그래밍 작성 흐름
    // J2EE(Java 2 Enterprise Edition) :
    //      웹 어플리케이션 서버에서 동작하는
    //      장애복구 및 분산 멀티미어를 제공하는
    //      자바 소프트웨어 기능을 추가한 서버를 위한 플랫폼.
    //      JVM이 탑재된 플랫폼이면 무엇이든 상관 없음.
    //      자바 기술로 기업환경의 어플리케이션을 만드는데 필요함)
    // J2EE 개발에 최적화된 방식
    // VO - Service - DAO - DB

    public static void main(String[] args) {
        // 회원 정보 처리 기능이 정의된 클래스 객체 선언
        MemberService msrv = new MemberService();
        Member m = new Member(
                "홍길동","010","1234","5678",
                "abc123","zyx987.com");

        msrv.newMember(m);
        msrv.readMember();
        msrv.readOneMember("홍길동");
        msrv.modifyMember("홍길동");
        msrv.removeMember("홍길동");
    }
}

// 회원정보 : 이름, 전화번호, 이메일
class Member {
    private String name;
    private String hp1;         // 지역번호
    private String hp2;         // 국번
    private String hp3;         // 국번
    private String email1;
    private String email2;

    public Member(String name, String hp1, String hp2, String hp3, String email1, String email2) {
        this.name = name;
        this.hp1 = hp1;
        this.hp2 = hp2;
        this.hp3 = hp3;
        this.email1 = email1;
        this.email2 = email2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHp1() {
        return hp1;
    }

    public void setHp1(String hp1) {
        this.hp1 = hp1;
    }

    public String getHp2() {
        return hp2;
    }

    public void setHp2(String hp2) {
        this.hp2 = hp2;
    }

    public String getHp3() {
        return hp3;
    }

    public void setHp3(String hp3) {
        this.hp3 = hp3;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }
}

// 회원정보 관련 CRUD 기능 구현
// "VO"Service
class MemberService {
    // 회원정보 생성(C) : new 접두사
    public boolean newMember(Member mvo) {
        System.out.println("회원 정보 생성");
        return false;
    }

    // 전체 회원정보 조회(R) : read 접두사
    public ArrayList<String> readMember() {
        ArrayList<String> members = new ArrayList<String>();
        System.out.println("회원 정보 전체 조회");
        return null;
    }

    // 단일 회원정보 조회(R) : readOne 접두사
    public Member readOneMember(String name) {
        System.out.println("회원 정보 조회");
        return null;
    }

    // 회원정보 수정(U) : modify 접두사
    public boolean modifyMember(String name) {
        System.out.println("회원 정보 수정");
        return false;
    }

    // 회원정보 삭제(R) : remove 접두사
    public boolean removeMember(String name) {
        System.out.println("회원 정보 삭제");
        return false;
    }
}