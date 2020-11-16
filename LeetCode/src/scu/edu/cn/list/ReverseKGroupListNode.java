package scu.edu.cn.list;


//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//
//        k 是一个正整数，它的值小于或等于链表的长度。
//
//        如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
//         
//
//        示例：
//
//        给你这个链表：1->2->3->4->5
//
//        当 k = 2 时，应当返回: 2->1->4->3->5
//
//        当 k = 3 时，应当返回: 3->2->1->4->5

import java.util.ArrayList;
import java.util.List;

public class ReverseKGroupListNode {
//    借助List进行K个组翻转列表
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = new ListNode(-1);
        List<ListNode> listNodes = new ArrayList<>();
        pre.next = head;
        int length = 0;
        while (head != null){
            listNodes.add(head);
            length++;
            head = head.next;
        }
        if (length == 0 || length == 1){
            return pre.next;
        }
        int iteratorNum = length / k;
        for (int i=0;i<iteratorNum;i++){
            int left=i*k;
            ListNode temp;
            int right = (i+1)*k-1;
            while (left < right){
                temp = listNodes.get(left);
                listNodes.set(left,listNodes.get(right));
                listNodes.set(right,temp);
                left++;
                right--;
            }
        }
        for (int i = 0; i < listNodes.size(); i++) {
            if (i+1 == listNodes.size()){
                listNodes.get(i).next = null;
            }else {
                listNodes.get(i).next = listNodes.get(i+1);
            }
        }
        return listNodes.get(0);
    }

//    不借助List进行K个组翻转列表
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
//            找到每个组的末节点
            for (int i = 0; i < k && end != null; i++){
                end = end.next;
            }

            if (end == null) break;

            ListNode start = pre.next;
//            保留下一组的头结点坐标
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;

            end = pre;
        }
        return dummy.next;
    }
//思想：   1->2->3  =>    1<-2 3  =>   1<-2<-3  从链表头到尾逐一进行翻转
//    上一个  pre  当前 curr 下一个 next
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode result = new ReverseKGroupListNode().reverseKGroup(node,5);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

}
