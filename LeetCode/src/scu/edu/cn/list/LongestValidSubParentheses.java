package scu.edu.cn.list;

import java.util.Arrays;
import java.util.Stack;

/**
 * @program: leetcode
 * @description: 最长有效括号
 * @author: zzy
 * @create: 2020-12-07 17:19
 **/

//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
//
//    示例 1:
//          输入: "(()"
//          输出: 2
//          解释: 最长有效括号子串为 "()"
public class LongestValidSubParentheses {
//    动态规划
    public int longestValidParentheses(String s) {
        int result = 0;
        if ( s==null || s.length() == 0){
            return result;
        }
//        定义 dp[i]表示以下标i字符结尾的最长有效括号的长度
        int[] dp = new int[s.length()];
        char[] arr = s.toCharArray();
//        有效括号的长度必定大于1，因此从1开始
        for (int i=1;i<arr.length;i++){
//          以（结尾的字串不可能形成有效括号，因此有效括号字串一定是以）结束。
            if (arr[i] == ')'){
//              第一种情况是下标i-1对应的元素为(,形成有效括号字串()，因此 dp[i] = dp[i-2] + 2. 注意i-2越界问题
                if (arr[i-1] == '('){
                    dp[i] = (i>=2?dp[i-2]:0)+2;
                }else {
//                  第二种是下标i-1对应的元素为),那么字串的情况为 ...)),如果 i-1下标对应的字串不是有效括号字串
//                  那么dp[i-1] = 0,此时dp[i-dp[i-1]-1]对应的元素是是),那么不能形成有效字串。
//                  如果i-1形成有效字串，i-dp[i-1]-1对应的元素为(,那么可以形成(...))的有效字串,dp[i] = dp[i-1]+2，
//                  这个时候要考虑i-dp[i-1]-2对应的字串是不是一个有效字串，因此dp[i] = dp[i-1]+2+dp[i-dp[i-1]-2]
                    if (i-dp[i-1] > 0 && arr[i-dp[i-1]-1] == '('){
                        dp[i] = dp[i-1] + 2 +  (i - dp[i-1] -2 > 0 ? dp[i - dp[i-1] -2] : 0);
                    }
                }
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String ss= "()(()";
        System.out.println(new LongestValidSubParentheses().longestValidParentheses(ss));
    }


}
