/* *
题目：输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
题目链接:https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8?tpId=13&&tqId=11164&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
解决思路：一个二进制数1100，从右边数起第三位是处于最右边的一个1。减去1后，第三位变成0，它后面的两位0变成了1，而前面的1保持不变，因此得到的结果是1011.
        我们发现减1的结果是把最右边的一个1开始的所有位都取反了。这个时候如果我们再把原来的整数和减去1之后的结果做与运算，
        从原来整数最右边一个1那一位开始所有位都会变成0。如1100&1011=1000.也就是说，把一个整数减去1，
        再和原整数做与运算，会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。
 */

package leetcode;

import java.util.Scanner;

public class BinaryOneCount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int count = oneCount(num);
        System.out.println("二进制中1的个数为："+count);
    }

    public static int oneCount(int num){
        int count = 0;
        while (num != 0) {
            count ++;
            num = num&(num-1);
        }
        return count;
    }
}
