package leetcode.owl;

/**
 * @Author: Kevin
 * @Date: 2021/12/14 22:12
 * @Description: 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 */
public class findMedianSortedArrays_04 {
    public static void main(String[] args) {
        int[] nums1 =new int[]{1,2};
        int[] nums2 =new int[]{3,4};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int k1=0,k2=0;
        int[] merge = new int[nums1.length + nums2.length];
        int index=0;
        if (nums1.length==0 && nums2.length==0){
            return 0;
        }
        if (nums1.length!=0 && nums2.length==0){
            mergeArray(nums1);
        }
        if (nums1.length==0 && nums2.length!=0){
            mergeArray(nums2);
        }
        while (k1<nums1.length && k2<nums2.length){
            if (nums1[k1]<=nums2[k2]){
                merge[index++]=nums1[k1];
                k1++;
            }else {
                merge[index++]=nums2[k2];
                k2++;
            }
        }
        if (k1<nums1.length){
            while (k1<nums1.length){
                merge[index++]=nums1[k1++];
            }
        }
        if (k2<nums2.length){
            while (k2<nums2.length){
                merge[index++]=nums2[k2++];
            }
        }
        return mergeArray(merge);
    }

    public static double mergeArray(int[] array){
        if (array.length%2!=0){
            return (array[array.length/2]);
        }else {
            return Integer.valueOf(array[array.length/2-1]+array[array.length/2])/2.0;
        }
    }
}