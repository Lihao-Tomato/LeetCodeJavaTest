/* *
题目：斐波那契数列
题目描述：现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1），n<=39
题目链接：https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&&tqId=11160&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int f1 = 0;
        int f2 = 1;
        int f3;
        for (int i=0;i<n;i++){
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        System.out.println(f1);
    }
}
