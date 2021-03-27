package scu.edu.cn.offer;

/**
 * @program: leetcode
 * @description: 青蛙跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法
 * @author: zzy
 * @create: 2021-03-25 16:53
 **/
public class FrogJumpsSteps {
    public static void main(String[] args) {
        System.out.println(numWays(7));
    }
    public static int numWays(int n) {
        if (n == 0) return 1;
        if (n == 1 || n == 2) return n;
        int[] dp = new int[3];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = (dp[0]+dp[1])%1000000007;
        }
        return dp[2];
    }
}
