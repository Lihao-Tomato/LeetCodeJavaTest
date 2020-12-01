/**
 * Created with IntelliJ IDEA.
 * Description:在排序数组中查找元素的第一个和最后一个位置
 *      给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置
 *      如果数组中不存在目标值 target，返回 [-1, -1]
 * 解题思路：有序数组，要先想到用二分查找来解决：
 *      1.先找左边的下标：只要nums[mid]>=target时，使right=mid-1。如果nums[mid]=target，每次更新下标为mid;
 *      2.再找左边的下标：只要nums[mid]<=target时，使left=mid+1。如果nums[mid]=target，每次更新下标为mid;
 *      3.注意查找的结束条件是，left<=right
 *
 * OJ链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 */
public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int leftIndex = leftIndex(nums,target);
        int rightIndex = rightIndex(nums,target);
        return new int[] {leftIndex,rightIndex};
    }

    public static int leftIndex(int[] nums,int target){
        //找左边的索引值
        int left = 0;
        int right = nums.length-1;
        int mid;
        int ans = -1;
        while (left <= right){
            mid = (left + right) / 2;
            if(nums[mid] < target){
                left = mid+1;
            } else {
                right = mid - 1;
            }
            if(nums[mid] == target){
                ans = mid;
            }
        }
        return ans;
    }

    public static int rightIndex(int[] nums,int target){
        //找右边的索引值
        int left = 0;
        int right = nums.length-1;
        int mid;
        int ans = -1;
        while (left <= right){
            mid = (left + right) / 2;
            if(nums[mid] <= target){
                left = mid+1;
            } else {
                right = mid - 1;
            }
            if(nums[mid] == target){
                ans = mid;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,1};
        int[] array = searchRange(nums,7);
        System.out.println(array[0]+"---->"+array[1]);
    }
}
