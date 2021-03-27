package scu.edu.cn.datastructure.tree;

/**
 * @program: DataStructures
 * @description: 线索二叉树
 * @author: zzy
 * @create: 2021-03-10 19:56
 **/
public class ThreadedBinaryTreeTest {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(6);
        Node node4 = new Node(8);
        Node node5 = new Node(10);
        Node node6 = new Node(14);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree(node1);
//中序
//        threadedBinaryTree.infixThreadedNodes(node1);
//        Node leftNode  = node5.getLeft();
//        System.out.println(leftNode);
//        Node rightNode  = node5.getRight();
//        System.out.println(rightNode);
//        System.out.println("=========================");
//        threadedBinaryTree.threadedList();
//前序
        threadedBinaryTree.preThreadedNodes(node1);
        threadedBinaryTree.preThreadedList();
//后序
//        node2.setParent(node1);
//        node3.setParent(node1);
//        node4.setParent(node2);
//        node5.setParent(node2);
//        node6.setParent(node3);
//        threadedBinaryTree.postThreadedNodes(node1);
//        threadedBinaryTree.postThreadedList();
    }
}

class ThreadedBinaryTree{
    private Node root;
    // 为了实现线索化，需要创建要指向当前节点的前驱节点的指针
    private Node pre = null;

    public ThreadedBinaryTree(Node root) {
        this.root = root;
    }

    //中序线索化二叉树
    public void infixThreadedNodes(Node node){
        //heroNode 当前需要线索化的节点
        if (node == null){
            return;
        }
        //线索化左子节点
        infixThreadedNodes(node.getLeft());
        //线索化当前节点
        if (node.getLeft() == null){
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //处理后继节点
        //因为当前节点还没有后继节点，因此需要退出本次迭代，进入到当前节点的后继节点
        //退出到当前节点的后继节点后，pre为当前节点，这个时候pre.next就能设置后继节点
        if (pre!=null && pre.getRight() == null){
            //让前驱节点的右指针指向当前节点
            pre.setRight(node);
            pre.setRightType(1);
        }
        //每处理一个节点后，让当前节点是下一个节点的前驱节点
        pre = node;
        //线索化右子节点
        infixThreadedNodes((node.getRight()));
    }

    //遍历中序线索化二叉树
    public void threadedList(){
        Node node = root;
        while (node !=null){
            //循环找到leftType==1的节点
            //因为leftType==1，说明该节点是按照线索化处理后的有效节点
            while (node.getLeftType()==0){
                node = node.getLeft();
            }
            //打印当前节点
            System.out.println(node);
            //如果当前节点的右指针是指向后继节点，就一直输出
            while (node.getRightType() == 1){
                node = node.getRight();
                System.out.println(node);
            }
            //替换这个遍历的节点
            node = node.getRight();
        }
    }

    //前序线索化二叉树
    public void preThreadedNodes(Node node){
        //heroNode 当前需要线索化的节点
        if (node == null){
            return;
        }
        if (node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre!=null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        if (node.getLeftType() == 0){
            preThreadedNodes(node.getLeft());
        }
        if (node.getRightType() == 0){
            preThreadedNodes(node.getRight());
        }
    }

    public void preThreadedNodes2(Node node){
        //heroNode 当前需要线索化的节点
        if (node == null){
            return;
        }
        if (node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre!=null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;

        preThreadedNodes(node.getLeft());
        preThreadedNodes(node.getRight());

    }

    //遍历前序线索化二叉树
    public void preThreadedList(){
        Node node = root;
        while (node !=null){
            System.out.println(node);
            while (node.getLeftType() == 0){
                node = node.getLeft();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }

    //后序线索化二叉树
    public void postThreadedNodes(Node node){
        if (node == null){
            return;
        }
        postThreadedNodes(node.getLeft());
        postThreadedNodes(node.getRight());
        if (node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre!=null&&pre.getRight()==null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
    }

    //遍历后序线索二叉树
    //遍历后序二叉树，需要知道当前节点的父节点
    public void postThreadedList(){
        Node node = root;
        while (node != null && node.getLeftType() == 0){
            node = node.getLeft();
        }
        Node preNode = node;//最后一个处理的节点

        while (node !=null){
           if (node.getRightType() == 1){
               System.out.println(node);
               preNode = node;
               node = node.getRight();
           }else {
               //如果上个节点处理的是当前节点的右节点
               if (node.getRight() == preNode){
                   System.out.println(node);
                   if (node == root){
                       return;
                   }
                   preNode = node;
                   node = node.getParent();
               }else {
                   //没有处理过，进入到右分支
                    node = node.getRight();
                    while (node != null && node.getLeftType() == 0){
                        node = node.getLeft();
                    }
               }
           }
        }
    }
}

class Node{
    private int no;
    private Node left;
    private Node right;
    // 规定 0：指向的是左子树 1：指向的是前驱节点
    private int leftType;
    // 规定 0：指向的是右子树 1：指向的是后继节点
    private int rightType;
    //后序线索化遍历需要
    private Node parent;
    private int value;

    public Node(int no) {
        this.no = no;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }
}


