package scu.edu.cn.datastructure.hash;

import java.util.Scanner;

/**
 * @program: DataStructures
 * @description: 哈希表
 * @author: zzy
 * @create: 2021-03-10 10:19
 **/
public class HashTableTest {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add:添加雇员");
            System.out.println("del:删除雇员");
            System.out.println("list:显示雇员");
            System.out.println("find：查找雇员");
            System.out.println("exit：退出");

            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入姓名");
                    String name = scanner.next();
                    Emp emp = new Emp(id,name);
                    hashTable.add(emp);
                    break;
                case "del":
                    System.out.println("输入id");
                    id = scanner.nextInt();
                    hashTable.deleteEmpById(id);
                    break;
                case "find":
                    System.out.println("输入id");
                    int EmpId = scanner.nextInt();
                    hashTable.findEmpById(EmpId);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
            }
        }
    }
}

class HashTable{
    private EmpLinkedList[] empLinkedLists;
    private int size;

    public HashTable(int size) {
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];
        //注意：要分别初始化每一条链表，否则会报空指针
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp){
        //根据员工id得到散列值即要添加到哪条列表
        int empLinkedListNo = hashFun(emp.getId());
        empLinkedLists[empLinkedListNo].add(emp);
    }

    public void deleteEmpById(int id){
        int empLinkedListNo = hashFun(id);
        empLinkedLists[empLinkedListNo].deleteEmpById(id);
    }

    public void findEmpById(int id){
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedLists[empLinkedListNo].findEmpById(id);
        if (emp == null){
            System.out.println("在哈希表中没有找到该浒关");
        }else {
            System.out.println("在第"+(empLinkedListNo+1)+"条哈希表中找到该雇员:"+emp);
        }

    }

    public void list(){
        for (int i=0 ;i<empLinkedLists.length;i++) {
            System.out.println("第"+(i+1)+"条链表结果:");
            empLinkedLists[i].list();
            System.out.println("============================");
        }
    }

    //使用取模法
    private int hashFun(int id){
        return id%size;
    }
}

class Emp{
    private int id;
    private String name;
    public Emp next;

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class EmpLinkedList{
    //头指针，指向第一个Emp，因此这个head直接指向第一个Emp
    private Emp head;

    //默认添加到最后
    public void add(Emp emp){
        //如果是第一个雇员
        if (head == null){
            head = emp;
        }else {
            Emp temp = head;
            while (temp.next  != null){
                temp = temp.next;
            }
            temp.next = emp;
        }
    }

    public void deleteEmpById(int id){
        if (head == null){
            System.out.println("链表为空");
            return;
        }
        Emp temp = head;
        if (temp.getId() == id){
            head = temp.next;
        }else {
            while (temp.next!=null && temp.next.getId() != id){
                temp = temp.next;
            }
            if (temp.next != null){
                temp.next = temp.next.next;
            }
        }
    }

    //根据id查找雇员
    public Emp findEmpById(int id){
        if (head == null){
            System.out.println("链表为空");
            return null;
        }
        Emp temp = head;
        while (temp != null && temp.getId() != id){
            temp = temp.next;
        }
        return temp;
    }

    public void list(){
        if (head == null){
            System.out.println("当前链表为空");
            return;
        }
        Emp temp = head;
        while (temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }
}