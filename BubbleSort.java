package sortTest;

import java.util.Arrays;


public class BubbleSort {

    public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < array.length-i-1; j++) {
                if (array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    isSorted = false;
                }
            }
            if (isSorted){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println("===================冒泡排序==================");
        System.out.println(Arrays.toString(array));
    }
}
