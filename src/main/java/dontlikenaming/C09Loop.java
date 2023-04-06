package dontlikenaming;

public class C09Loop {
    public static void main(String[] args) {
        // 중첩 반복문
        // 2개 이상의 반복문을 겹쳐 사용하는 반복문

        // *를 5개씩 5행 출력
/*        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }*/


        // 5층 피라미드
/*        for(int i=0;i<5;i++){         // 행
            for(int j=0;j<i+1;j++){     // 열
                System.out.print("*");
            }
            System.out.print("\n");
        }*/


        // 5층 역피라미드
/*        for(int i=0;i<5;i++){
            for(int j=5-i;j>0;j--){
                System.out.print("*");
            }
            System.out.print("\n");
        }*/


        // 구구단
/*            System.out.println(" --------------");
            for(int i=2;i<10;i++){
                for(int j=1;j<10;j++){
                    System.out.printf("ㅣ %d * %d = %2d ㅣ\n",i,j,i*j);
                }
            System.out.println(" --------------");
        }*/


    }
}
