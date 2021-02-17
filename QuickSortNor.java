package sortTest;

import java.util.Arrays;
import java.util.Stack;


public class QuickSortNor {

    public static void quick(int[] array,int low,int high){
        Stack<Integer> stack = new Stack<>();
        int par = partion(array,low,high);

        if(par > low+1) {
            stack.push(low);
            stack.push(par-1);
        }

        if(par < high-1) {
            stack.push(par+1);
            stack.push(high);
        }

        while (!stack.empty()) {
            int end = stack.pop();
            int start = stack.pop();
            par = partion(array,start,end);
            if(par > start+1) {
                stack.push(start);
                stack.push(par-1);
            }

            if(par < end-1) {
                stack.push(par+1);
                stack.push(end);
            }
        }
    }

    public static int partion(int[] array,int low,int high){
        int tmp = array[low];
        while (low < high){
            while (array[high]>=tmp && low<high){
                high--;
            }
            if (low >= high){
                array[low] = tmp;
                break;
            } else {
                array[low] = array[high];
            }
            while (array[high]<=tmp && low<high){
                low++;
            }
            if (low >= high){
                array[high] = tmp;
                break;
            } else {
                array[high] = array[low];
            }
        }
        return low;
    }

    public static void quickSortNor(int[] array){
        quick(array,0,array.length-1);
    }

    public static void main(String[] args) {
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        System.out.println(Arrays.toString(array));
        quickSortNor(array);
        System.out.println("===================快速排序==================");
        System.out.println(Arrays.toString(array));
    }
}
