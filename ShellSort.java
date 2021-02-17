package sortTest;

import java.util.Arrays;


public class ShellSort {

    public static void shellSort(int[] array){
        int[] drr = {5,3,1};
        for (int i = 0; i < drr.length; i++) {
            shell(array, drr[i]);
        }
    }

    public static void shell(int[] array,int gap){
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i-gap;
            for (; j >= 0; j=j-gap) {
                if (array[j] <= tmp){
                    break;
                } else {
                    array[j+gap] = array[j];
                }
            }
            array[j+gap] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        System.out.println(Arrays.toString(array));
        shellSort(array);
        System.out.println("===================希尔排序==================");
        System.out.println(Arrays.toString(array));
    }
}
