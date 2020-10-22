/* *
题目：旋转数组的最小数字
题目描述：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
        输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
        例如数组[3,4,5,1,2]为[1,2,3,4,5]的一个旋转，该数组的最小值为1。
        NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
题目链接：https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?
 */

public class MinNumberInRotateArray {
    public static void main(String[] args) {
        int[] array = {3,4,5,1,2};
        int result = minNumberInRotateArray(array);
        System.out.println("result="+result);
    }

    public static int minNumberInRotateArray(int[] array){
        if (array==null || array.length==0){
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (left < right){
            mid = (left+right)/2;
            if (right-left == 1){
                array[mid] = array[right];
                break;
            }
            if (array[mid] >= array[left]){
                left = mid;
            }
            else if (array[mid] <= array[right]){
                right = mid;
            }
        }

        return array[mid];
    }
}
