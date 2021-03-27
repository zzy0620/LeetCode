package scu.edu.cn.datastructure.linkedlist;

import java.util.Stack;

/**
 * @program: DataStructures
 * @description: 单链表
 * @author: zzy
 * @create: 2021-03-05 14:58
 **/
public class SingleLinkedListTest {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode node1 = new HeroNode(1,"宋江");
        HeroNode node2 = new HeroNode(2,"卢俊义");
        HeroNode node3 = new HeroNode(3,"吴用");
        HeroNode node4 = new HeroNode(4,"林冲");
//        singleLinkedList.addNode(node1);
//        singleLinkedList.addNode(node2);
//        singleLinkedList.addNode(node3);
//        singleLinkedList.addNode(node4);

        singleLinkedList.addNodeByNo(node1);
        singleLinkedList.addNodeByNo(node4);
        singleLinkedList.addNodeByNo(node2);
        singleLinkedList.addNodeByNo(node3);
        singleLinkedList.showList();
//        singleLinkedList.reversePrintByRecursion(singleLinkedList.getHead());
//        singleLinkedList.reverseLinkedList(singleLinkedList.getHead());
//        singleLinkedList.showList();
//        System.out.println("============================");
//        singleLinkedList.deleteNode(1);
//        System.out.println(singleLinkedList.getLength(singleLinkedList.getHead()));
//        singleLinkedList.deleteNode(2);
//        System.out.println(singleLinkedList.getLength(singleLinkedList.getHead()));
//        singleLinkedList.deleteNode(4);
//        singleLinkedList.deleteNode(3);
//        singleLinkedList.showList();
//        HeroNode newNode2 = new HeroNode(5,"老卢");
//        singleLinkedList.updateNode(newNode2);
//        singleLinkedList.showList();
//        System.out.println(singleLinkedList.findLastIndexNode(singleLinkedList.getHead(),4));
        singleLinkedList.reverseLinkedList(singleLinkedList.getHead());
        singleLinkedList.showList();
    }
}

class SingleLinkedList{
    //初始化头节点
    private HeroNode head = new HeroNode(0,null); //头节点不能动

    public void addNode(HeroNode node){
        //不考虑编号的顺序时，照道当前链表的最后节点，将最后节点的next指向新的节点
        HeroNode temp = head;
        //便遍历
        while (true){
            //找到最后链表
            if (temp.getNext() == null){
                break;
            }
            //没找到将temp后移
            temp = temp.getNext();
        }
        temp.setNext(node);
    }

    public HeroNode getHead() {
        return head;
    }

    public HeroNode findLastIndexNode(HeroNode head,int index){
        if (head.getNext() == null){
            return null;
        }
        int size = getLength(head);
        if (index <=0 || index > size){
            return null;
        }
        HeroNode cur = head.getNext();
        for (int i=0;i<size-index;i++){
            cur = cur.getNext();
        }
        return cur;
    }

    public void reverseLinkedList(HeroNode head){
        if (head.getNext() == null || head.getNext().getNext() == null){
            return;
        }
        HeroNode reverseNode = new HeroNode(0,null);
        HeroNode cur = head.getNext();
        HeroNode next = null;
        while (cur !=null){
            //记录节点，否则会出现断链
            next = cur.getNext();
            //将cur下一个节点指向新的链表头部
            cur.setNext(reverseNode.getNext());
            reverseNode.setNext(cur);
            cur = next;
        }
        head.setNext(reverseNode.getNext());
    }

    public void reversePrint(HeroNode head){
        if (head.getNext() == null){
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = head.getNext();
        while (temp != null){
            stack.push(temp);
            temp = temp.getNext();
        }
        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }

    public void reversePrintByRecursion(HeroNode head){
        if (head.getNext() == null){
            return;
        }
        recursionPrint(head.getNext());
    }
    public void recursionPrint(HeroNode node){
        if (node.getNext() != null){
            recursionPrint(node.getNext());
        }
        System.out.println(node);
    }

    public void addNodeByNo(HeroNode node){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.getNext() == null){ //temp已经在链表的最后
                break;
            }
            if (temp.getNext().getNo() > node.getNo()){//位置已经找到
                break;
            }else if (temp.getNext().getNo() == node.getNo()){
                flag = true;
                break;
            }else {
                temp = temp.getNext();
            }
        }
        if (flag){
            System.out.println("准备插入的英雄的编号 "+node.getNo()+" 已经存在,不能再加入");
        }else {
            node.setNext(temp.getNext());
            temp.setNext(node);
        }
    }

    //修改节点信息，根据no编号修改
    public void updateNode(HeroNode node){
        if (head.getNext() == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.getNext();
        while (temp != null && temp.getNo() != node.getNo()){
            temp = temp.getNext();
        }
        if (temp != null){
            temp.setName(node.getName());
        }else {
            System.out.println("没有找到编号为:"+node.getNo()+"的节点");
        }
    }

    public void deleteNode(int no){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.getNext() == null){ //已经到链表的最后
                break;
            }
            if (temp.getNext().getNo() == no){
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag){
            temp.setNext(temp.getNext().getNext());
        }else {
            System.out.println("要删除的节点不存在");
        }
    }

    public void showList(){
        //判断链表是否为空
        if (head.getNext() == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.getNext();
        while (temp != null){
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    public int getLength(HeroNode head){
        if (head.getNext() == null){
            return 0;
        }
        int length = 0;
        HeroNode node = head.getNext();
        while (node != null){
            length ++;
            node = node.getNext();
        }
        return length;
    }
}

class HeroNode{
    private int no;
    private String name;
    private HeroNode next;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
