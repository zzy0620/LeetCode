package scu.edu.cn.list;

public class LongestPalindromeSubString {
    public boolean isPalindrome(String s){
        boolean flag = true;
        int end = s.length()/2;
        for (int i=0;i<end;i++){
            if (s.charAt(i) != s.charAt(s.length()-1-i)){
                flag = false;
                break;
            }
        }
        return flag;
    }
//    暴力法
    public String longestPalindrome1(String s) {
        if (s.length() == 0 || s.length() == 1){
            return s;
        }else {
            String result = "";
            String temp = "";
            int maxlength = 0;
            for (int i=0;i<s.length();i++){
                for (int j=i;j<s.length();j++){
                    temp += s.charAt(j);
                    if (isPalindrome(temp)){
                        if (temp.length()>maxlength){
                            result = temp;
                            maxlength = temp.length();
                        }
                    }
                }
                temp = "";
            }
            return result;
        }
    }
// 动态规划
    public String longestPalindrome2(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String result = new LongestPalindromeSubString().longestPalindrome2("adssd");
        System.out.println(result);
    }
}
