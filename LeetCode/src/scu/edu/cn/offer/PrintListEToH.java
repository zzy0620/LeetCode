package scu.edu.cn.offer;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）
 * @author: zzy
 * @create: 2021-03-25 14:18
 **/
public class PrintListEToH {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        head.next = node1;
        node1.next = node2;
        System.out.println(Arrays.toString(reversePrint(head)));
    }
    public static int[] reversePrint(ListNode head) {
        if (head == null){
            return new int[0];
        }
        ListNode temp = head;
        int nodeNum = 0;
        while (temp != null){
            nodeNum++;
            temp = temp.next;
        }
        int[] result = new int[nodeNum];
        for (int i = nodeNum-1; i >= 0; i--) {
            result[i] = head.val;
            head = head.next;
        }
        return result;
    }
}
