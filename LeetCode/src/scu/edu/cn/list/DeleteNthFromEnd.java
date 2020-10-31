package scu.edu.cn.list;

import java.util.ArrayList;
import java.util.List;

//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
//        示例：
//        给定一个链表: 1->2->3->4->5, 和 n = 2.
//        当删除了倒数第二个节点后，链表变为 1->2->3->5.
//        说明：
//
//        给定的 n 保证是有效的。

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class DeleteNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        list.remove(list.size()-n);
        if (list.size() == 0){
            return null;
        }
        List<ListNode> listNodeList = new ArrayList<>();
        for (Integer integer : list) {
            listNodeList.add(new ListNode(integer));
        }
        for (int i=0;i<listNodeList.size()-1;i++) {
            listNodeList.get(i).next = listNodeList.get(i+1);
        }
        return listNodeList.get(0);
    }

    public ListNode removeNthFromEnd2(ListNode head, int n){
        ListNode result = new ListNode(0,head);
        ListNode copy = head;
        int length = 0;
        while (copy != null){
            length++;
            copy = copy.next;
        }
        if (length == 0 || length==1&&n==1){
            return null;
        }

        ListNode temp = result;
        for (int i = 1; i < length-n+1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
//        l.next.next = new ListNode(3);
//        l.next.next.next = new ListNode(4);
//        l.next.next.next.next = new ListNode(5);
        ListNode ll = new DeleteNthFromEnd().removeNthFromEnd2(l,1);
        while (ll !=null){
            System.out.println(ll.val);
            ll = ll.next;
        }
    }
}
