package scu.edu.cn.datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: DataStructures
 * @description: 图的创建
 * @author: zzy
 * @create: 2021-03-13 14:19
 **/
public class Graph {
    private List<String> vertexList; //存储顶点集合
    private int[][] edges; //存储图对应的邻接矩阵
    private int numOfEdges;//表示边的数目
    private boolean[] isVisited; //表示是否被访问

    public Graph(int n){
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    //得到第一个邻接节点的下标
    public int getFirstNeighbor(int index){
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0){
                return i;
            }
        }
        return -1;
    }
    //根据前一个邻接节点的下标来获取下一个邻接节点
    public int getNextNeighbor(int v1,int v2){
        for (int i = v2+1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0){
                return i;
            }
        }
        return -1;
    }

    public void bfs(){
        for (int i=0;i<getNumOfVertex();i++){
            if (!isVisited[i]){
                bfs(i);
            }
        }
    }

    public void bfs(int i){
        int u; //队列头结点对应的下标
        int w; //邻接节点w
        //队列记录访问节点信息
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.println(getValueByIndex(i));
        isVisited[i] = true;
        queue.addLast(i);
        while (!queue.isEmpty()){
            u = queue.removeFirst();
            w = getFirstNeighbor(u);
            while (w != -1){
                if (!isVisited[w]){
                    System.out.println(getValueByIndex(w));
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighbor(u,w);
            }
        }
    }

    public void dfs(int i){
        System.out.println(getValueByIndex(i)+"->");
        isVisited[i] = true;
        //查找节点i的第一个邻接点
        int w = getFirstNeighbor(i);
        if (w != -1){
            if (!isVisited[w]){
                dfs(w);
            }
            w = getNextNeighbor(i,w);
        }
    }

    public void dfs(){
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                dfs(i);
            }
        }
    }

    //返回节点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }

    //返回边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }

    //返回节点i对应的值
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    //返回v1和v2的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    //显示图对应的矩阵
    public void showGraph(){
        for (int[] links:edges) {
            for (int weight:links) {
                System.out.printf("%d \t",weight);
            }
            System.out.println();
        }
    }

    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    //v1，v2表示点的下标，即第几个顶点
    //weight :边的权重
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    public static void main(String[] args) {
        int n = 5;
        String[] vertexValue = {"A","B","C","D","E"};
        Graph graph = new Graph(n);
        for (String value:vertexValue) {
            graph.insertVertex(value);
        }
        graph.insertEdge(0,1,1); //A-B
        graph.insertEdge(0,2,1); //A-C
        graph.insertEdge(1,2,1); //B-C
        graph.insertEdge(1,3,1); //B-D
        graph.insertEdge(1,4,1); //B-E

//        graph.showGraph();
        graph.bfs();
    }
}
