package scu.edu.cn.offer;

/**
 * @program: leetcode
 * @description: 斐波那契数列
 * @author: zzy
 * @create: 2021-03-25 16:25
 **/
public class FibonacciSequence {
    public static void main(String[] args) {
        System.out.println(fib(48));
    }
    public static int fib(int n){
        if(n == 0 || n == 1) return n;
        int[] dp = new int[3];
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 2; i < n; i++){
            dp[0]=dp[1];
            dp[1]=dp[2];
            dp[2]=(dp[0]+dp[1])%1000000007;
        }
        return dp[2];
    }

    public static int fib2(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        return (fib(n-1)+fib(n-2))%1000000007;
    }

    public static int fib3(int n) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) ;
            a = b;
            b = sum;
        }
        return a% 1000000007;
    }
}
