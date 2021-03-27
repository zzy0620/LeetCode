package scu.edu.cn.offer;

/**
 * @program: leetcode
 * @description: 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * @author: zzy
 * @create: 2021-03-25 20:57
 **/
public class printMaxNNumFromOne {
    public static void main(String[] args) {

    }
    public static int[] printNumbers(int n) {
        int num = (int) (Math.pow(10,n)-1);
        int[] res = new int[num];
        for (int i = 0; i < num; i++) {
            res[i] = i+1;
        }
        return res;
    }
}
