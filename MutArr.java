import java.util.*;
/* *构建乘积数组：
 * 题目链接
 * https://www.nowcoder.com/practice/94a4d381a68b47b7a8bed86f2975db46?tpId=13&&tqId=11204&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 解题思路：根据题目描述，如果可以使用除法，就很简单。但是要求不能使用。
 * 假设：left[i] = A[0]*...*A[i-1]
 *      right[i] = A[i+1]*...*A[n-1]
 *      所以：B[i] = left[i] * right[i]
 * 这样就避免使用了除法。但是如果对每个B[i], 0<=i<n,都这么求，显然时间复杂度太高。
 *      left[i+1] = A[0]*...A[i-1]*A[i]
 *      right[i+1] = A{i+2]*...*A[n-1]
 * 于是:
 *      left[i+1] = left[i] * A[i]
 *      right[i] = right[i+1] * A[i+1]
 *      所以，我们可以先把所有的left[i]求出，right[i]求出
 * */

package leetcode;

public class MutArr {
    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,4};
//        int[] B = methodOne(A);
        int[] B = methodTwo(A);
        for (int i=0;i<B.length;i++){
            System.out.println(B[i]);
        }
    }

    public static int[] methodOne(int[] A){
        int n = A.length;
        int[] B = new int[n];
        for (int i=0;i<n;i++)
            B[i] = 1;
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (j == i){
                    continue;
                }
                B[i] *= A[j];
            }
        }
        return B;
    }

    public static int[] methodTwo(int[] A){
        int n = A.length;
        int[] B = new int[n];
        for (int i=0;i<n;i++){
            B[i] = 1;
        }
        for (int i=1;i<n;i++){
            B[i] = B[i-1] * A[i-1]; // 左下三角
        }
        int tmp = 1;
        for (int j=n-2;j>=0;j--){
            tmp *= A[j+1];      // 右上三角
            B[j] *= tmp;        // left[i] * right[i]
        }
        return B;
    }
}
