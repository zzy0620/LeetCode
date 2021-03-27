package scu.edu.cn.datastructure.linkedlist;

/**
 * @program: DataStructures
 * @description:双向链表
 * @author: zzy
 * @create: 2021-03-06 14:24
 **/
public class DoubleLinkedListTest {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        HeroNode2 node1 = new HeroNode2(1,"宋江");
        HeroNode2 node2 = new HeroNode2(2,"卢俊义");
        HeroNode2 node3 = new HeroNode2(3,"吴用");
        HeroNode2 node4 = new HeroNode2(4,"林冲");
        doubleLinkedList.addNode(node1);
        doubleLinkedList.addNode(node2);
        doubleLinkedList.addNode(node3);
        doubleLinkedList.addNode(node4);
        doubleLinkedList.list();
//        HeroNode2 newNode4 = new HeroNode2(2,"小卢");
//        doubleLinkedList.updateNode(newNode4);
//        doubleLinkedList.list();

        doubleLinkedList.deleteNode(2);
        doubleLinkedList.list();
        doubleLinkedList.deleteNode(4);
        doubleLinkedList.list();
        doubleLinkedList.deleteNode(1);
        doubleLinkedList.deleteNode(3);
        doubleLinkedList.list();
    }
}

class DoubleLinkedList{
    private HeroNode2 head = new HeroNode2(0,"");

    public HeroNode2 getHead() {
        return head;
    }

    public void list(){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void addNode(HeroNode2 node){
        //不考虑编号的顺序时，照道当前链表的最后节点，将最后节点的next指向新的节点
        HeroNode2 temp = head;
        //便遍历
        while (temp.next != null) {
            //找到链表的最后一个节点
            //没找到将temp后移
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    public void updateNode(HeroNode2 node){
        if (head.next == null){
            System.out.println("链表为空,无法修改");
            return;
        }
        HeroNode2 temp = head.next;
        while (temp != null && temp.getNo() != node.getNo()){
            temp = temp.next;
        }
        if (temp != null){
            temp.setName(node.getName());
        }else {
            System.out.println("没有找到编号为:"+node.getNo()+"的节点");
        }
    }

    public void deleteNode(int no){
        if (head.next == null){
            System.out.println("链表为空,无法删除");
            return;
        }
        HeroNode2 temp = head.next;
        while (temp != null){
            if (temp.getNo() == no){
                break;
            }
            temp = temp.next;
        }
        if (temp != null){
            temp.pre.next = temp.next;
            //如果是最后一个节点就不需要temp.next.pre = temp.pre，否则会报空指针
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }
        }else {
            System.out.println("要删除的节点不存在");
        }
    }
}

class HeroNode2{
    public int no;
    public String name;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name) {
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

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}

