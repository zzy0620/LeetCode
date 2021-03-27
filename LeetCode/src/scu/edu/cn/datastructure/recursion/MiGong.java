package scu.edu.cn.datastructure.recursion;

/**
 * @program: DataStructures
 * @description:
 * @author: zzy
 * @create: 2021-03-07 13:07
 **/
public class MiGong {
    //用二维数组模拟地图 1表示墙
    private static int[][] map = new int[8][7];

    public static void main(String[] args) {
        //初始化迷宫
        for (int i=0;i<7;i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(" " + map[i][j]);
            }
            System.out.println();
        }

        setWay(map,1,1);
        System.out.println("=============================");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(" " + map[i][j]);
            }
            System.out.println();
        }
    }

    //map表示地图 (i,j)从哪个位置开始找
    //如果小球能到达迷宫的右下角(6,5)代表通路找到了
    //约定：当map[i][j]为0代表没有走过 为1代为是墙 为2代表是通路可以走，为3表示改点已经走过，走不通
    //走迷宫时需要确定策略：下→右→上→左，如果走不通再回溯
    public static boolean setWay(int[][] map,int i,int j){
        if (map[6][5] == 2){
            return true;
        }else {
            if (map[i][j] == 0){ //当前的点没有走过
                map[i][j] = 2;
                if (setWay(map,i+1,j)){ //向下走
                    return true;
                }else if (setWay(map,i,j+1)){//向右走
                    return true;
                }else if (setWay(map,i-1,j)){//向上走
                    return true;
                }else if (setWay(map,i,j-1)){//向左走
                    return true;
                }else {
                    //如果下右上左都走不通，说明是死路，置为3
                    map[i][j] = 3;
                    return false;
                }
            }else { //map[i][j]可能为1,2,3
                //按照之前的规则，从这个点开始的路走不通
                return false;
            }
        }
    }
}
