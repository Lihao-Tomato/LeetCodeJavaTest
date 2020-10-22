/* *
题目：调整数组顺序使奇数位于偶数前面
题目描述：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
题目链接：https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593?
解题思路：找到第一个奇数，将其前边的所有偶数向后移动一位，然后将其放到偶数前
 */

import java.util.Arrays;

public class ReOrderArray {
    public static void main(String[] args) {
        int[] arrary = {1,2,3,4,5,6};
        System.out.println("原数组序列："+Arrays.toString(arrary));
        reOrderArray(arrary);
        System.out.println("转换后的数组序列："+Arrays.toString(arrary));
    }

    public static void reOrderArray(int[] array){
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]%2 != 0){   // 奇数
                int tmp = array[i];
                int j = i;
                while (j > k){
                    array[j] = array[j-1];  // 将奇数前的所有偶数后移一位
                    j--;
                }
                array[k++] = tmp;
            }
        }
    }
}
