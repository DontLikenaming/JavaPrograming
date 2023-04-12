package dontlikenaming;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class C19Package {
    public static void main(String[] args) {
        // Math 클래스
/*        int a = 4, b = 10, c = 1;
        double d = 4.51, e = 5.41;

        System.out.println(Math.max(a, b) +" / "+ Math.max(b, c));
        System.out.println(Math.min(a, b) +" / "+ Math.min(b, c));
        System.out.println(Math.round(d) +" / "+ Math.round(e));
        System.out.println(Math.ceil(d) +" / "+ Math.floor(d));
        System.out.println(Math.ceil(e) +" / "+ Math.floor(e));

        double r = Math.random();
        System.out.println(r);
        System.out.println((int)(r * 5));
        System.out.println((int)(r * 10));
        System.out.println((int)(r * 5)+1);
        System.out.println((int)(r * 10)+1);

        for(int i=0;i<6;i++){
            double random = Math.random();
            System.out.print((Math.floor(random * 45)+1) + " ");
        }*/

        // String 클래스
        // ex) 파일명이 abc123.png라 할 때
        // 파일명과 확장자를 분리해서 출력
/*        String filename1 = "abc123.png";
        String fname1 = filename1.substring(0,6);
        String ext1 = filename1.substring(7,10);

        String fname2 = filename1.substring(0, filename1.indexOf('.'));
        String ext2 = filename1.substring(filename1.indexOf('.')+1);

        String[] filename3 = filename1.split("\\.");
        String fname3 = filename3[0];
        String ext3 = filename3[1];

        System.out.print(fname1+" / "+ext1+"\n");
        System.out.print(fname2+" / "+ext2+"\n");
        System.out.print(fname3+" / "+ext3);

        // 문자열 합치기 : +, concat(비추), Stringbuilder, StringBuffer
        // + : 내부적으로 Stringbuilder를 이용해서 처리
        // Stringbuilder (동기화x) > StringBuffer (동기화o)
        // 실무에서는 StringBuffer를 주로 사용

        // Date 클래스
        Date dateToday1 = new Date();
        System.out.println(dateToday1);

        // Calendar 클래스
        Calendar calendarToday2 = Calendar.getInstance();
        System.out.println(calendarToday2.getTime());
        System.out.print(calendarToday2.get(Calendar.YEAR)+"-"+
                (calendarToday2.get(Calendar.MONTH)+1)+"-"+
                calendarToday2.get(Calendar.DATE)+" ");
        System.out.print(calendarToday2.get(Calendar.HOUR)+":"+
                (calendarToday2.get(Calendar.MINUTE)+1)+":"+
                calendarToday2.get(Calendar.SECOND)+" ");
        if(calendarToday2.get(Calendar.AM_PM)==Calendar.AM){
            System.out.print("AM\n");
        } else {System.out.print("PM\n");}
        
        // DateFormat 클래스
        // 날짜나 시간 표시를 좀 더 편하게 다루기 위해 사용
        // Date 클래스를 사용함
        String dfmt = "YYYY-MM-dd";    // 년-월-일
        String tfmt = "HH:mm:ss E요일 a";      // 시:분:초 요일
        SimpleDateFormat sdf1 = new SimpleDateFormat(dfmt);
        SimpleDateFormat sdf2 = new SimpleDateFormat(tfmt);

        System.out.print(sdf1.format(dateToday1)+" ");
        System.out.print(sdf2.format(dateToday1)+"\n");


        // 래퍼 클래스
        // 기본 자료형 데이터를 클래스형 데이터로 취급할 때 사용하는 클래스
        int f = 1;
        Integer g = new Integer(f);     // 박싱 : 기본형 -> 클래스형
        // System.out.println(f.toString());
        System.out.println(g.toString());

        int h = g.intValue();           // 언박싱 : 클래스형 -> 기본형
        System.out.println(h);

        // 문자열값을 기본 자료형으로 변환 : "래퍼 클래스".parse"자료형"
        int i = Integer.parseInt("12345");
        Integer j = Integer.parseInt("12345");*/
    }
}
