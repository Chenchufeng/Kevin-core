package leetcode.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Kevin
 * @Date: 2021/11/30 23:17
 * @Description: 字符串转换整数 (atoi)
 * 请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * <p>
 * 函数myAtoi(string s) 的算法如下：
 * <p>
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231, 231− 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231− 1 的整数应该被固定为 231− 1 。
 * 返回整数作为最终结果。
 * 注意：
 * <p>
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 */
public class MyAtoi {
    public static void main(String[] args) {
        String s = "words and 987";
        String s1 = s = "4193 with words";
        String s2=s = "-91283472332";
        System.out.println(myAtoi(s2));
    }

    public static int myAtoi(String s) {
        Pattern pattern = Pattern.compile("[0-9]*");
        int flag = 1;
        if (s.length() == 0) {
            return 0;
        }
        if (s.startsWith(" ")) {
            s = s.trim();
        } else {
            if (s.startsWith("-")) {
                flag = -1;
            } else {
                Matcher isNum = pattern.matcher(s.charAt(0) + "");
                if (!isNum.matches()) {
                    return 0;
                }
                for (int i = 0; i < s.length(); i++) {
                    if (!Character.isDigit(s.charAt(i))) {
                        s = s.substring(0, i);
                    }
                }
            }
        }
        Integer integer = Integer.valueOf(s) * flag;
        if (integer < Integer.MIN_VALUE) {
            integer = Integer.MIN_VALUE;
        }
        if (integer > Integer.MAX_VALUE) {
            integer = Integer.MAX_VALUE;
        }
        return integer;
    }
}