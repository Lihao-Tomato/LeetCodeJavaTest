package sortTest;

import java.util.Arrays;


public class QuickSort {

    public static void quick(int[] array,int low,int high){
        if (low >= high){
            return;
        }

        int par = partition(array,low,high);
        quick(array,low,par-1);
        quick(array,par+1,high);
    }

    public static void medianOfThree(int[] array,int low,int high) {
        int mid = (low+high)/2;
        //array[mid] < array[low] < array[high]
        if (array[low] > array[mid]){
            int tmp = array[low];
            array[low] = array[mid];
            array[mid] = tmp;
        }
        if (array[low] > array[high]){
            int tmp = array[low];
            array[low] = array[high];
            array[high] = tmp;
        }
    }

    public static int partition(int[] array,int low,int high){
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

    public static void quickSort(int[] array){
        quick(array,0,array.length-1);
    }

    public static void main(String[] args) {
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        System.out.println(Arrays.toString(array));
        quickSort(array);
        System.out.println("===================快速排序==================");
        System.out.println(Arrays.toString(array));
    }
}
