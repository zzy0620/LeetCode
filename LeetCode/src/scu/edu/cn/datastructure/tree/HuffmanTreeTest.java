package scu.edu.cn.datastructure.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: DataStructures
 * @description: 哈夫曼树
 * @author: zzy
 * @create: 2021-03-11 14:18
 **/
public class HuffmanTreeTest {

    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        WNode root = creatHuffmanTree(arr);
        preOrder(root);
    }

    public static WNode creatHuffmanTree(int[] arr) {
        //为了操作方便，将arr数组转为List
        List<WNode> list = new ArrayList<>();
        for (int i:arr) {
            list.add(new WNode(i));
        }
        while (list.size() > 1){
            //将节点从小到大排序
            Collections.sort(list);
            //在森林中选出两个根结点的权值最小的树合并
            WNode left = list.get(0);
            WNode right = list.get(1);
            WNode root = new WNode(left.value+right.value);
            root.left = left;
            root.right = right;
            //从森林中删除选取的两棵树，并将新树加入森林
            list.remove(left);
            list.remove(right);
            list.add(root);
        }
        return list.get(0);
    }

    public static void preOrder(WNode node){
        if (node == null){
            return;
        }
        System.out.println(node.value);
        if (node.left != null){
            preOrder(node.left);
        }
        if (node.right != null){
            preOrder(node.right);
        }
    }

}

//实现Comparable接口是便于排序
class WNode implements Comparable<WNode>{
    int value;//节点权值
    WNode left;//左子节点
    WNode right;//右子节点

    @Override
    public int compareTo(WNode o) {
        return (this.value - o.value);
    }

    public WNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "node{" +
                "value=" + value +
                '}';
    }
}
