package sortTest;

import java.util.Arrays;


public class SelectSort {

    public static void selectSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[i]){
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        System.out.println(Arrays.toString(array));
        selectSort(array);
        System.out.println("===================直接选择排序==================");
        System.out.println(Arrays.toString(array));
    }
}
