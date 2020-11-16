package scu.edu.cn.list;

import java.util.ArrayList;
import java.util.List;

//
//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
//        你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
public class SwapListNode {
    public ListNode swapPairs(ListNode head) {
        ListNode listNode = head;
        List<ListNode> listNodes = new ArrayList<>();
        while (listNode!=null){
            listNodes.add(listNode);
            listNode = listNode.next;
        }

        if (listNodes.size() == 0 || listNodes.size() == 1){
            return head;
        }

        int iteratorNum = listNodes.size()/2;
        ListNode temp;
        for (int i=0;i<iteratorNum;i++){
            temp = listNodes.get(2*i);
            listNodes.set(i*2,listNodes.get(i*2+1));
            listNodes.set(i*2+1,temp);
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

//    迭代法
//创建哑结点 dummyHead，令 dummyHead.next = head。令 temp 表示当前到达的节点，初始时 temp = dummyHead。
// 每次需要交换 temp 后面的两个节点。
//
//    如果 temp 的后面没有节点或者只有一个节点，则没有更多的节点需要交换，因此结束交换。
//    否则，获得 temp 后面的两个节点 node1 和 node2，通过更新节点的指针关系实现两两交换节点。
//
//    具体而言，交换之前的节点关系是 temp -> node1 -> node2，交换之后的节点关系要变成 temp -> node2 -> node1，
//    因此需要进行如下操作。
//    temp.next = node2
//    node1.next = node2.next
//    node2.next = node1
//    完成上述操作之后，节点关系即变成 temp -> node2 -> node1。再令 temp = node1，对链表中的其余节点进行两两交换，直到全部节点都被两两交换。
//
//    两两交换链表中的节点之后，新的链表的头节点是 dummyHead.next，返回新的链表的头节点即可。
    public ListNode swapPairs2(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode result = new SwapListNode().swapPairs(node);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
