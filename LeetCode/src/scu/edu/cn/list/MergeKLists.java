package scu.edu.cn.list;

public class MergeKLists {
//    顺序合并 mergeKLists和mergeKLists1
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        int i=0;
        int length = lists.length;
        result = mergeTwo(result,lists,i,length);
        return result;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode result = null;
        for (int i = 0; i < lists.length; i++) {
            result = mergeTwoLists1(result, lists[i]);
        }
        return result;
    }

//    分而治之 mergeKLists2
    public ListNode mergeKLists2(ListNode[] lists){
        if (lists == null || lists.length == 0){
            return null;
        }
        int length = lists.length;
        int iteratorNum = (int) Math.ceil(lists.length/2.0);
        for (int i=0;i<=iteratorNum;i++){
            lists = merge(lists,length);
            length = (int) Math.ceil(length/2.0);
        }
        return lists[0];
    }

    public ListNode mergeTwo(ListNode result ,ListNode[] lists,int i,int length){
        if (i<=length-1){
            result = mergeTwoLists1(result,lists[i]);
            result = mergeTwo(result,lists,i+1,length);
        }
        return result;
    }
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
    public ListNode[]  merge(ListNode[] lists,int length){
        for (int i=0;i<length/2;i++){
            lists[i] = mergeTwoLists1(lists[i],lists[length-i-1]);
        }
        return lists;
    }

    public static void main(String[] args) {
//        ListNode node1 = new ListNode(1);
//        node1.next = new ListNode(4);
//        node1.next.next = new ListNode(5);
//        ListNode node2 = new ListNode(1);
//        node2.next = new ListNode(3);
//        node2.next.next = new ListNode(4);
//        ListNode node3 = new ListNode(2);
//        node3.next = new ListNode(6);
//        ListNode[] listNodes = new ListNode[]{node1,node2,node3};
        ListNode[] listNodes = new ListNode[]{};
        ListNode l = new MergeKLists().mergeKLists2(listNodes);
        while (l!=null){
            System.out.println(l.val);
            l = l.next;
        }

    }
}
