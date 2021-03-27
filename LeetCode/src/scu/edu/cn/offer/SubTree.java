package scu.edu.cn.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode
 * @description: 数的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * @author: zzy
 * @create: 2021-03-26 20:00
 **/
public class SubTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node4.left = node5;
        System.out.println(new SubTree().isSubStructure(node1, node4));
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        TreeNode node = null;
        while (!queue.isEmpty()){
            node = queue.poll();
            if (node.val == B.val){
                if (preOrderCompare(B,node)){
                    return true;
                }
            }
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
        return false;
    }

    public boolean preOrderCompare(TreeNode template,TreeNode compare){
        if (template == null){
            return true;
        }
        if (compare == null){
            return false;
        }
        if (template.val == compare.val){
            boolean left = preOrderCompare(template.left,compare.left);
            boolean right = preOrderCompare(template.right,compare.right);
            return left & right;
        }
        return false;
    }

}
