package leetcode.string;

/**
 * @Author: Kevin
 * @Date: 2021/11/30 21:00
 * @Description: 反转字符串
 *编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
示例 1：
输入：s = ["h","e","l","l","o"]
输出：["o","l","l","e","h"]
示例 2：
输入：s = ["H","a","n","n","a","h"]
输出：["h","a","n","n","a","H"]

提示：
1 <= s.length <= 105
s[i] 都是 ASCII 码表中的可打印字符
 *
 */
public class ReverseString {
    public static void main(String[] args) {
        reverseString("Hello".toCharArray());
    }

    public static void reverseString(char[] s) {
        //两个指针一个从第1个，一个从最后一个开始，
        //两两交换
        int length=s.length;
        int left=0;
        int right=length-1;
        while (left<right){
            swap(s,left++,right--);
        }
    }
    private static void swap(char[] array,int i,int j){
        char temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    //递归
    public static void reverseString2(char[] s){
        if(s==null || s.length==0){
            return;
        }
        reverseStringHelper(s,0,s.length-1);
    }

    public static void reverseStringHelper(char[] s,int left,int right){
        while (left>=right){
            return;
        }
        swap(s,left,right);
        reverseStringHelper(s,++left,--right);
    }
}