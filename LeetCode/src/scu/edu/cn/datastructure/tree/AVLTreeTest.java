package scu.edu.cn.datastructure.tree;

/**
 * @program: DataStructures
 * @description: 平衡二叉树
 * @author: zzy
 * @create: 2021-03-12 19:50
 **/
public class AVLTreeTest {
    public static void main(String[] args) {
//        int[] arr = {4,3,6,5,7,8};
//        int[] arr = {10,12,8,9,7,6};
        int[] arr = {10,7,11,8,6,9};
        AVLTree avlTree = new AVLTree();
        for (int value : arr) {
            avlTree.add(new AVLNode(value));
        }
        System.out.println(avlTree.height());
        avlTree.infixOrder();
    }
}

class AVLTree{
    private AVLNode root;

    public AVLNode getRoot() {
        return root;
    }

    public void add(AVLNode node){
        if (root == null){
            root = node;
        }else {
            root.add(node);
        }
    }

    public void infixOrder(){
        if (root == null){
            return;
        }
        root.infixOrder();
    }

    public AVLNode searchNode(int value){
        if (root == null){
            return null;
        }
        return root.search(value);
    }

    public AVLNode searchParentNode(int value){
        if (root == null){
            return null;
        }
        return root.searchParent(value);
    }

    public void delNode(int value){
        if (root == null){
            return;
        }
        AVLNode target = searchNode(value);
        if (target == null){
            return;
        }
        if (root.left == null && root.right == null){
            root = null;
            return;
        }
        AVLNode parent = searchParentNode(value);

        if (target.left == null &&  target.right == null){//如果是叶子结点
            if (parent.left == target){
                parent.left = null;
            }else {
                parent.right = null;
            }
        }else if (target.left != null &&  target.right != null){
            AVLNode temp = target.right;
            while (temp.left != null){
                temp = temp.left;
            }
            int minValue = temp.value;
            delNode(temp.value);
            target.value = minValue;
        }else {
            if (target.left != null){
                if (parent != null){
                    if (parent.left.value == value){
                        parent.left = target.left;
                    }else {
                        parent.right = target.left;
                    }
                }else {
                    root = target.left;
                }

            }else {
                if (parent != null){
                    if (parent.left.value == value){
                        parent.left = target.right;
                    }else {
                        parent.right = target.right;
                    }
                }else {
                    root = target.right;
                }
            }
        }
    }

    public int height(){
        if (root == null){
            return 0;
        }
        return root.height();
    }
}

class AVLNode{
    int value;
    AVLNode left;
    AVLNode right;

    public AVLNode(int value) {
        this.value = value;
    }

    //返回当前节点的高度
    public int height(){
        return Math.max(left == null?0:left.height(),right == null?0:right.height())+1;
    }

    //左子树高度
    public int leftHeight(){
        if (left == null){
            return 0;
        }
        return left.height();
    }

    //右子树高度
    public int rightHeight(){
        if (right == null){
            return 0;
        }
        return right.height();
    }

    public void add(AVLNode node){
        if (node == null){
            return;
        }
        if (node.value < this.value){
            if (this.left == null){
                this.left = node;
            }else {
                this.left.add(node);
            }
        }else {
            if (this.right == null){
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
        if (rightHeight() - leftHeight() > 1){
            //如果当前节点的右子树的左子树的高度大于当前节点的右子树的右子树的高度
            //需要对当前节点的右子树进行右旋转再对当前节点进行左旋转
            if(right != null && right.leftHeight() > left.rightHeight()){
                right.rightRotate();
            }
            leftRotate();
            return;
        }
        if (leftHeight() - rightHeight() > 1){
            //如果当前节点的左子树的右子树的高度大于当前节点的左子树的左子树的高度
            //需要对当前节点的左子树进行左旋转再对当前节点进行右旋转
            if(left != null && left.rightHeight() > left.leftHeight()){
                left.leftRotate();
            }
            rightRotate();
        }
    }

    public AVLNode search(int value){
        if (value == this.value){
            return this;
        }else if (value < this.value){
            if (this.left == null){
                return null;
            }
            return this.left.search(value);
        }else {
            if (this.right == null){
                return null;
            }
            return this.right.search(value);
        }
    }

    public AVLNode searchParent(int value){
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)){
            return this;
        }else {
            if (value < this.value && this.left != null){
                return this.left.searchParent(value);
            }else if (value >= this.value && this.right != null){
                return this.right.searchParent(value);
            }else {
                return null;
            }
        }
    }


    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }

    //左旋转
    private void leftRotate(){
        //创建节点，以当前根节点的值创建
        AVLNode newNode = new AVLNode(value);
        //把新的的节点的左子树设置成当前节点的左子树
        newNode.left = left;
        //把新的节点的右子树设置成当前节点的右子树的左子树
        newNode.right = right.left;
        //把当前节点的值替换成右子节点的值
        value = right.value;
        //把当前节点的右子树设置成右子树的右子树
        right = right.right;
        //把当前节点的左子树设置成新的节点
        left = newNode;
    }
    //右旋转
    private void rightRotate(){
        //创建节点，以当前根节点的值创建
        AVLNode newNode = new AVLNode(value);
        //把新的的节点的右子树设置成当前节点的又子树
        newNode.right = right;
        //把新的节点的左子树设置成当前节点的左子树的右子树
        newNode.left = left.right;
        //把当前节点的值替换成左子节点的值
        value = left.value;
        //把当前节点的左子树设置成左子树的左子树
        left = left.left;
        //把当前节点的右子树设置成新的节点
        right = newNode;
    }

    @Override
    public String toString() {
        return "AVLNode{" +
                "value=" + value +
                '}';
    }
}
