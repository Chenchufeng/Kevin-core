package leetcode.owl;

/**
 * @Author: Kevin
 * @Date: 2021/12/14 23:19
 * @Description: 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"

 */
public class longestPalindrome_05 {
    public static void main(String[] args) {
        System.out.println(longest("babad"));

    }
    //动态规划
    public static String longest(String s){
        int len =s.length();
        if (s.length()<2){
            return s;
        }
        int maxLen=1;
        int begin=0;
        //dp[i][j]表示s[i][j]是否是回文串
        boolean[][] dp=new boolean[len][len];
        for (int i=0;i<len;i++){
            dp[i][i]=true;
        }
        char[] charArray = s.toCharArray();
        for (int j=1;j<len;j++){
            for (int i=0;i<j;i++){
                if (charArray[i]!=charArray[j]){
                    dp[i][j]=false;
                }else {
                    if (j-i<3){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                //只要dp[i][j]==true成立，就表示字串s[i,j]是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j-i+1>maxLen){
                    maxLen=j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }

    public static String longestPalindrome(String s) {
        int max=0;
        String ans="";
        for (int i = 0; i < s.length(); i++) {
            for (int j=i+1;j<s.length();j++){
                String test=s.substring(i,j);
                if (isPalindromic(test) && test.length()>max){
                    ans=s.substring(i,j);
                    max=Math.max(max,ans.length());
                }
            }
        }
        return ans;
    }

    public static boolean isPalindromic(String s) {
        int len=s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i)!=s.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }
}