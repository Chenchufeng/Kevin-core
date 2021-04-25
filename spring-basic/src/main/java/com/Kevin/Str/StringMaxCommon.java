package com.Kevin.Str;

/**
 * @Author: chufeng Chen
 * @Description:
 * 获取两个字符串中最大相同子串，比如：
 * str1="abcwerthelloyuiodef"
 * str2="cvhellobnm"
 * 提示：将短的那个串进行长度依次递减的子串与较长的串比较
 * @Date:Create：in 2021/4/24 23:13
 */
public class StringMaxCommon {

    public static String getMaxSameString(String str1, String str2){
        if (str1!=null && str2!=null) {
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() < str2.length()) ? str1 : str2;
            int len = minStr.length();

            for (int i = 0; i < len; i++) {
                for (int x = 0, y = len - i; y <= len; x++, y++) { //类似于窗口的滑动
                    String subStr=minStr.substring(x,y);
                    if (maxStr.contains(subStr)) {
                        return subStr;
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String str1="abcwerthelloyuiodef";
        String str2="cvhellobnm";
        String result = getMaxSameString(str1, str2);
        System.out.println("最大相同子串为: "+result);
    }
}
