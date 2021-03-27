package scu.edu.cn.datastructure.algorithm;

import java.util.Arrays;

/**
 * @program: DataStructures
 * @description: 弗洛伊德解决最短路径
 * @author: zzy
 * @create: 2021-03-18 11:05
 **/
public class Floyd {
    private static final int INF = 65535;
    public static void main(String[] args) {
        char[] vertex = {'A','B','C','D','E','F','G'};
        int[][] weight = new int[][]{
                {0,5,7,INF,INF,INF,2},
                {5,0,INF,9,INF,INF,3},
                {7,INF,0,INF,8,INF,INF},
                {INF,9,INF,0,INF,4,INF},
                {INF,INF,8,INF,0,5,4},
                {INF,INF,INF,4,5,0,6},
                {2,3,INF,INF,4,6,0}
        };
        FGraph graph = new FGraph(weight,vertex);
        graph.floyd();
        graph.show();
    }
}

class FGraph{
    private char[] vertex;
    private int[][] dis; //保留各个顶点到其他顶点的距离
    private int[][] pre; //保存到达目标顶点的前驱结点

    public FGraph(int[][] matrix,char[] vertex) {
        this.vertex = vertex;
        dis = matrix;
        pre = new int[vertex.length][vertex.length];
        for (int i=0; i<vertex.length;i++) {
            Arrays.fill(pre[i],i);
        }
    }

    public void show(){
        System.out.println("距离");
        for (int[] row:dis) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("前驱");
        for (int[] row:pre) {
            System.out.println(Arrays.toString(row));
        }
    }

    public void floyd(){
        int len = 0;
        for (int k = 0; k < vertex.length; k++) { //k:中间顶点
            for (int i = 0; i < vertex.length; i++) { //i:出发顶点
                for (int j = 0; j < vertex.length; j++) { //j:结束顶点
                    len = dis[i][k] + dis[k][j]; //从i顶点出发，经过k中间顶点，到达j顶点
                    if (len <dis[i][j]){
                        dis[i][j] = len; //更新距离
                        pre[i][j] = pre[k][j];//更新前驱顶点
                    }
                }
            }
        }
    }
}