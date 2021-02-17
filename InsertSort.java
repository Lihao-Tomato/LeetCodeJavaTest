package sortTest;

import java.util.Arrays;


public class InsertSort {

    public static void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i-1;
            for (; j >= 0; j--) {
                if (array[j] <= tmp){
                    break;
                } else {
                    array[j+1] = array[j];
                }
            }
            array[j+1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        System.out.println(Arrays.toString(array));
        insertSort(array);
        System.out.println("===================插入排序==================");
        System.out.println(Arrays.toString(array));
    }
}
