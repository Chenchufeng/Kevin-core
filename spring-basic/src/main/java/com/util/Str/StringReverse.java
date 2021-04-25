package com.util.Str;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/3/29 22:51
 */
public class StringReverse {
    /**
     * 将一个字符串进行反转，将字符串中指定的部分进行反转，比如“abcdefg” 反转为 “abfedcg”
     */
    //方法1
    public static String reverse1(String str,int startIndex,int endIndex){
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


    //方法2
    public static String reverse2(String str,int startIndex,int endIndex){
        if(str!=null){
            //第一部分
            String reverseStr = str.substring(0, startIndex);
            //第二部分
            for(int i=endIndex;i>=startIndex;i--){
                reverseStr+=str.charAt(i);
            }
            //第三部分
            reverseStr+=str.substring(endIndex+1);
            return reverseStr;
        }
        return null;
    }

    //方法3：使用StringBuilder/StringBuffer 代替String,效率更高
    public static String reverse3(String str,int startIndex,int endIndex){
        StringBuilder builder = new StringBuilder(str.length());
        //第一部分
        builder.append(str.substring(0,startIndex));
        //第二部分
        for(int i=endIndex;i>=startIndex;i--){
            builder.append(str.charAt(i));
        }
        //第三部分
        builder.append(str.substring(endIndex+1));
        return builder.toString();
    }

    public static void main(String[] args) {
        String str="abcdefg";
        String result = reverse3(str, 2, 5);
        System.out.println(result);
    }
}
