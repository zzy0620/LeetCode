package scu.edu.cn.list;


//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//        示例：
//
//        输入：1->2->4, 1->3->4
//        输出：1->1->2->3->4->4

public class MergeTwoListNodes {
//    迭代思想
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        int length1 = 0;
        int length2 = 0;
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        while (temp1 != null){
            length1++;
            temp1 = temp1.next;
        }
        while (temp2 != null){
            length2++;
            temp2 = temp2.next;
        }
        ListNode result;
        if (length1==0 && length2>0){
            return l2;
        }else if(length1 >0 &&length2 ==0){
            return l1;
        }else if (length2 == 0 && length1 == 0){
            return null;
        }else {
            ListNode iterator;
            if (l1.val>l2.val){
                iterator = l2;
                result = iterator;
                l2 = l2.next;
            }else {
                iterator = l1;
                result = iterator;
                l1 = l1.next;
            }
            while (l1!=null && l2!=null){
                if (l1.val <= l2.val){
                    iterator.next = l1;
                    l1 = l1.next;
                }else {
                    iterator.next = l2;
                    l2 = l2.next;
                }
                iterator = iterator.next;
            }
            while (l1 != null){
                iterator.next = l1;
                l1 = l1.next;
                iterator = iterator.next;
            }
            while (l2 != null){
                iterator.next = l2;
                l2 = l2.next;
                iterator = iterator.next;
            }
        }
        return result;
    }
//    递归思想
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }

    }
//  迭代法
    public ListNode mergeTwoLists2(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
//        node1.next = new ListNode(2);
//        node1.next.next = new ListNode(4);
        ListNode node2 = new ListNode(1);
//        node2.next = new ListNode(3);
//        node2.next.next = new ListNode(4);
        ListNode nn = new MergeTwoListNodes().mergeTwoLists(node1,node2);
        while (nn!=null){
            System.out.println(nn.val);
            nn= nn.next;
        }
    }
}
