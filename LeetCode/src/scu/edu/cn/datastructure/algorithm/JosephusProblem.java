package scu.edu.cn.datastructure.algorithm;

/**
 * @program: DataStructures
 * @description: 约瑟夫问题
 * @author: zzy
 * @create: 2021-03-06 16:40
 **/
public class JosephusProblem {
    public static void main(String[] args) {
        SingleCircleLinkedList singleCircleLinkedList = new SingleCircleLinkedList();
        singleCircleLinkedList.addNode(10);
        singleCircleLinkedList.list();
        singleCircleLinkedList.countNode(2,3);
    }

}

class SingleCircleLinkedList{
    private Node first = null;

    public void addNode(int num){
        Node cur = null;
        for (int i = 1; i <= num; i++) {
            Node node = new Node(i);
            if (i == 1){
                first = node;
                first.next = first;
                cur = first;
            }else {
                cur.next = node;
                node.next = first;
                cur = node;
            }
        }
    }

    // startNo  countNum  nums
    public void countNode(int startNo,int countNum){
        //创建一个辅助指针helper，事先指向环形链表的最后一个节点
        Node helper = first;

        while (helper.next != first) {
            helper = helper.next;
        }
        //报数前，让first和helper移动k-1次
        for (int i = 0; i < startNo-1; i++) {
            first = first.next;
            helper = helper.next;
        }
        //当报数时，让first指针和helper指针同时移动m-1次，直到全中只有一个节点
        while (helper != first) {
            for (int i = 0; i < countNum - 1; i++) {
                first = first.next;
                helper = helper.next;
            }
            //这时，将first指向的节点出圈
            System.out.println("节点:" + first.no + "出圈");
            first = first.next;
            helper.next = first;
        }
        System.out.println("最后留在圈中的节点编号:"+first.no);
    }

    public void list(){
        if (first == null){
            System.out.println("链表为空");
            return;
        }
        Node temp = first;
        do {
            System.out.println(temp);
            temp = temp.next;
        }while (temp.no != first.no);
    }
}

class Node{
    public int no;//编号
    public Node next; //指向下一个节点

    public Node(int no){
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }

}
