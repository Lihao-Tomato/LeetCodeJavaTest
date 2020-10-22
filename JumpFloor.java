/* *青蛙跳台阶
题目描述：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
题目链接：https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=13&&tqId=11161&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
*/

package leetcode;

import java.util.Scanner;

public class JumpFloor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = jumpFloorOne(n);
        System.out.println("方法一：一共有"+count+"中跳法");

        int result = jumpFloorTwo(n);
        System.out.println("方法二：一共有"+result+"中跳法");

    }

    public static int jumpFloorOne(int n){
        if (n <= 2)
            return n;
        return jumpFloorOne(n-1) + jumpFloorOne(n-2);
    }

    public static int jumpFloorTwo(int target) {
        if(target < 2)
            return target;
        int f1 = 1;
        int f2 = 2;
        int f3 = 0;
        for (int i=3;i<=target;i++){
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}
