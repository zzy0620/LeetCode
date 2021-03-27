package scu.edu.cn.datastructure.tree;

/**
 * @program: DataStructures
 * @description: 顺序存储二叉树
 * @author: zzy
 * @create: 2021-03-10 19:27
 **/
public class ArrayBinaryTreeTest {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.preOrder(0);
        System.out.println("========================");
        arrayBinaryTree.infixOrder(0);
        System.out.println("========================");
        arrayBinaryTree.postOrder(0);
    }
}

class ArrayBinaryTree{
    private int[] arr;//存储数据节点的数组

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //完成顺序二叉树的前序遍历
    //index 数组的下标
    public void preOrder(int index){
        if (arr == null || arr.length==0 ){
            System.out.println("数组为空");
        }
        System.out.println(arr[index]);
        //向左遍历
        if (2*index+1 < arr.length){
            preOrder(2*index+1);
        }
        if (2*index+2 < arr.length){
            preOrder(2*index+2);
        }
    }

    public void infixOrder(int index){
        if (arr == null || arr.length==0 ){
            System.out.println("数组为空");
        }
        //向左遍历
        if (2*index+1 < arr.length){
            infixOrder(2*index+1);
        }
        System.out.println(arr[index]);
        if (2*index+2 < arr.length){
            infixOrder(2*index+2);
        }
    }

    public void postOrder(int index){
        if (arr == null || arr.length==0 ){
            System.out.println("数组为空");
        }
        //向左遍历
        if (2*index+1 < arr.length){
            postOrder(2*index+1);
        }
        if (2*index+2 < arr.length){
            postOrder(2*index+2);
        }
        System.out.println(arr[index]);
    }
}

