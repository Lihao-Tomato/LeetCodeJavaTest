public class PivotIndex {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int sum1 = 0;
        for(int num: nums){
            sum1 += num;
        }
        int sum2 = 0;
        for(int i = 0; i<nums.length; i++){
            sum2 += nums[i];
            if(sum1 == sum2){
                return i;
            }
            sum1 = sum1 - nums[i];
        }
        return -1;
    }
}
