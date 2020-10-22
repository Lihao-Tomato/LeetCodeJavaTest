/* *
题目：数组中出现超过一半的数字
题目描述：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。如果不存在则输出0。
OJ链接：https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?
解题方法：1.使用Map 2.先排序后判断数组中间值是否符合要求 3.摩尔投票法（类似士兵打仗）
 */

import java.util.Arrays;

public class MoreThanHalfNum {
    public static void main(String[] args) {
        int[] array = {4,2,1,4,2,4};
        int num = moreThanHalfNum(array);
        System.out.println("num="+num);
    }

//    public static int moreThanHalfNum(int[] array){
//        /* *
//        方法二
//         */
//        Arrays.sort(array);
//        int mid = (array.length)/2;
//        int count = 0;      // 统计排序后数组的中间值的个数，用来判断出现的次数是否大于数组长度的一半
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] == array[mid]){
//                count++;
//            }
//        }
//        if (count > mid){
//            return array[mid];
//        }
//        else {
//            return 0;
//        }
//    }
    public static int moreThanHalfNum(int[] array){
        int num = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (times == 0){
                num = array[i];
                times = 1;
            }
            if (num == array[i]){
                times++;
            }
            else {
                times--;
            }
        }
        System.out.println(num);
        int count=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num){
                count++;
            }
        }
        return count > (array.length)/2 ? num : 0;
    }
}
