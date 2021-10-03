package sort;

import utils.TestUtils;

/**
 * @Author: Kevin
 * @Date: 2021/10/3 11:28
 * @Description: 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr=new int[]{4,9,13,26,24,3,7};
        insertionSort(arr);
        TestUtils.printArray(arr);
    }
    public static void insertionSort(int[] arr) {
        if (arr.length<2 || arr==null){
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j>=0 && arr[j]>arr[j+1]; j--) {
                TestUtils.swap(arr,j,j+1);
            }
        }
    }
}