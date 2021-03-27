package scu.edu.cn.datastructure.stack;

import java.util.Scanner;

/**
 * @program: DataStructures
 * @description: 数组模拟栈
 * @author: zzy
 * @create: 2021-03-06 20:16
 **/
public class ArrStackTest {
    public static void main(String[] args) {
        ArrStack arrStack = new ArrStack(5);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("show:表示显示栈");
            System.out.println("exit:退出程序");
            System.out.println("pop:表示从栈取数据");
            System.out.println("push:表示添加数据到栈");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key){
                case "show":
                    arrStack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    arrStack.push(value);
                    break;
                case "pop":
                    try {
                        int val = arrStack.pop();
                        System.out.println("出栈的数据是："+val);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

class ArrStack{
    private int maxSize;//站的大小
    private int[] stack;//
    private int top = -1; // 栈顶，初始化为-1

    public ArrStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull(){
        return top == maxSize-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if (isFull()){
            System.out.println("栈满，不能入栈");
            return;
        }
        stack[++top] = value;
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空，不能出栈");
        }
        return stack[top--];
    }

    public void list(){
        if (isEmpty()){
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0 ; i--) {
            System.out.printf("stack[%d]=%d \t",i,stack[i]);
        }
    }
}