package scu.edu.cn.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 解数独
 * @author: zzy
 * @create: 2021-01-10 15:53
 **/
public class SolveSudoku {
    private boolean[][] line = new boolean[9][9];
    private boolean[][] column = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<int[]>();

    //递归 + 回溯的方法枚举所有可能的填法。

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    //记录待填充的位置
                    spaces.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '0' - 1;
                    //已有的数据的位置设为true
                    //line[i][digit] 代表第i+1行的数字digit+1是否出现 例如line[2,4] 第三行的数字5
                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                }
            }
        }
        //pos代表已经填充了的个数
        dfs(board, 0);
    }

    public void dfs(char[][] board, int pos) {
        //如果已经填充满则结束
        if (pos == spaces.size()) {
            valid = true;
            return;
        }

        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        //使用0-8代表1-9
        for (int digit = 0; digit < 9; ++digit) {
            if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);
                dfs(board, pos + 1);
                if (valid){
                    return;
                }
                // 当前填充无效，进行下一轮填充
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }
    }
}
