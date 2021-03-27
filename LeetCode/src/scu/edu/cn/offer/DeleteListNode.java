package scu.edu.cn.offer;

/**
 * @program: leetcode
 * @description: 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * @author: zzy
 * @create: 2021-03-25 21:07
 **/
public class DeleteListNode {
    public static void main(String[] args) {

    }
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null){
            return null;
        }
        if (head.val == val){
            return head.next;
        }
        ListNode temp = head;
        while (temp.next != null){
            if (temp.next.val == val){
                temp.next = temp.next.next;
                return head;
            }
            temp = temp.next;
        }
        return head;
    }
}
