/**
 * 题目：数字在升序数组中出现的次数
 * 题目描述：统计一个数字在升序数组中出现的次数
 * OJ链接：https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2?tpId=13&&tqId=11190&rp=1&ru=/activity/oj&qru=/ta/coding-interviews/question-ranking
 * 解题思路：数组是有序的，大概率是二分查找，利用好二分查找的特性就可以解题
 */


import java.util.Scanner;

public class GetNumberOfK {
    public static void main(String[] args) {
        int[] array = {1,2,3,3,4,5,6,6,7};
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int kCount = getNumberOfK(array, k);
        System.out.println(kCount);
    }

    public static int getNumberOfK(int[] array, int k){
        if (array==null || array.length==0){
            return 0;
        }
        int mid = 0;
        int left = 0;
        int right = array.length-1;
        while (left <= right){
            mid = (left+right)/2;
            if (array[mid] <= k){
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        int kRight = left;
        mid = 0;
        left = 0;
        right = array.length-1;
        while (left <= right){
            mid = (left+right)/2;
            if (array[mid] < k){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        int kLeft = left;

        return kRight - kLeft;
    }
}
