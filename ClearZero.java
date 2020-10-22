/* *
题目：清除行列
题目描述：给定一个N阶方阵int[][](C++中为vector<vector><int>>)mat及其阶数n，若方阵中某个元素为0，则将其所在的行与列清零。
OJ链接：https://www.nowcoder.com/practice/c95aac1506574dfc8ad44c3939c6739d?tpId=8&&tqId=11000&rp=1&ru=/activity/oj&qru=/ta/cracking-the-coding-interview/question-ranking
解题思路：首先需要遍历数组标记元素为0的位置，然后再遍历清除行列
 */

import java.util.Arrays;

public class ClearZero {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3},
                {0, 1, 2},
                {0, 0, 1}
        };
        int n = mat.length;
        int[][] newMat= clearZero(mat, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d\t", newMat[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] clearZero(int[][] mat,int n){
        boolean[] row = new boolean[n];
        boolean[] column = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0){
                    row[i] = true;  //标记行
                    column[j] = true;   //标记列
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i]==true || column[j]==true){
                    mat[i][j] = 0;  //将有0的行列都清0
                }
            }
        }
        return mat;
    }
}
