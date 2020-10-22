/* *
题目：最小调整有序
题目描述：给定一个int整数数组A及其大小n，请编写一个函数，找出索引m和n，只要将m和n之间的元素排好序，整个数组就是有序的。
        注意：n-m应该越小越好，即找出符合条件的最短序列。
        请返回一个二元组，元组的两个元素分别代表所求序列的起点和终点。(原序列位置从0开始标号,若原序列有序，返回[0,0])。
        要求A中元素均为正整数。
OJ链接：https://www.nowcoder.com/practice/091c2f1cf441484f81696f08328b06cd?tpId=8&&tqId=11059&rp=1&ru=/activity/oj&qru=/ta/cracking-the-coding-interview/question-ranking
解题思路：找最右端序列（从左向右找）：注意在中间乱序的序列中（也就是待排序的那组序列）一定存在待排序序列中的最大值，找到这个max，
                    然后在其右边的序列中找到最后一个比max小的数字，它的下标就是最右端下标，即n。
        找左端序列（从右向左找）：思路一样，在中间乱序的序列中（也就是待排序的那组序列）一定存在待排序序列中的最小值，找到这个min，
                    然后在其左边的序列中找到最后一个比min小的数字，它的下标就是最左端下标，即m。
 */

public class FindSegment {
    public static void main(String[] args) {
        int[] array = {1,4,7,5,2,6,8,9,10};
        int[] segmentRange = findSegment(array,array.length);
        System.out.println("n="+segmentRange[0]);
        System.out.println("m="+segmentRange[1]);
    }

    public static int[] findSegment(int[] A,int n){
        if (A.length == 0){
            return new int[]{0,0};
        }
        int[] segmentRange = new int[2];
        int right = 0;
        int left = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (A[i] >= max){
                max = A[i];
            }
            else {
                right = i;  //最右边的下标
            }
        }
        for (int j = n-1; j >= 0; j--) {
            if (A[j] <= min){
                min = A[j];
            }
            else{
                left = j;   //最左边的下标
            }
        }
        segmentRange[0] = left;
        segmentRange[1] = right;
        return segmentRange;
    }
}
