package scu.edu.cn.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 有效的数独
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 * @author: zzy
 * @create: 2021-01-09 17:07
 **/
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Map<Character,Integer> map = new HashMap<>();
        //判断每行是否重复
        for (int i=0;i<9;i++){
            int num = 0;
            for (int j=0;j<9;j++){
                if (board[i][j] != '.'){
                    num++;
                    map.put(board[i][j],1);
                }
            }
            if (map.size() < num){
                return false;
            }
            map.clear();
        }
        //判断每列是否重复
        for (int m=0;m<9;m++){
            int num = 0;
            for (int n=0;n<9;n++){
                if (board[n][m] != '.'){
                    num++;
                    map.put(board[n][m],1);
                }
            }
            if (map.size() < num){
                return false;
            }
            map.clear();
        }
        //判断3X3宫格中是否重复出现
        int row = 2;
        while (row<9){
            int column = 2;
            while (column<9){
                int num = 0;
                for (int m=row-2;m<=row;m++){
                    for (int n=column-2;n<=column;n++){
                        if (board[m][n] != '.'){
                            num++;
                            map.put(board[m][n],1);
                        }
                    }
                }
                if (map.size() < num){
                    return false;
                }
                column += 3;
                map.clear();
            }
            row += 3;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] sudoku= new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},{'6', '.', '.', '1', '9', '5', '.', '.', '.'},{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},{'4', '.', '.', '8', '.', '3', '.', '.', '1'},{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},{'.', '.', '.', '4', '1', '9', '.', '.', '5'},{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(new ValidSudoku().isValidSudoku(sudoku));
    }
}
