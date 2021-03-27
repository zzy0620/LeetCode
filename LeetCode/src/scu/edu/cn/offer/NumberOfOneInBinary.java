package scu.edu.cn.offer;

/**
 * @program: leetcode
 * @description: 二进制中1的个数
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2
 * 位是 1。因此，如果输入 9，则该函数输出 2。
 * @author: zzy
 * @create: 2021-03-25 20:44
 **/
public class NumberOfOneInBinary {
    public static void main(String[] args) {
        System.out.println(hammingWeight(00000000000000000000000000001011));
    }
    public static int hammingWeight(int n) {
        String ss = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < ss.length(); i++) {
            if (ss.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }
    public int hammingWeight2(int n) {
        int res = 0;
        while(n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

}
