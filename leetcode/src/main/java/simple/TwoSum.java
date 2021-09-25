package simple;

import java.util.HashMap;

/**
 * @Author: Kevin
 * @Date: 2021/9/25 21:39
 * @Description: 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 */
public class TwoSum {
    public static void main(String[] args) {

//        int[] arr=new int[]{2,7,11,15};
        int[] arr=new int[]{3,2,4};
//        int[] res = twoSum(arr, 9);
        int[] res = twoSum(arr, 6);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    //暴力法
    public static int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        if(nums.length==0 ||nums==null){
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[i]+nums[j]==target){
                    result[0]=i;
                    result[1]=j;
                    break;
                }
            }
        }
        return result;
    }
    //哈希法
    public static int[] twoSum2(int[] nums, int target) {
        int[] result=new int[2];
        if(nums.length==0 ||nums==null){
            return result;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp=target-nums[i];
            if(map.containsKey(temp)){
                result[1]=i;
                result[0]=map.get(temp);
            }
            map.put(nums[i],i);
        }
        return result;
    }
}