/* *求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
题目链接：
https://www.nowcoder.com/practice/7a0da8fc483247ff8800059e12d7caf1?tpId=13&&tqId=11200&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */

package leetcode;

import java.util.Scanner;

public class AddN {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int sum = add(num);
        System.out.println("sum=" +sum);
    }

    public static int add(int num){
        int sum = num;
        boolean stop = (num>1)&&((sum += add(num-1)) != 0);
        return sum;
    }
}
