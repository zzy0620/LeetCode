package scu.edu.cn.datastructure.algorithm;

import java.util.Arrays;

/**
 * @program: DataStructures
 * @description: Prim算法解决修路问题
 * @author: zzy
 * @create: 2021-03-17 09:24
 **/
public class Prim {

    public static void main(String[] args) {
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int verx = data.length;
        //10000表示两个点不连通
        int[][] weight = new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000}
        };
        MGraph mGraph = new MGraph(verx);
        MinTree minTree = new MinTree();
        minTree.createGraph(mGraph,verx,data,weight);
//        minTree.showGraph(mGraph);
        minTree.prim(mGraph,1);
    }
}

class MinTree{
    public void createGraph(MGraph graph,int verxs,char[] data,int[][] weight){
        int i,j;
        for (i=0;i<verxs;i++){
            graph.data[i] = data[i];
            for (j=0;j<verxs;j++){
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void showGraph(MGraph graph){
        for (int[] row:graph.weight) {
            System.out.println(Arrays.toString(row));
        }
    }
    //graph：图 v：表示从第几个顶点开始生成 A->0;B->1
    public void prim(MGraph graph,int v){
        //标记节点时候被访问过;1表示访问，0表示未访问
        int[] visited = new int[graph.verx];
        visited[v] = 1;
        //记录两个顶点下标
        int v1 = -1;
        int v2 = -1;

        int minWeight = 10000;
        for (int k = 1; k < graph.verx; k++) { // 有verx个点，结束后会生成verx-1条边
            for (int i = 0; i < graph.verx; i++) { // i已访问过的节点
                for (int j = 0; j < graph.verx; j++) { // j未访问的节点

                    //找到 访问过的节点 与 未访问的节点 间权值最小的两条边
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight){
                        minWeight = graph.weight[i][j];
                        v1 = i;
                        v2 = j;
                    }
                }
            }
            System.out.println("边<"+graph.data[v1]+","+graph.data[v2]+"> 权值:"+minWeight);
            visited[v2] = 1;
            minWeight = 10000;
        }
    }
}

class MGraph{
    int verx; //表示图的节点个数
    char[] data; //存放节点数据
    int[][] weight; // 存放边

    public MGraph(int verx) {
        this.verx = verx;
        data = new char[verx];
        weight = new int[verx][verx];
    }
}
