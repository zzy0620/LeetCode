package scu.edu.cn.offer;

/**
 * @program: leetcode
 * @description: 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点
 * @author: zzy
 * @create: 2021-03-25 21:45
 **/
public class LastKNode {
    public static void main(String[] args) {
    }
    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null){
            return null;
        }
        ListNode temp = head;
        int length = 0;
        while (temp!=null){
            length++;
            temp = temp.next;
        }
        for (int i=0;i<length-k;i++){
            head = head.next;
        }
        return head;
    }
}
