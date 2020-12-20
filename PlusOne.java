import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *              最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *              你可以假设除了整数 0 之外，这个整数不会以零开头。
 * OJ链接：https://leetcode-cn.com/problems/plus-one
 * 解题：1、末位无进位，则末位加一即可，因为末位无进位，前面也不可能产生进位，比如 45 => 46
 *      2、末位有进位，在中间位置进位停止，则需要找到进位的典型标志，即为当前位 %10后为 0，
 *          则前一位加 1，直到不为 0 为止，比如 499 => 500
 *      3、末位有进位，并且一直进位到最前方导致结果多出一位，对于这种情况，
 *          需要在第 2 种情况遍历结束的基础上，进行单独处理，比如 999 => 1000
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {9,9,9,9,9};
        int[] result = plusOne(digits);
        System.out.println(Arrays.toString(result));
    }

    public static int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            digits[i] = (digits[i]+1)%10;
            if(digits[i] != 0){
                return digits;
            }
        }
        int[] arr = new int[digits.length+1];
        arr[0] = 1;
        return arr;
    }
}
