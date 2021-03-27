package scu.edu.cn.datastructure.algorithm;

import java.util.Arrays;

/**
 * @program: DataStructures
 * @description: 迪杰斯特拉算法
 * @author: zzy
 * @create: 2021-03-18 09:29
 **/
public class Dijkstra {
    private static final int INF = 65535;
    public static void main(String[] args) {
        char[] vertex = {'A','B','C','D','E','F','G'};
        int[][] weight = new int[][]{
                {INF,5,7,INF,INF,INF,2},
                {5,INF,INF,9,INF,INF,3},
                {7,INF,INF,INF,8,INF,INF},
                {INF,9,INF,INF,INF,4,INF},
                {INF,INF,8,INF,INF,5,4},
                {INF,INF,INF,4,5,INF,6},
                {2,3,INF,INF,4,6,INF}
        };
        Graph graph = new Graph(vertex,weight);
        graph.dijkstra(6);
        graph.showResult();
    }
}

class VisitedVertex{
    private int[] already_arr; //记录各顶点是否访问过
    private int[] pre_visited; //每个下标对应的前一个下边
    private int[] dis; // 从出发点到各顶点的距离

    //length 顶点的个数; index 出发顶点对应的下标
    public VisitedVertex(int length,int index) {
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];
        Arrays.fill(dis,65535);
        dis[index] = 0;
        already_arr[index] = 1;
    }

    //判断index为下标的顶点是否访问过
    public boolean isVisited(int index){
        return already_arr[index] == 1;
    }

    //更新出发顶点到index下标对应的顶点的居离;len 距离
    public void updateDis(int index,int len){
        dis[index] = len;
    }

    //跟新index下标对应的顶点的前驱为pre下标对应的节点
    public void updatePre(int index,int pre){
        pre_visited[index] = pre;
    }

    //返回出点顶点到index对应顶点的距离
    public int gerDis(int index){
        return dis[index];
    }

    //继续选择并返回新的访问顶点
    public int updateArr(){
        int min = Integer.MAX_VALUE,index = 0;
        for (int i = 0;i<already_arr.length;i++){
            if (already_arr[i] == 0 && dis[i] < min){
                min = dis[i];
                index = i;
            }
        }
        already_arr[index] = 1; //更新index为访问过
        return index;
    }

    public void show(){
        System.out.println(Arrays.toString(already_arr));
        System.out.println(Arrays.toString(pre_visited));
        System.out.println(Arrays.toString(dis));
    }

}

class Graph{
    private char[] vertex;//顶点数组
    private int[][] matrix; //邻接矩阵
    private VisitedVertex vv;

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    //index:出发顶点对应的下标
    public void dijkstra(int index){
        vv = new VisitedVertex(vertex.length,index);
        update(index);
        for (int j=1;j<vertex.length;j++){
            index = vv.updateArr();
            update(index);
        }
    }

    //更新index下标顶点到周围顶点的距离和周围顶点的前驱结点
    private void update(int index){
        int len = 0; //出发顶点到index顶点的距离 + 从index出发到j顶点的距离
        for (int j = 0; j < matrix[index].length ; j++) {
            len = vv.gerDis(index) + matrix[index][j];
            if (!vv.isVisited(j) && len < vv.gerDis(j)){
                //j对应的顶点没有被访问过并且len小于出发顶点到j顶点的距离，就需要更新
                vv.updatePre(j,index); //更新j顶点的前驱节点为index
                vv.updateDis(j,len); //更新出发顶点到j对应的顶点的距离
            }
        }
    }

    public void show(){
        for (int[] row:matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public void showResult(){
        vv.show();
    }
}
