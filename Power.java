/* *
题目：数值的整数次方
题目描述：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。（保证base和exponent不同时为0）
题目链接：https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00?tpId=13&&tqId=11165&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */

import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double base = in.nextDouble();
        int exponent = in.nextInt();
        double result = power(base, exponent);
        System.out.println(result);
    }

    public static double power(double base, int exponent){
        double result = 1.0;
        if (base == 0.0){
            return 0.0;
        }
        int e = exponent > 0 ? exponent : -exponent;
        for (int i=0;i<e;i++){
            result = result * base;
        }

        return exponent > 0 ? result : 1/result;
    }
}
