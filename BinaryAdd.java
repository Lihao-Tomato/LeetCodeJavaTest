/* *不用加减乘除做加法（位运算）
题目链接：
https://www.nowcoder.com/practice/59ac416b4b944300b617d4f7f111b215?tpId=13&&tqId=11201&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
无进位和运算就是按位异或结果，进位就是与运算结果但是需要左移一位，因为进位影响下一位的运算。
 */

package leetcode;

public class BinaryAdd {
    public static void main(String[] args) {
        int num1=11;
        int num2=6;
        int sum = add(num1, num2);
        System.out.println("sum=" +sum);

    }
    public static int add(int num1, int num2){
        int result, ans;
        do {
            result = num1 ^ num2; // 不带进位的加法
            ans = (num1&num2) << 1; // 进位
            num1 = result;
            num2 = ans;
        } while (ans != 0); // 进位为0
        return result;
    }
}
