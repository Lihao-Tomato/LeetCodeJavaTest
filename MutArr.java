/* *构建乘积数组：
 * 题目链接
 * https://www.nowcoder.com/practice/94a4d381a68b47b7a8bed86f2975db46?tpId=13&&tqId=11204&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
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
