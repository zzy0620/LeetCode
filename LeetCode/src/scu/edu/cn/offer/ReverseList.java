package scu.edu.cn.offer;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * @author: zzy
 * @create: 2021-03-25 21:49
 **/
public class ReverseList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode newNode = reverseList2(node1);
        while (newNode != null){
            System.out.println(newNode.val);
            newNode = newNode.next;
        }
    }
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head!=null){
            stack.add(head);
            head = head.next;
        }
        ListNode newHead = stack.pop();
        ListNode cur = stack.pop();
        newHead.next = cur;
        while (!stack.empty()){
            cur.next = stack.pop();
            cur = cur.next;
        }
        cur.next = null;
        return newHead;
    }

    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode cur = head.next;
        ListNode next = null;
        head.next = null;
        while (cur != null){
            //防止断链
            next = cur.next;
            cur.next = head;
            head = cur;
            cur = next;
        }
        return head;
    }
}
