package examples;

public class EX01 {
    public static void main(String[] args){
        System.out.println("* 　*　  **    ****   ****    *     *     /////  ");
        System.out.println("* 　*　 *  *   *   *  *   *    *   *     | o o | ");
        System.out.println("*****　*    *  ****   ****      * *     (|  ^  |)");
        System.out.println("* 　*　******  *　*   *   *      *       | [_] | ");
        System.out.println("* 　*　* 　 *  * 　 * *    *     *       ¯¯¯¯¯¯¯ ");

        System.out.println(" ");
        System.out.println("            +---+     ");
        System.out.println("            |   |     ");
        System.out.println("        +---+---+     ");
        System.out.println("        |   |   |     ");
        System.out.println("    +---+---+---+       /\\_/\\     _____  ");
        System.out.println("    |   |   |   |      ( \" \" )  / Hello ∖ ");
        System.out.println("+---+---+---+---+      (  -  ) <  Junior | ");
        System.out.println("|   |   |   |   |       | | |   ∖ Coder! /");
        System.out.println("+---+---+---+---+      (__|__)    ¯¯¯¯¯    ");

        int soju = 3000;
        int soju_qty = 2;
        int sojusum = soju * soju_qty;
        int chicken = 12000;
        int chk_qty = 1;
        int chickensum = chicken * chk_qty;

        int total = (soju * soju_qty) + (chicken * chk_qty);
        int money = 50000;

        System.out.println(" ");
        System.out.println("[ 음식나라 ]");
        System.out.println("-------------------------");
        System.out.println("소주           "+sojusum);
        System.out.println("너나치킨       "+chickensum);
        System.out.println("-------------------------");
        System.out.println("과세합계       "+(total-(total/10)));
        System.out.println("부가세         "+(total/10));
        System.out.println("-------------------------");
        System.out.println("총합계         "+total);
        System.out.println("받은금액       "+money);
        System.out.println("잔돈           "+(money-total));
        System.out.println("-------------------------");
        System.out.println("2014. 07. 07 14:35:24");
    }
}
