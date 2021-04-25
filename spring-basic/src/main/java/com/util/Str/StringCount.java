package com.util.Str;

/**
 * @Author: chufeng Chen
 * @Description:
 *      * 获取一个字符串在另一个字符串中出现的次数
 *      * 比如：获取"ab"在"abkkcadkabkebfkabkskab" 中出现的次数
 * @Date:Create：in 2021/4/24 16:02
 */

public class StringCount {

    /**
     * 获取subStr在mainStr中出现的次数
     * @param mainStr
     * @param subStr
     * @return
     */

    public static int getCount(String mainStr,String subStr){
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count=0;
        int index=0;
        //方法1:
//        if(mainLength>=subLength){
//            while((index=mainStr.indexOf(subStr))!= -1){
//                count++;
//                mainStr= mainStr.substring(index + subStr.length());
//            }
//            return count;
//        }
        //方法2：对方法1的改进
        if (mainLength>=subLength){
            while ((index=mainStr.indexOf(subStr,index)) != -1){
                count++;
                index+=subStr.length();
            }
            return count;
        }
        else{
            return 0;
        }
    }

    public static void main(String[] args) {
        String mainStr="abkkcadkabkebfkabkskab";
        String subStr="ab";
        int count = getCount(mainStr, subStr);
        System.out.println("subStr在mainStr中出现的次数: "+count);
    }
}
