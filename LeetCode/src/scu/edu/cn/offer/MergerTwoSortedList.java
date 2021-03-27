package scu.edu.cn.offer;

/**
 * @program: leetcode
 * @description: 合并两个排序的链表
 * @author: zzy
 * @create: 2021-03-25 22:16
 **/
public class MergerTwoSortedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;

        node4.next = node5;
        node5.next = node6;

        ListNode head  = mergeTwoLists(node1,node4);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l1 != null && l2 != null){
            int val1 =l1.val;
            int val2 =l2.val;
            if (val1 < val2){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1:l2;
        return head.next;
    }
}
