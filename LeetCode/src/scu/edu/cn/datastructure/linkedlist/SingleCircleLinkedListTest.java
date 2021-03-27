package scu.edu.cn.datastructure.linkedlist;

/**
 * @program: DataStructures
 * @description: 单向环形链表
 * @author: zzy
 * @create: 2021-03-06 15:17
 **/
public class SingleCircleLinkedListTest {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        SingleCircleLinkedList singleCircleLinkedList = new SingleCircleLinkedList();
        singleCircleLinkedList.addNode(node1);
        singleCircleLinkedList.addNode(node2);
        singleCircleLinkedList.addNode(node3);
        singleCircleLinkedList.addNode(node4);
        singleCircleLinkedList.addNode(node5);
        singleCircleLinkedList.list();
        singleCircleLinkedList.deleteNode(1);
        System.out.println("==========================");
        singleCircleLinkedList.list();
        singleCircleLinkedList.deleteNode(5);
        System.out.println("==========================");
        singleCircleLinkedList.list();
        singleCircleLinkedList.deleteNode(2);
        singleCircleLinkedList.deleteNode(3);
        singleCircleLinkedList.deleteNode(4);
        System.out.println("==========================");
        singleCircleLinkedList.list();
    }
}

class SingleCircleLinkedList{
    private Node first = null;
    private Node cur = null;

    public void addNode(Node node){
        if (first == null){
            first = node;
            cur = first;
            first.next = first;
        }else {
            cur.next = node;
            node.next = first;
            cur = node;
        }
    }

    public void deleteNode(int no){
        if (first == null){
            System.out.println("链表为空,不能进行删除");
            return;
        }
        //如果只有一个节点，并且该节点是要被删除的节点
        if (first.next.no == first.no && first.no == no){
            first = null;
            cur = null;
            return;
        }
        //要删除头结点
        if (first.no == no){
            cur.next = first.next;
            first = first.next;
            return;
        }
        Node temp = first;
        boolean flag = false;
        while (temp.next.no != first.no){
           if (temp.next.no == no){
               flag = true;
               break;
           }
           temp = temp.next;
        }
        if (flag){
            if (temp.next.no == cur.no){
                cur = temp;
                cur.next = first;
            }else {
                temp.next = temp.next.next;
            }
        }
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