package sortTest;

import java.util.Arrays;


public class MergeSort {

    public static void merge(int[] array, int low,int high,int mid) {
        int s1 = low;
        int s2 = mid+1;
        int[] tmpArr = new int[high-low+1];
        int k = 0;//就是tmpArr的下标

        //代表2个段都有数据
        while (s1 <= mid && s2 <= high) {
            if(array[s1] <= array[s2]) {
                tmpArr[k] = array[s1];
                k++;
                s1++;
            }else {
                tmpArr[k] = array[s2];
                k++;
                s2++;
            }
        }
        //第一个归并段 还有 若干数据
        while (s1 <= mid) {
            tmpArr[k++] = array[s1++];
        }
        while (s2 <= high) {
            tmpArr[k++] = array[s2++];
        }
        //也就是说 tmpArr 当中存放的 就是这次归并的有序之后 的 结果
        for (int i = 0; i < tmpArr.length; i++) {
            array[low+i] = tmpArr[i];
        }
    }

    public static void mergeSortInternal(int[] array, int low,int high) {
        if(low >= high) {
            return;
        }
        int mid = (low+high)/2;
        mergeSortInternal(array,low,mid);
        mergeSortInternal(array,mid+1,high);
        //开始合并
        merge(array,low,high,mid);
    }

    public static void mergeSort(int[] array) {
        mergeSortInternal(array,0,array.length-1);
    }

    public static void main(String[] args) {
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        System.out.println(Arrays.toString(array));
        mergeSort(array);
        System.out.println("===================快速排序==================");
        System.out.println(Arrays.toString(array));
    }
}
