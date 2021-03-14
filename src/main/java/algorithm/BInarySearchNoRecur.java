package algorithm;

/**
 * @Author: chufeng Chen
 * @Description:二分查找的非递归实现
 * @Date:Create：in 2021/3/14 20:02
 */
public class BInarySearchNoRecur {
    /**
     * @param arr：待查找的数组，arr是升序排序
     * @param target：需要查找的数
     * @return 返回对应下标，-1表示没有找到
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <=right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;  //需要向右边查找
            } else if (arr[mid] < target) {
                left = mid + 1;  //需要向左边查找
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 10, 11, 67, 100};
        int search = binarySearch(arr, 1);
        if (search==-1){
            System.out.println("找不到该数字，查找失败");
        }else{
            System.out.println("查找成功,target为： "+arr[search]);
        }
    }
}
