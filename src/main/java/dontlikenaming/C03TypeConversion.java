package dontlikenaming;

public class C03TypeConversion {
    public static void main(String[] args) {
        // 자료형 변환
        // 묵시적 형 변환 (auto, promotion)
        byte z = 10;    // byte는 1byte 크기의 자료형
        int a = z;      // int는 4byte 크기의 자료형
        //int a = (int) z;  // 변수 승격 시 명시적 형변환 사용은 불필요
        System.out.printf("%d, %d\n\n",a,z);

        // 명시적 형 변환 (casting, overflow)
        // cast 연산자 사용
        // 자료형 변수명 A = (변환할 자료형) 변수명 B
        z = (byte) a;
        System.out.printf("%d, %d\n",a,z);

        a = 512;
        z = (byte) a;
        System.out.printf("%d, %d\n",a,z);

        a = Byte.MAX_VALUE+1;
        z = (byte) a;
        System.out.printf("%d, %d\n",a,z);

        double b = 3.14;
        long c = (long) b;
        System.out.printf("%f, %d\n\n",b,c);

        // 의도적인 형 변환
        // 정수끼리 산술연산 결과는 기본적으로 정수
        // 정수끼리 산술연산 결과를 실수로 얻고 싶다면 형 변환 필요
        int x = 98;
        int y = 99;
        System.out.printf("98 / 99 = %d\n", x/y);
        System.out.printf("98 / 99 = %f\n\n", (double)x/y);
        // 자동 형 변환에 의해 연산 결과는 실수로 변환됨
    }
}
