package scu.edu.cn.list;

/**
 * @program: leetcode
 * @description: 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * @author: zzy
 * @create: 2020-11-23 21:22
 **/
public class TwoNumDivide {

    public int divide(int dividend, int divisor) {
        // 当除数为1，直接返回被除数
        if (divisor == 1) {
            return dividend;
        }
        // 当除数为-1且被除数为Integer.MIN_VALUE时，将会溢出，返回Integer.MAX_VALUE
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        // 把被除数与除数调整为正数,为防止被除数Integer.MIN_VALUE转换为正数会溢出，使用long类型保存参数
        if (dividend < 0 && divisor < 0) {
            return divide(-(long) dividend, -(long) divisor);
        } else if (dividend < 0 || divisor < 0) {
            return -divide(Math.abs((long) dividend), Math.abs((long) divisor));
        } else {
            return divide((long) dividend, (long) divisor);
        }
    }

    public int divide(long dividend, long divisor) {
        // 如果被除数小于除数，结果明显为0
        if (dividend < divisor) {
            return 0;
        }
        long sum = divisor; // 记录用了count个divisor的和
        int count = 1; // 使用了多少个divisor
        while (dividend >= sum) {
            // 每次翻倍
            sum <<= 1;
            count <<= 1;
        }

        // 此时dividend < sum    >>>无符号移位，左边直接补0
        sum >>>= 1;
        count >>>= 1;

        // 此时dividend >= sum
        // 将count个divisor从dividend消耗掉，剩下的还需要多少个divisor交由递归函数处理
        return count + divide(dividend - sum, divisor);
    }

    public static void main(String[] args) {
        System.out.println(new TwoNumDivide().divide(-9,2));
    }
}
