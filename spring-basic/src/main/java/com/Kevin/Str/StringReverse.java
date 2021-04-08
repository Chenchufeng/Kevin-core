package com.Kevin.Str;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/3/29 22:51
 */
public class StringReverse {
    /**
     * 将一个字符串进行反转，将字符串中指定的部分进行反转，比如“abcdefg” 反转为 “abfedcg”
     */

    public static String reverse(String str,int startIndex,int endIndex){
        if (str !=null && str.length()!=0){
            //方式一：转化为字符数组
            char[] arr = str.toCharArray();
            for (int x=startIndex,y=endIndex;x<y;x++,y--){
                char temp=arr[x];
                arr[x]=arr[y];
                arr[y]=temp;
            }
            return new String(arr);
        }
       return null;
    }
    public static void main(String[] args) {
        String str="abcdefg";

    }
}
