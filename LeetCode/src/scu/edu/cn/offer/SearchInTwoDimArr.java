package scu.edu.cn.offer;

/**
 * @program: leetcode
 * @description: 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @author: zzy
 * @create: 2021-03-25 13:49
 **/
public class SearchInTwoDimArr {
    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}};
        int[][] matrix = {{}};
        System.out.println(findNumberIn2DArray(matrix, 20));
    }
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        //思路：从矩阵的右上角开始查找
        //如果当前数字等于target，返回
        //如果当前数字小于target，往下找
        //如果当前数字大于target，往右找
        if (matrix == null || matrix.length==0 || (matrix.length==1&&matrix[0].length==0)){
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        if (matrix[0][0] > target || matrix[rows-1][columns-1] < target){
            //剪枝
            return false;
        }
        int row = 0;
        int column = columns-1;
        while (row<rows && column>=0){
            int num = matrix[row][column];
            if (num == target){
                return true;
            }else if (num < target){
                row++;
            }else {
                column--;
            }
        }
        return false;
    }
}
