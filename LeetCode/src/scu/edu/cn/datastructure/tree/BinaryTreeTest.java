package scu.edu.cn.datastructure.tree;

/**
 * @program: DataStructures
 * @description: 二叉树
 * @author: zzy
 * @create: 2021-03-10 14:03
 **/
public class BinaryTreeTest {

    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1,"宋江");
        HeroNode heroNode2 = new HeroNode(2,"吴用");
        HeroNode heroNode3 = new HeroNode(3,"卢俊义");
        HeroNode heroNode4 = new HeroNode(4,"林冲");
        heroNode1.setLeft(heroNode2);
        heroNode1.setRight(heroNode3);
        heroNode3.setRight(heroNode4);
        BinaryTree binaryTree = new BinaryTree(heroNode1);

        System.out.println(binaryTree.preOrderSearch(1));
        System.out.println("============================");
        System.out.println(binaryTree.infixOrderSearch(1));
        System.out.println("============================");
        System.out.println(binaryTree.postOrderSearch(1));
    }
}

class BinaryTree{
    private HeroNode root;

    public BinaryTree(HeroNode root) {
        this.root = root;
    }

    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public void infixOrder(){
        if (this.root != null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public HeroNode preOrderSearch(int no){
        if (this.root != null){
            return this.root.preOrderSearch(no);
        }else {
            System.out.println("二叉树为空");
            return null;
        }
    }

    public HeroNode infixOrderSearch(int no){
        if (this.root != null){
            return this.root.infixOrderSearch(no);
        }else {
            System.out.println("二叉树为空");
            return null;
        }
    }

    public HeroNode postOrderSearch(int no){
        if (this.root != null){
            return this.root.postOrderSearch(no);
        }else {
            System.out.println("二叉树为空");
            return null;
        }
    }
}

class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder(){
        if (this.left != null){
            this.left.postOrder();
        }
        if (this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no){
        System.out.println("进入前序遍历");
        if (this.no == no){
            return this;
        }
        HeroNode heroNode = null;
        if (this.left != null){
            heroNode = this.left.preOrderSearch(no);
        }
        if (heroNode != null){
            return heroNode;
        }
        if (this.right != null){
            heroNode = this.right.preOrderSearch(no);
        }
        return heroNode;
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no){
        HeroNode heroNode = null;
        if (this.left != null){
            heroNode = this.left.infixOrderSearch(no);
        }
        if (heroNode != null){
            return heroNode;
        }
        System.out.println("进入中序查找");
        if (this.no == no){
            return this;
        }
        if (this.right != null){
            heroNode = this.right.infixOrderSearch(no);
        }
        return heroNode;
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no){
        HeroNode heroNode = null;
        if (this.left != null){
            heroNode = this.left.postOrderSearch(no);
        }
        if (heroNode != null){
            return heroNode;
        }
        if (this.right != null){
            heroNode = this.right.postOrderSearch(no);
        }
        if (heroNode != null){
            return heroNode;
        }
        System.out.println("进入后续遍历");
        if (this.no == no){
            return this;
        }
        return null;
    }
}