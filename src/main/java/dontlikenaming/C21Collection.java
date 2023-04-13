package dontlikenaming;

import java.util.ArrayList;
import java.util.List;

public class C21Collection {
    // Collection
    // 데이터를 저장하는 자료구조와
    // 데이터를 처리(CRUD)하는 알고리즘을
    // 체계적으로 정리(구조화)해서
    // 인터페이스와 클래스로 구현해 놓은 프레임워크

    public static void main(String[] args) {
        // ArrayList
        // 동적배열의 한 종류
        // List 인터페이스를 구현해서 만든 컬렉션 프레임워크
        // 요소의 저장순서가 유지
        // 중복으로 데이터를 저장할 수 있음
        // 크기가 늘어나면 새로운 배열을 생성하고
        // 기존의 요소들을 옮겨야 하는 복잡한 과정이 동반됨
/*        List<String> names = new ArrayList<>();
        //ArrayList names = new ArrayList<>();

        // 데이터 추가 : add("값")
        names.add("혜교");
        names.add("지현");
        names.add("수지");

        // 특정 위치에 데이터 추가 : add("위치", "값")
        names.add(1, "원영");

        // 전체 조회 : enhanced for, foreach
        for(String name : names){
            System.out.print(name+" ");
        }
        System.out.print("\n");

        // 특정 요소 조회 : get("위치값")
        System.out.println("1번 index 조회 : "+names.get(1));

        // 특정 요소 변경 : set("위치값", "새로운 값")
        names.set(1, "윤아");
        System.out.println("1번 index의 값을 윤아로 수정 : "+names.get(1));

        // 특정 요소 제거 : remove("위치값")
        names.remove(1);
        System.out.println("1번 index의 값 삭제 후 1번 index : "+names.get(1));

        // 특정 요소 제거 : remove("값")
        names.remove("수지");
        System.out.println("수지 삭제 후 가장 마지막 요소 : "+names.get(names.size()-1));

        // 데이터 검색
        // 위치로 검색 : get("위치값"), indexOf("값")
        // 값으로 검색 : foreach, contains("값")

        // "지현"을 검색 1
        for(String name : names){
        // for(int i=0;i<names.size();i++){
            // if(name.get(i).equals("지현")){
            if(name.equals("지현")){
                System.out.print("데이터 찾음");
            }
        }
        System.out.print("\n");

        // "지현"을 검색 2
        if(names.contains("지현")){
            System.out.print("데이터 찾음");
            System.out.print("\n");
        }

        // "지현"을 검색 2
        if(names.indexOf("지현")>-1){
            System.out.print("데이터 찾음");
            System.out.print("\n");
        }

        // 게임 정보 동적 배열 생성
        List<GameInfo> games = new ArrayList<>();
        games.add(new GameInfo("디아블로4",89600));
        games.add(new GameInfo("젤다의 전설",74800));
        games.add(new GameInfo("바이오하자드 4RE",67000));

        // 조회
        // GameInfo 타입은 객체형이므로
        // toString 재정의 없이 객체 자체를 출력 시
        // 객체의 메모리 주소가 출력
       for(GameInfo game : games){
            System.out.println(game);
        }

        // "젤다의 전설"의 가격을 조회
        for(int i=0;i<games.size();i++){
            String game = String.valueOf(games.get(i));
            if(game.startsWith("젤다")){
                System.out.println(game.substring(game.length()-5));
            }
        }

        for(GameInfo game : games){
            String value = String.valueOf(game);
            if(value.startsWith("젤다")){
                System.out.println(value.substring(value.length()-5));
            }
        }

        for(GameInfo game : games){
            String value = String.valueOf(game);
            if(value.contains("젤다")){
                System.out.println(value.substring(value.length()-5));
            }
        }

        for(GameInfo game : games){
            String value = String.valueOf(game);
            if(value.indexOf("젤다")>-1){
                System.out.println(value.substring(value.length()-5));
            }
        }*/



    }
}

class GameInfo {
    private String name;
    private int price;

    public GameInfo(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(name).append(", ").append(price);
        return sb.toString();
    }
}