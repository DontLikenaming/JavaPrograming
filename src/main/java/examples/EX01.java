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

        int total = sojusum + chickensum;
        double vat = total * 0.1;
        int money = 50000;

        System.out.println(" ");
        System.out.println("[ 음식나라 ]");
        System.out.println("-------------------------");
        System.out.printf("소주\t\t%d\t%5d\n", soju_qty, sojusum);
        System.out.printf("너나치킨\t%d\t%d\n", chk_qty, chickensum);
        System.out.println("-------------------------");
        System.out.printf("과세합계\t\t%.0f\n",total-vat);
        System.out.printf("부가세\t\t\t%5.0f\n",vat);
        System.out.println("-------------------------");
        System.out.printf("총합계\t\t\t%d\n", total);
        System.out.printf("받은금액\t\t%d\n", money);
        System.out.printf("잔돈\t\t\t%d\n", money-total);
        System.out.println("-------------------------");
        System.out.println("2023. 04. 03\t10:06:00");
    }
}
