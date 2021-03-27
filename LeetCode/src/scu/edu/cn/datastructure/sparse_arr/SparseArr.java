package scu.edu.cn.datastructure.sparse_arr;

/**
 * @program: DataStructures
 * @description: 二维数组和稀疏数组相互转化
 * @author: zzy
 * @create: 2021-03-05 10:54
 **/
public class SparseArr {
    public static void main(String[] args) {
        //创建二维数组
        //0:没有棋子 1:黑子 2:蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //打印原始数组
        for (int row[] : chessArr1) {
            for (int data:row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //遍历二维数组得到非0数据
        int num = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j]!=0){
                    num++;
                }
            }
        }
        //创建对应的稀疏数组
        int[][] sparseArr = new int[num+1][3];
        //初始化稀疏数组
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = num;

        //遍历二维数组将非0数组存放在稀疏数组中
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j]!=0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        //打印稀疏数组
        for (int row[] : sparseArr) {
            for (int data:row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //将稀疏数组恢复为二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i=1;i<sparseArr.length;i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        //打印恢复后的二维数组
        for (int row[] : chessArr2) {
            for (int data:row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
