package sortTest;

import java.util.Arrays;


public class TestDemo {

    public static void sort(int[] array){
        createHeap(array);
        int end = array.length-1;
        while (end > 0){
            int tmp = array[0];
            array[0] = array[end];
            array[end] = tmp;
            adjustDown(array,0,end);
            end--;
        }
    }

    public static void adjustDown(int[] array,int parent,int len){
        int child = 2*parent+1;
        while (child < len){
            if (child+1<len && array[child]<array[child+1]){
                child++;
            }
            if(array[child] > array[parent]){
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            } else {
                break;
            }
        }
    }

    public static void createHeap(int[] array){
        for (int i = 0; i < array.length; i++) {
            adjustDown(array,(array.length-1-1)/2,array.length);
        }
    }

    public static void main(String[] args) {
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        System.out.println(Arrays.toString(array));
        sort(array);
        System.out.println("===================排序==================");
        System.out.println(Arrays.toString(array));
    }
}
