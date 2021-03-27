package scu.edu.cn.datastructure.algorithm;

/**
 * @program: DataStructures
 * @description: 背包问题
 * @author: zzy
 * @create: 2021-03-15 15:57
 **/
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1,4,3}; //物品重量
        int[] v = {1500,3000,2000}; //物品价值
        int m = 4; //背包容量

        //多加一行一列的意思时，当物品为0时，不管背包容量为多少，价值都为0
        //当背包容量为0时，不管物品有多少，价值都为0
        int[][] dp = new int[w.length+1][m+1];

        for (int i=1;i<w.length+1;i++){
            for (int j = 1; j < m+1; j++) {
                if (w[i-1] > j){//i-1是因为i是从1开始的
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],v[i-1]+dp[i-1][j-w[i-1]]);
                }
            }
        }

        for (int[] row:dp) {
            for(int data:row){
                System.out.printf("%d \t",data);
            }
            System.out.println();
        }
    }
}
