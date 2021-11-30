package leetcode.string;

import java.util.Locale;

/**
 * @Author: Kevin
 * @Date: 2021/11/30 21:45
 * @Description: 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 * <p>
 * 提示：
 * 1 <= s.length <= 2 * 105
 * 字符串 s 由 ASCII 字符组成
 */
public class IsPalindrome {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        String str2 = "race a car";
        System.out.println(isPalindrome2(str));
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 0)
            return true;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            //只考虑字母和数字，所以不是字母和数字的先过滤掉
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
                right--;
            //然后把两个字符变为小写，在判断是否一样，如果不一样，直接返回false
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }

    //使用正则匹配
    public static boolean isPalindrome2(String s) {
        String actual = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
        String rev=new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }
}