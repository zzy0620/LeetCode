package scu.edu.cn.list;

import java.util.ArrayList;
import java.util.List;

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}

public class TwoNumSum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        if (l1 !=null){
            while(l1 != null){
                list1.add(l1.val);
                l1 = l1.next;
            }
        }
        if (l2 != null){
            while(l2 != null){
                list2.add(l2.val);
                l2 = l2.next;
            }
        }
        int l1Size = list1.size();
        int l2Size = list2.size();
        List<Integer> temp = new ArrayList<>();
        int jinwei = 0;
        if (l1Size>=l2Size){
            for (int i =0;i<l1Size;i++){
                if (i<=l2Size-1){
                    int num = 0;
                    if (jinwei==1){
                        num = list1.get(i)+list2.get(i)+jinwei;
                        jinwei = 0;
                    }else {
                        num = list1.get(i)+list2.get(i);
                    }
                    if (num>=10){
                        temp.add(num-10);
                        jinwei = 1;
                    }else {
                        temp.add(num);
                    }
                }else {
                    if (jinwei==1){
                        int a = list1.get(i)+1;
                        if (a>=10){
                            temp.add(a-10);
                        }else {
                            temp.add(list1.get(i)+1);
                            jinwei = 0;
                        }
                    } else {
                        temp.add(list1.get(i));
                    }
                }

            }
        }
        else {
            for (int j =0;j<l2Size;j++){
                if (j<=l1Size-1){
                    int num = 0;
                    if (jinwei ==1){
                        num = list1.get(j)+list2.get(j) + jinwei;
                        jinwei = 0;
                    }else {
                        num = list1.get(j)+list2.get(j);
                    }
                    if (num >= 10) {
                        temp.add(num - 10);
                        jinwei = 1;
                    }else {
                        temp.add(num);
                    }
                }else {
                    if (jinwei==1){
                        int a = list2.get(j)+1;
                        if (a>=10){
                            temp.add(a-10);
                        }else {
                            temp.add(list2.get(j)+1);
                            jinwei = 0;
                        }
                    }
                    else {
                        temp.add(list2.get(j));
                    }
                }
            }
        }
        if (jinwei == 1){
            temp.add(1);
        }
        List<ListNode> listNodes = new ArrayList<>();
        for(int i = 0;i<temp.size();i++){
            ListNode node = new ListNode(temp.get(i));
            listNodes.add(node);
        }
        for (int i=0;i<listNodes.size()-1;i++) {
            listNodes.get(i).next = listNodes.get(i+1);
        }
        return listNodes.get(0);
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);

        ListNode node2 = new ListNode(5);
        node1.next = new ListNode(6);
        node1.next.next = new ListNode(4);
        ListNode result = new TwoNumSum().addTwoNumbers(node1,node2);
    }
}
