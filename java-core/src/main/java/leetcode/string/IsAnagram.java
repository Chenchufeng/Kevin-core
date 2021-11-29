package leetcode.string;

import java.util.Arrays;

/**
 * @Author: Kevin
 * @Date: 2021/11/28 22:20
 * @Description:
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 *

 */
public class IsAnagram {
    public static void main(String[] args) {
//        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        int[] letterCount = new int[26];
        //统计字符串s中的每个字符的数量
        for (int i = 0; i < s.length(); i++) {
            letterCount[s.charAt(i)-'a']++;
        }
        //减去字符串t中的每个字符的数量
        for (int i = 0; i < t.length(); i++) {
            letterCount[t.charAt(i)-'a']--;
        }
        //如果数组letterCount的每个值都是0，返回true，否则返回false
        for (int count:letterCount){
            if (count!=0){
                return false;
            }
        }
        return true;
    }

    /**
     * 先把两个字符串转化为字符数组，然后再对这两个字符数组进行排序，因为相同的字符在排序之后肯定是挨着的，最后再比较这两个排序后的数组的元素是否相同。
     */
    public boolean isAnagram2(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        //对两个字符串中的字符进行排序
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.equals(sChar, tChar);
    }

}