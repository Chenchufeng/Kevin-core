package leetcode.string;

import java.util.HashMap;

/**
 * @Author: Kevin
 * @Date: 2021/11/28 21:01
 * @Description:
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar2("loveleetcode"));
    }

    public static int firstUniqChar(String s){
        char[] count=new char[26];
        char[] chars = s.toCharArray();
        //先统计每个字符出现的次数
        for (int i = 0; i < s.length(); i++) {
            count[chars[i]-'a']++;
        }
        //然后在遍历字符串s中的字符，如果出现次数是1就直接返回
        for (int j=0;j<s.length();j++){
            if (count[chars[j]-'a']==1){
                return j;
            }
        }
        return -1;
    }

    public static int firstUniqChar2(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char ch:chars) {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        //然后在遍历字符串s中的字符，如果出现次数是1就直接返回
        for (int i=0;i<s.length();i++){
            if(map.get(chars[i])==1){
                return i;
            }
        }
        return -1;
    }
}