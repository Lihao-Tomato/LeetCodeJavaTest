package sortTest;

import java.util.Arrays;


public class MergeSortNor {

    public static void merge(int[] array,int gap){
        int len = array.length;
        int s1 = 0;
        int e1 = s1+gap-1;
        int s2 = e1+1;
        int e2 = s2+gap-1 < len ? s2+gap-1 : len-1;

        int[] tmpArr = new int[len];
        int k = 0;
        //先判断是否有2个归并段
        while (s2 < len){
            while (s1<=e1 && s2<=e2){
                if (array[s1] <= array[s2]){
                    tmpArr[k++] = array[s1++];
                } else {
                    tmpArr[k++] = array[s2++];
                }
            }
            //两个段长度不相等，拷贝剩下的数据
            while (s1 <= e1){
                tmpArr[k++] = array[s1++];
            }
            while (s2 <= e2){
                tmpArr[k++] = array[s2++];
            }
            //比较完了一组
            s1 = e2+1;
            e1 = s1+gap-1;
            s2 = e1+1;
            e2 = s2+gap-1 < len ? s2+gap-1 : len-1;
        }
        while (s1 <= len-1){
            tmpArr[k++] = array[s1++];
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = tmpArr[i];
        }
    }

    public static void mergeSortNor(int[] array){
        for (int i = 1; i < array.length; i *= 2) {
            merge(array,i);
        }
    }

    public static void main(String[] args) {
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        System.out.println(Arrays.toString(array));
        mergeSortNor(array);
        System.out.println("===================归并排序==================");
        System.out.println(Arrays.toString(array));
    }
}
