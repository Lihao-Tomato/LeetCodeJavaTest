/**
 * 题目：和为S的两个数字
 * 题目描述：输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 *         如果有多对数字的和等于S，输出两个数的乘积最小的。
 * OJ链接：https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b?tpId=13&&tqId=11195&rp=1&ru=/activity/oj&qru=/ta/coding-interviews/question-ranking
 * 解题思路：定义首尾两个指针，判断与sum大小
 */

import java.util.ArrayList;
import java.util.Scanner;

public class FindNumbersWithSum {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        ArrayList<Integer> list = findNumberWithSum(array,sum);
        System.out.println(list.get(0)+"+"+list.get(1));
    }

    public static ArrayList<Integer> findNumberWithSum(int[] array, int sum){
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0;
        int right = array.length-1;
        while (left < right){
            if (array[left]+array[right] < sum){
                left++;
            }
            else if (array[left]+array[right] > sum){
                right--;
            }
            else {
                list.add(array[left]);
                list.add(array[right]);
                break;
            }
        }
        return list;
    }
}

