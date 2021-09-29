package sort;

/**
 * @Author: Kevin
 * @Date: 2021/9/29 23:03
 * @Description:
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr=new int[]{4,9,13,26,24,3,7};
        sort(arr);
        printArray(arr);
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void sort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i=arr.length-1;i>0;i--){
            for (int j=0;j<i;j++){
                if (arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}