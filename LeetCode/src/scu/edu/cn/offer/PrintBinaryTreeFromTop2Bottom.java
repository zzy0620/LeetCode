package scu.edu.cn.offer;

import java.util.*;

/**
 * @program: leetcode
 * @description: 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * @author: zzy
 * @create: 2021-03-27 16:11
 **/
public class PrintBinaryTreeFromTop2Bottom {
    public static void main(String[] args) {

    }
    public int[] levelOrder(TreeNode root) {
        if (root == null){
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            list.add(treeNode.val);
            if (treeNode.left != null) queue.offer(treeNode.left);
            if (treeNode.right != null) queue.offer(treeNode.right);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
