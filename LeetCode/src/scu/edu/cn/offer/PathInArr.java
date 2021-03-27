package scu.edu.cn.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径
 * @author: zzy
 * @create: 2021-03-25 18:41
 **/
public class PathInArr {
    public static void main(String[] args) {
//        char[][] board = {
//            {'a','b','c','e'},
//            {'s','f','c','s'},
//            {'a','d','e','e'}};
//        String word = "bfce";
        char[][] board = {
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'}
        };
        String word = "AAB";

        System.out.println(new PathInArr().exist(board, word));
    }
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int column = board[0].length;
        boolean[][] visited = new boolean[row][column];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)){
                    boolean flag = dfs(board,visited,1,word,new int[]{i,j});
                    if (flag){
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    //规定：搜索方式为 右-下-左-上
    public boolean dfs(char[][] board,boolean[][] visited,int index,String word,int[] location){
        if (index == word.length()){
            return true;
        }
        int row = location[0];
        int column = location[1];
        boolean flag;
        visited[row][column] = true;
        //向左访问
        if (column + 1 < board[0].length){
            if (!visited[row][column+1] && board[row][column+1] == word.charAt(index)){
                flag = dfs(board,visited,index+1,word,new int[]{row,column + 1});
                if (flag) return true;
                visited[row][column+1] = false;
            }
        }
        //向下访问
        if (row+1<board.length){
            if (!visited[row+1][column] && board[row+1][column] == word.charAt(index)){
                flag = dfs(board,visited,index+1,word,new int[]{row+1,column});
                if (flag) return true;
                visited[row+1][column] = false;
            }
        }
        //向左访问
        if (column-1 >=0 ){
            if (!visited[row][column-1] && board[row][column-1] == word.charAt(index)){
                flag = dfs(board,visited,index+1,word,new int[]{row,column - 1});
                if (flag) return true;
                visited[row][column-1] = false;
            }
        }
        //向上访问
        if (row-1>=0){
            if (!visited[row-1][column] && board[row-1][column] == word.charAt(index)){
                flag = dfs(board,visited,index+1,word,new int[]{row-1,column});
                if (flag) return true;
                visited[row-1][column] = false;
            }
        }
        return false;
    }
}
