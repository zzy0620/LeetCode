package scu.edu.cn.offer;

import java.util.*;

/**
 * @program: leetcode
 * @description: 从上到下打印二叉树
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * @author: zzy
 * @create: 2021-03-27 16:11
 **/
public class PrintBinaryTreeFromTop2BottomII {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        node.left = node1;
        node.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(new PrintBinaryTreeFromTop2BottomII().levelOrder(node));
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        List<Integer> oneLevel = new ArrayList<>();
        oneLevel.add(root.val);
        result.add(oneLevel);
        bfs(result,1,root.left,root.right);
        return result;
    }

    public void bfs(List<List<Integer>> result,int level,TreeNode left,TreeNode right){
        if (left == null && right == null){
            return;
        }
        List<Integer> list;
        if (result.size()>level){
            list = result.get(level);
        }else {
            list = new ArrayList<>();
            result.add(list);
        }
        if (left != null){
            list.add(left.val);
            bfs(result,level+1,left.left,left.right);
        }
        if (right != null){
            list.add(right.val);
            bfs(result,level+1,right.left,right.right);
        }
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }

}
