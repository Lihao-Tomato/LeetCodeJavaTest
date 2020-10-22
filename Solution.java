/* *
题目：数组中只出现一次的数字
题目描述：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
题目链接：https://www.nowcoder.com/practice/e02fdb54d7524710a7d664d082bb7811?tpId=13&&tqId=11193&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */

public class Solution {
    public static void main(String[] args) {
        int[] array = {1,2,1,3,4,5,5,4,3,6,7,7};
        int[] num1 = new int[1];
        int[] num2 = new int[2];
        FindNumsAppearOnce(array, num1, num2);
    }

    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]){
        int ret = array[0];
        for (int i = 1; i < array.length; i++) {
            ret ^= array[i];
        }
        ret &= -ret;  // //把异或结果的最后一位1的那位找出来(例如：2和4-->0110^1010-->0010)
        for (int i = 0; i < array.length; i++) {
            if ((array[i]&ret) == 0){
                num1[0] ^= array[i];
            }
            else {
                num2[0] ^= array[i];
            }
        }
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
