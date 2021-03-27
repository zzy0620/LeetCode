package scu.edu.cn.datastructure.tree;

/**
 * @program: DataStructures
 * @description: 二叉排序树
 * @author: zzy
 * @create: 2021-03-12 14:40
 **/
public class BinarySortTreeTest {
    public static void main(String[] args) {
        int[] arr = {7,3,10,12,5,1,9,2};

        BinarySortTree binarySortTree = new BinarySortTree();
        for (int value : arr) {
            binarySortTree.add(new TreeNode(value));
        }
//        binarySortTree.infixOrder();
        binarySortTree.delNode(2);
        binarySortTree.delNode(5);
        binarySortTree.delNode(9);
        binarySortTree.delNode(12);
        binarySortTree.delNode(7);
        binarySortTree.delNode(3);
        binarySortTree.delNode(10);
        binarySortTree.delNode(1);
        binarySortTree.infixOrder();
    }
}

class BinarySortTree{
    private TreeNode root;

    public void add(TreeNode node){
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

    public TreeNode searchNode(int value){
        if (root == null){
            return null;
        }
        return root.search(value);
    }

    public TreeNode searchParentNode(int value){
        if (root == null){
            return null;
        }
        return root.searchParent(value);
    }

    public void delNode(int value){
        if (root == null){
            return;
        }
        TreeNode target = searchNode(value);
        if (target == null){
            return;
        }
        if (root.left == null && root.right == null){
            root = null;
            return;
        }
        TreeNode parent = searchParentNode(value);

        if (target.left == null &&  target.right == null){//如果是叶子结点
            if (parent.left == target){
                parent.left = null;
            }else {
                parent.right = null;
            }
        }else if (target.left != null &&  target.right != null){
            TreeNode temp = target.right;
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

}

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public void add(TreeNode node){
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
    }

    public TreeNode search(int value){
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

    public TreeNode searchParent(int value){
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

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }
}
