package scu.edu.cn.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * @author: zzy
 * @create: 2021-03-25 14:26
 **/
public class ReconstructBinaryTree {
    private static Map<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        print(buildTree(preorder, inorder));
    }
    //思路：
    //前序遍历的首元素 为 树的根节点 node 的值。
    //在中序遍历中搜索根节点 node 的索引 ，可将 中序遍历 划分为 [ 左子树 | 根节点 | 右子树 ]
    //根据中序遍历中的左 / 右子树的节点数量，可将 前序遍历 划分为 [ 根节点 | 左子树 | 右子树 ]
    //我们使用前序第一个节点找到根节点，在中序中找到根节点的位置，由此可以确定 左子树的节点个数和右子树的节点个数
    //使用left代表子树的左边界,right代表子树的有边界 如果 left>right，代表越界
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i],i);
        }
        return myBuildTree(preorder,0,n-1,0,n-1);
    }

    public static TreeNode myBuildTree(int[] preorder,int pre_left,int pre_right,int in_left,int in_right){
        if (pre_left > pre_right){
            return null;
        }
        //找到根节点即前序遍历中的第一个节点 pre_left下标表示
        TreeNode root = new TreeNode(preorder[pre_left]);
        //在中序中找到根节点下标
        int inorder_root_index = map.get(preorder[pre_left]);
        //左子树节点个数
        int left_tree_size = inorder_root_index - in_left;
        //递归找到左子树
        root.left = myBuildTree(preorder,pre_left+1,pre_left+left_tree_size,in_left,inorder_root_index-1);
        //递归找右子树
        root.right = myBuildTree(preorder,pre_left+left_tree_size+1,pre_right,inorder_root_index+1,in_right);
        return root;
    }

    public static void print(TreeNode root){
        if (root == null){
            return;
        }
        System.out.println(root.val);
        print(root.left);
        print(root.right);
    }
}
