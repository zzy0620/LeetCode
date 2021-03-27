package scu.edu.cn.datastructure.algorithm;

import java.util.Arrays;

/**
 * @program: DataStructures
 * @description: 克鲁斯卡尔解决最小生成树
 * @author: zzy
 * @create: 2021-03-17 14:16
 **/
public class Kruskal {
    private int edgeNum; //边的个数
    private char[] vertexs; //顶点
    private int[][] matrix; //邻接矩阵
    private static final int INF = Integer.MAX_VALUE;

    public Kruskal(char[] vertexs, int[][] matrix) {
        this.vertexs = vertexs;
        this.matrix = matrix;
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i+1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF){
                    edgeNum++;
                }
            }
        }
    }

    public void print(){
        System.out.println("邻接矩阵为:");
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                if (matrix[i][j] == INF){
                    System.out.print("INF\t");
                }else{
                    System.out.printf("%d\t",matrix[i][j]);
                }
            }
            System.out.println();
        }
    }

    //对边进行排序，按照边的权值大小
    private void sortEdges(EData[] edges){
        for (int i = 0; i < edges.length-1; i++) {
            for (int j = 0; j < edges.length-i-1; j++) {
                if (edges[j].weight > edges[j+1].weight){
                    EData temp = edges[j];
                    edges[j] = edges[j+1];
                    edges[j+1] = temp;
                }
            }
        }
    }

    //传入一个顶点的值，返回对应的下标
    private int getPosition(char ch){
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch){
                return i;
            }
        }
        return -1;
    }

    //获取图中的边
    public EData[] getEdges(){
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            //这是一个对称矩阵，因此只需要从i+1开始即可
            for (int j = i+1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF){
                    edges[index++] = new EData(vertexs[i],vertexs[j],matrix[i][j]);
                }
            }
        }
        return edges;
    }

    //获取下标为i的顶点的终点的下标
    //ends数组 记录了每条边的顶点对应的另外一个点
    private int getEnd(int[] ends,int i){
        //while循环的原因是 例如A->B  B->C
        //A的终点就是C，进行遍历，先找到B再找到C
        while (ends[i] != 0){
            i = ends[i];
        }
        return i;
    }

    public void kruskal(){
        int index = 0; //表示结果数组的索引
        int[] ends = new int[vertexs.length]; //用于保存"已有最小生成树"中每个顶点在最小生成树中的终点
        EData[] results = new EData[edgeNum];
        EData[] edges = getEdges(); //图中边的集合
        sortEdges(edges);
        for (int i=0;i<edgeNum;i++){
            EData edge = edges[i];
            int start = getPosition(edge.start);
            int end = getPosition(edge.end);
            int m = getEnd(ends,start);
            int n = getEnd(ends,end);
            //不构成回路
            if (m!=n){
                //设置m在"已有最小生成树中的"终点
                ends[m] = n;
                results[index++] = edges[i];
            }
        }
        System.out.println(Arrays.toString(ends));
        System.out.println(Arrays.toString(results));
    }

    public static void main(String[] args) {
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int[][] weight = new int[][]{
                {0,12,INF,INF,INF,16,14},
                {12,0,10,INF,INF,7,INF},
                {INF,10,0,3,5,6,INF},
                {INF,INF,3,0,4,INF,INF},
                {INF,INF,5,4,0,2,8},
                {16,7,6,INF,2,0,9},
                {14,INF,INF,INF,8,9,0}
        };
        Kruskal kruskal = new Kruskal(data,weight);
        kruskal.kruskal();
    }
}

//实例表示一条边
class EData{
    char start; //边的一个点
    char end;  //边的另一个点
    int weight;

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "<"+ start +
                "->" + end +
                ", weight=" + weight +
                '>';
    }
}
