/* *
题目：二维数组中的查找
题目描述：在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
题目链接：https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/codinginterviews/question-ranking
 */

import java.util.Scanner;

public class FindSolution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        boolean isNum = find(target, arr);
        System.out.println(isNum);
    }

    public static boolean find(int target, int[][] arr){
        int i = 0;
        int j = arr[0].length-1;
        while (i<arr.length && j>=0){
            if (target < arr[i][j]){
                j--;        // 排除当前列
            }
            else if (target > arr[i][j]){
                i++;        // 排除当前行
            }
            else if (arr[i][j] == target){
                return true;
            }
        }
        return false;
    }
}
