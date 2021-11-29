package leetcode.string;

/**
 * @Author: Kevin
 * @Date: 2021/11/29 22:42
 * @Description: 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 示例 1：
 * 如果不存在公共前缀，返回空字符串 ""。
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * <p>
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
public class longestCommonPrefix {
    public static void main(String[] args) {
        String[] arr={"flower","flow","flight"};
        String[] arr2={"dog","racecar","car"};
        System.out.println(longestCommonPrefix(arr2));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            ans = ans.substring(0, j);
            if (ans == "") {
                return "";
            }
        }
        return ans;
    }
}