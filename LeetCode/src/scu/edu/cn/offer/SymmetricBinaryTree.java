package scu.edu.cn.offer;

import com.sun.corba.se.pept.encoding.InputObject;

import java.util.Stack;

/**
 * @program: leetcode
 * @description:  对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * @author: zzy
 * @create: 2021-03-27 14:40
 **/
public class SymmetricBinaryTree {
    public static void main(String[] args) {

    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return recur(root.left, root.right);
    }

    public boolean recur(TreeNode left,TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null || left.val != right.val) return false;
        return recur(left.left,right.right) && recur(left.right,right.left);
    }

}
