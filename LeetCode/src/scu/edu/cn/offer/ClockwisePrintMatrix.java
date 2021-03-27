package scu.edu.cn.offer;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * @author: zzy
 * @create: 2021-03-27 14:57
 **/
public class ClockwisePrintMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
        };
        System.out.println(Arrays.toString(new ClockwisePrintMatrix().spiralOrder(matrix)));
    }
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 ||matrix[0].length == 0){
            return new int[0];
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int count = rows*columns;
        int[] result = new int[count];
        int left = 0;
        int right = columns;
        int top = 0;
        int bottom = rows;
        int index = 0;
        while (index < count){
            for (int i = left; i < right && index<count; i++) {
                result[index++] = matrix[top][i];
            }
            top++;
            for (int i = top; i < bottom && index<count; i++) {
                result[index++] = matrix[i][right-1];
            }
            right--;
            for (int i = right-1; i >= left && index<count ; i--) {
                result[index++] = matrix[bottom-1][i];
            }
            bottom--;
            for (int i = bottom-1; i >=top && index<count ; i--) {
                result[index++] = matrix[i][left];
            }
            left++;
        }
        return result;
    }
}
