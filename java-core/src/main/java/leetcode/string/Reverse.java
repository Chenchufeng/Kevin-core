package leetcode.string;

/**
 * @Author: Kevin
 * @Date: 2021/11/28 20:25
 * @Description:
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。

 */
public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse2(120));
    }

    public static int reverse(int x) {
        if (x == 0 || x == Integer.MIN_VALUE) {
            return 0;
        }
        int flag = x > 0 ? 1 : -1;
        x=Math.abs(x);
        int num=0;
        try {
            num=Integer.valueOf(new StringBuffer(String.valueOf(x)).reverse().toString());
        } catch (NumberFormatException e) {
            return 0;
        }
        return flag*num;
    }

    public static int reverse2(int x){
        int result=0;
        while (Math.abs(x)>0){
            int remain=x%10;
            result=result*10+remain;
            x=x/10;
        }
        if(result>Integer.MAX_VALUE || result<Integer.MIN_VALUE){
            return 0;
        }
        return result;
    }
}